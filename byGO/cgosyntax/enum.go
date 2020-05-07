package cgosyntax

/*
#include <stdio.h>
#include <stdint.h>

typedef enum {
    super = 0
}levelOne;

enum levelTwo{
	LOW = 0,
    MEDIUM = 1,
    HIGH = 2
} ;
*/
import "C"

type LevelTwo int

// MEDIUM 演示如何引用C中enum的字段
const (
	LOW    LevelTwo = C.LOW
	MEDIUM LevelTwo = C.MEDIUM
	HIGH   LevelTwo = C.HIGH
)

// CheckEnum 演示访问C中enum xx类型
func CheckEnum() bool {

	var c C.enum_levelTwo = C.MEDIUM

	if c == C.MEDIUM {
		return true
	}
	return false
}

// CheckTypedefEnum 演示访问C中typedef enum类型
func CheckTypedefEnum() bool {

	var c C.levelOne = C.super

	if c == C.super {
		return true
	}
	return false
}
