// +build ignore

package wrapper

/*
#include <stdio.h>
#include <curl/curl.h>
#include <stdlib.h>

typedef struct {
   int A;
   int B;
   char C;
   char* Str;
} structDemo;

typedef enum {
   LOW,
   MEDIUM
} enumDemo;

typedef union { int i; double x; char str[16];
   }unionDemo;

#cgo pkg-config: libcurl
*/
import "C"

type StructDemo C.structDemo
type EnumDemo C.enumDemo
type UnionDemo C.unionDemo

// C.CURL 对应的是c void，这个要特别注意“-godefs”生成的
//是未在任何地方定义的“_Ctype_…”，因此不能对类似数据类型采用“-godefs”进行支持
//type CURL C.CURL

type CURLcode C.CURLcode
