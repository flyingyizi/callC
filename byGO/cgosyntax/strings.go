package cgosyntax

/*
	#include <stdlib.h>
	#include <stdio.h>
	#include <string.h>
	char* cstr = "C string example";
*/
import "C"

// CheckStings 演示字符串操作
func CheckStings() bool {
	//C to Go String, Output: string
	gs := C.GoString(C.cstr)

	if len(gs) == (int)(C.strlen(C.cstr)) {
		return true
	}
	return false
}

//[refer](https://golang.org/cmd/cgo/)

// // Go string to C string
// // The C string is allocated in the C heap using malloc.
// // It is the caller's responsibility to arrange for it to be
// // freed, such as by calling C.free (be sure to include stdlib.h
// // if C.free is needed).
// func C.CString(string) *C.char

// // Go []byte slice to C array
// // The C array is allocated in the C heap using malloc.
// // It is the caller's responsibility to arrange for it to be
// // freed, such as by calling C.free (be sure to include stdlib.h
// // if C.free is needed).
// func C.CBytes([]byte) unsafe.Pointer

// // C string to Go string
// func C.GoString(*C.char) string

// // C data with explicit length to Go string
// func C.GoStringN(*C.char, C.int) string

// // C data with explicit length to Go []byte
// func C.GoBytes(unsafe.Pointer, C.int) []byte
