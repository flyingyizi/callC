
# 一. 准备

## 1.1 msys2 环境介绍

安装[msys2](https://mirror.tuna.tsinghua.edu.cn/help/msys2/)，安装包与安装方法见该链接。安装后典型环境包括：

- mingw64环境：

    ```sh
    #use mingw64 as a default chain
    C:\tools\msys64\msys2_shell.cmd -mingw64  
    # install gcc
    $pacman -S  mingw-w64-x86_64-toolchain
    ```

- mingw32环境：C:\tools\msys64\msys2_shell.cmd -mingw32

    ```sh
    #use mingw32 as a default chain
    C:\tools\msys64\msys2_shell.cmd -mingw32  
    ```

- msys环境：C:\tools\msys64\msys2_shell.cmd

    ```sh
    #use msys as a default chain
    C:\tools\msys64\msys2_shell.cmd  
    #install gcc
    $pacman -S  msys2-devel
    ```

其中msys环境下编译的程序是依赖msys-2.0.dll的，而mingw32/64是不依赖，即windows原生支持。因此我们首推采用mingw64作为开发环境。后面的操作都是基于mingw64.

## 1.2 安装实验 lib curl

本次实验是实验golang，kotlin，java调用C library，选择的C library是libcurl，因此先安装它。

```sh
# 实验环境采用mingw64，因此按照对应mingw64 curl包
$pacman -S mingw64/mingw-w64-x86_64-curl

# 查看curl包内容
$pacman -Ql mingw-w64-x86_64-curl
mingw-w64-x86_64-curl /mingw64/
mingw-w64-x86_64-curl /mingw64/bin/
mingw-w64-x86_64-curl /mingw64/bin/curl-config
mingw-w64-x86_64-curl /mingw64/bin/curl.exe
mingw-w64-x86_64-curl /mingw64/bin/libcurl-4.dll
mingw-w64-x86_64-curl /mingw64/include/
mingw-w64-x86_64-curl /mingw64/include/curl/
mingw-w64-x86_64-curl /mingw64/include/curl/curl.h
mingw-w64-x86_64-curl /mingw64/include/curl/curlver.h
...
mingw-w64-x86_64-curl /mingw64/include/curl/urlapi.h
mingw-w64-x86_64-curl /mingw64/lib/
mingw-w64-x86_64-curl /mingw64/lib/libcurl.a
mingw-w64-x86_64-curl /mingw64/lib/libcurl.dll.a
mingw-w64-x86_64-curl /mingw64/lib/pkgconfig/
mingw-w64-x86_64-curl /mingw64/lib/pkgconfig/libcurl.pc
mingw-w64-x86_64-curl /mingw64/share/
...
mingw-w64-x86_64-curl /mingw64/share/man/man3/
...
mingw-w64-x86_64-curl /mingw64/share/man/man3/libcurl-url.3.gz
mingw-w64-x86_64-curl /mingw64/share/man/man3/libcurl.3.gz

tu_xu@desktop MINGW64 /c/tmp/callc/byc
$

```


## 1.3 原生实验代码

实验代码使用[C++ 用libcurl库进行http通讯网络编程](https://www.cnblogs.com/moodlxs/archive/2012/10/15/2724318.html)中的“get_http.c”代码。

libcurl 提供的是C api，因此采用gcc开发是原生开发方式，代码见“byC/get_http.c”，该代码同时也作为其他语言（golang，kotlin，java）实现的参照，它们将各自按照自己语言能力调用libcurl实现相同能力。

编译开发：

```sh
# 编译
tu_xu@desktop MINGW64 /c/tmp/callc/byc
$ gcc get_http.c  -o get_http -lcurl

tu_xu@desktop MINGW64 /c/tmp/callc/byc
$ pkg-config --libs --cflags libcurl
-IC:/tools/msys64/mingw64/include -LC:/tools/msys64/mingw64/lib -lcurl

tu_xu@desktop MINGW64 /c/tmp/callc/byc
$ gcc get_http.c  `pkg-config --libs --cflags libcurl`  -o get_http

tu_xu@desktop MINGW64 /c/tmp/callc/byc
$ ls
get_http.c  get_http.exe

# 检查依赖库
$cygcheck.exe   ./get_http.exe
C:\tmp\callc\byc\get_http.exe
  C:\tools\msys64\mingw64\bin\libcurl-4.dll
    C:\WINDOWS\system32\ADVAPI32.dll
      C:\WINDOWS\system32\msvcrt.dll
...
        C:\WINDOWS\system32\MSVCR100.dll
    C:\tools\msys64\mingw64\bin\libssl-1_1-x64.dll

# 使用举例
$./get_http.exe  www.baidu.com
<!DOCTYPE html><!--STATUS OK-->
<html>
<head>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
...
</body></html>
```

这里凑巧是在开发环境下，所有依赖库都已经有了，如果缺失依赖库，那执行程序将会提示类似`error while loading shared libraries: ...`. 这种情况下，执行`$ cygcheck.exe   ./get_http.exe`的价值才会体现，因为它会告诉具体缺失哪些依赖库。 比如，在另外一个环境下：

```sh
$ cygcheck ./get_http.exe
C:\tmp\callc\byc\get_http.exe
  C:\tools\msys64\mingw64\bin\libcurl-4.dll
...
cygcheck: track_down: could not find libcrypto-1_1-x64.dll

cygcheck: track_down: could not find libssl-1_1-x64.dll
```

提示环境中缺失了libcrypto-1_1-x64.dll，libssl-1_1-x64.dll

# 二. golang实验

## 2.1 unsafe.Pointer 指针 与系统调用专题

[官方文档](https://golang.org/pkg/unsafe/), 官方例子 ${GOROOT}/src/syscall/dll_windows.go

### 类型转换

典型场景： 当使用必须具有与C结构相同的内存布局的系统调用和Go结构时，您可能别无选择，只能诉诸unsafe

使用unsafe.Pointer类型可以绕过Go的类型系统，并可以在任意类型和uintptr内置类型之间进行转换。根据文档，有四种可用的unsafe.Pointer其他类型无法执行的操作：

- 任何类型的指针值都可以转换为unsafe.Pointer。
- unsafe.Pointer可以将an 转换为任何类型的指针值。
- uintptr能被转换为unsafe.Pointer。
- 一个unsafe.Pointer可以转换为一个uintptr。



场景：假设T2不大于T1，并且两个共享相同的内存布局，则此转换允许将一种类型的数据重新解释为另一种类型的数据

```golang
//math.Float64bits 实现
func Float64bits(floatVal float64) uint64 {
	// Take a pointer to the float64 value stored in f.
	floatPtr := &floatVal

	// Convert the *float64 to an unsafe.Pointer.
	unsafePtr := unsafe.Pointer(floatPtr)

	// Convert the unsafe.Pointer to *uint64.
	uintPtr := (*uint64)(unsafePtr)

	// Dereference the *uint64, yielding a uint64 value.
	uintVal := *uintPtr

	return uintVal
}
```

### 系统调用

[官方文档](https://golang.org/pkg/syscall/)

使用系统调用时，有时必须将指向某些内存的指针传递给内核，以允许它执行某些任务。这是unsafe.PointerGo中另一个至关重要的用例。unsafe.Pointer在处理系统调用时必须使用它 ，因为可以将其转换 uintptr为与syscall.Syscall 函数系列一起使用。

例子见“byGO/syspointer/syscall_*.go”


## 2.2 为golang自动生成 C 兼容的结构体，数据类型

[go generate官方文档](https://golang.org/pkg/cmd/go/internal/generate/)

例子见“byGo/wrapper”

当调用的C lib具有大量的类似“struct xx”，“typedef CURLCode int”非原生C数据类型。 而在golang中又需要使用它们。 这种情况可以采用类似`"C.<whatever>"`,然后在golang程序中通过强制类型转换，一边与原生golang类型转换。 这个工作需要大量的手工，并且不可靠，比如在struct的内存布局方面需要非常小心。

在"byGo/wrapper" package中演示了通过`go generate`，以及“go tool cgo -godefs ”来半自动化完成这个工作。当需要生成时，在"byGo/wrapper"目录下执行“go  generate”就会自动生成"godefs_windows_amd64.go",这个文件是后面编译时的文件输入之一。


例如，下面的例子

```golang
/*
#include <linux/i2c.h>
#include <linux/i2c-dev.h>
*/
import "C"

type i2c_smbus_ioctl_data C.struct_i2c_smbus_ioctl_data
```

通过“go tool cgo -godefs ”自动生成的纯粹golang 结构体如下，这样对后续使用该结构体的代码能脱离cgo，而且可以看到对struct的内存布局做了padding处理。

```golang
type i2c_smbus_ioctl_data struct {
	Write     uint8
	Command   uint8
	Pad_cgo_0 [2]byte
	Size      uint32
	Data      *[34]byte
}
```



## 2.3 通过cgo调用C

通过cgo支持调用C代码的go package。在windows使用cgo必须先安装mingw32 gcc，在运行cgo前mingw32 gcc必须已经在PATH中可查找到。

代码见“byGO/get_http.go”

[用 Kotlin Native 写 Jni](https://www.bennyhuo.com/2018/12/17/kotlin_native_jni/)

### cgosyntax package中知识点

样例代码演示了 C enum,string, integer, struct，在C中的访问方式

- 对"type struct/enum xx{} YY"类型，访问该C类型采用“C.YY”
- 指针中除了“void*”对应“unsafe.Pointer”, 其他类型都是直接一一对应，例如c中char对应golang中的int8

- C中macro是不能直接被cgo使用，通常用个C function包装macro，然后在go中调用c function。

- C中可变参数函数不能直接被cgo使用，通常采用中间C语言函数包装，使得golang看见固定参数个数的函数。例如`C.curlEeasySetopt`封装curl_easy_setopt，curl_easy_setopt在C中是通过宏变为固定参数个数，它实质是个可变参数的函数。


# 三. java 实验

java调用C

java调用C有两种方式： JNA,JNI。 其中新推出的JNA方式更为方便。 

## 3.1 通过JNA调用C

在“byJava\byJNA”项目中，提供了:

- 手工编写映射Library，实验代码是“com.example.LibCurl”，对执行程序执行拉取baidu.com网页的命令如下 

  ```sh
  java -cp .\build\libs\byJNA.jar  com.example.App  www.baidu.com

  Hello world.
  <!DOCTYPE html><!--STATUS OK-->
  <html>
  <head>
          <meta http-equiv="content-type" content="text/html;charset=utf-8">
          <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    ...      
  ```

- 通过“byJava\jnaerator-0.12.jar”自动生成映射Library,代码见“com.example.jna”包。为自动生成映射执行命令是：

  ```sh
  c:\tmp\out>java  -jar jnaerator-0.12.jar  -runtime JNA -mode Maven -o out -package com.example.jna -f -library libcurl-4 include\curl\curl.h
  ```

  该映射代码使用方式同LibCurl. 工具[jnaerator.jar ](https://code.google.com/archive/p/jnaerator/)的使用说明略。





# 问题记录

- /**/中间是C代码,之后接 import "C" 如果存在空行 就会报错.could not determine kind of name for C.*

- [用 Kotlin Native 写 Jni](https://www.bennyhuo.com/2018/12/17/kotlin_native_jni/)

- 根据[testing documet](http://golang.org/pkg/testing/#hdr-Examples), 如果一个Example functions没有"//OutPut"成分，将仅编译，不执行。
