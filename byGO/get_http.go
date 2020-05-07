package main

/*
#include <stdio.h>
#include <curl/curl.h>
#include <stdlib.h>

// 封装 C 可变函数为固定参数个数，cgo无法直接支持可变参数C function
// 这里指定value为
CURLcode curlEeasySetopt(CURL *curl, CURLoption option, char* value) {
    return curl_easy_setopt(curl, option, value);
}

#cgo pkg-config: libcurl
*/
import "C"
import (
	"fmt"
	"os"
	"unsafe"
)

func main() {
	// int main(int argc, char *argv[])
	// {
	//     CURL *curl;             //定义CURL类型的指针
	// CURLcode res;           //定义CURLcode类型的变量，保存返回状态码
	//     if(argc!=2)
	//     {
	//         printf("Usage : file <url>;\n");
	//         exit(1);
	//     }
	if len(os.Args) != 2 {
		fmt.Println("Usage : file <url>;\n")
		panic("1")
	}

	//     curl = curl_easy_init();        //初始化一个CURL类型的指针
	curl := C.curl_easy_init()
	//     if(curl!=NULL)
	//     {
	//         //设置curl选项. 其中CURLOPT_URL是让用户指 定url. argv[1]中存放的命令行传进来的网址
	//         curl_easy_setopt(curl, CURLOPT_URL, argv[1]);
	//         //调用curl_easy_perform 执行我们的设置.并进行相关的操作. 在这 里只在屏幕上显示出来.
	//         res = curl_easy_perform(curl);
	//         //清除curl操作.
	//         curl_easy_cleanup(curl);
	//     }
	//     return 0;
	if curl == nil {
		fmt.Println("curl is nil;\n")
	}
	if nil != curl {
		value := C.CString(os.Args[1])
		defer C.free(unsafe.Pointer(value))

		C.curlEeasySetopt(curl, C.CURLOPT_URL, value) //(*C.char)(unsafe.Pointer(value)))

		C.curl_easy_perform(curl)
		C.curl_easy_cleanup(curl)
	}
	// }
}
