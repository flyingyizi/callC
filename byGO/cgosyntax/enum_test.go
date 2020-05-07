package cgosyntax_test

import (
	"fmt"
	"get_http/cgosyntax"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestEnum1(t *testing.T) {

	fmt.Println(cgosyntax.MEDIUM)
	// 演示对C中类型封装
	x := new(cgosyntax.LevelTwo)

	*x = cgosyntax.MEDIUM

	assert.Equal(t, *x, cgosyntax.MEDIUM, "they should be equal")

	// if *x != 0 {
	// 	t.Errorf("init failed: got %v", *x)
	// }
}

func TestEnum2(t *testing.T) {

	assert.Equal(t, true, cgosyntax.CheckEnum(), "they should be equal")

	// if *x != 0 {
	// 	t.Errorf("init failed: got %v", *x)
	// }
}
func TestEnum3(t *testing.T) {

	assert.Equal(t, true, cgosyntax.CheckTypedefEnum(), "they should be equal")
}
