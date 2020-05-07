package cgosyntax

/*
#include <stdio.h>
#include <stdint.h>

int iValue = 5;
*/
import "C"

import (
	"fmt"
	"reflect"
	"unsafe"
)

/**
* 类型转换
* char -->  C.char -->  byte
* signed char -->  C.schar -->  int8
* unsigned char -->  C.uchar -->  uint8
* short int -->  C.short -->  int16
* short unsigned int -->  C.ushort -->  uint16
* int -->  C.int -->  int
* unsigned int -->  C.uint -->  uint32
* long int -->  C.long -->  int32 or int64
* long unsigned int -->  C.ulong -->  uint32 or uint64
* long long int -->  C.longlong -->  int64
* long long unsigned int -->  C.ulonglong -->  uint64
* float -->  C.float -->  float32
* double -->  C.double -->  float64
* wchar_t -->  C.wchar_t  -->
* void * -> unsafe.Pointer
 */

// PrintInt 演示C中int值与golang中int值转换
func PrintInt() {
	i := int(C.iValue)
	fmt.Println("value:", i, "type:", reflect.TypeOf(i))
}

// PrintCInt 演示C中int值与类型
func PrintCInt() {
	i := C.iValue
	fmt.Println("value:", i, "type:", reflect.TypeOf(i))
}

// PrintIntPointer 演示指针
func PrintIntPointer() {
	i := (*C.int)(unsafe.Pointer(&(C.iValue)))
	fmt.Println("value:", reflect.ValueOf(*i), "type:", reflect.TypeOf(*i))
	fmt.Println("point value:", reflect.ValueOf(i), "type:", reflect.TypeOf(i))
}
