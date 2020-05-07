package cgosyntax_test

import "get_http/cgosyntax"

// 检测单行输出
func ExamplePrintInt() {
	cgosyntax.PrintInt()
	// OutPut:
	//value: 5 type: int
}

func ExamplePrintCInt() {
	cgosyntax.PrintCInt()
	// OutPut:
	//value: 5 type: cgosyntax._Ctype_int
}

func ExamplePrintIntPointer() {
	cgosyntax.PrintIntPointer()
	// OutPut:
	//value: 5 type: cgosyntax._Ctype_int
	//point value: 0x6d2a20 type: *cgosyntax._Ctype_int
}
