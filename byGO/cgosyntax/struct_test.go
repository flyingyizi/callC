package cgosyntax_test

import (
	"get_http/cgosyntax"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestStruct(t *testing.T) {

	assert.Equal(t, true, cgosyntax.CheckStruct(), "they should be equal")

	// if *x != 0 {
	// 	t.Errorf("init failed: got %v", *x)
	// }
}
