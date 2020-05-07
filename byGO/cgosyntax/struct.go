package cgosyntax

/*
#include <stdio.h>
#include <stdint.h>
struct columns {
    int column1;
    int column2;
    int column3;
};

int sum_columns(struct columns a) {
	return a.column1 + a.column2 + a.column3;
};

*/
import "C"

// CheckStruct 演示访问C中struct
func CheckStruct() bool {

	c := C.struct_columns{15, 30, 45}

	sum := C.sum_columns(c)

	if sum == 90 {
		return true
	}
	return false
}
