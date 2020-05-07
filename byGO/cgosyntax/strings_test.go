package cgosyntax_test

import (
	"get_http/cgosyntax"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestString(t *testing.T) {

	assert.Equal(t, true, cgosyntax.CheckStings(), "they should be equal")

	// if *x != 0 {
	// 	t.Errorf("init failed: got %v", *x)
	// }
}
