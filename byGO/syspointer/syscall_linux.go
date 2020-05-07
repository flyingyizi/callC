package syspointer

import (
	"fmt"
	"syscall"
)

func GetPid() {
	pid, _, _ := syscall.Syscall(syscall.SYS_GETPID, 0, 0, 0)
	fmt.Println("process id: ", pid)
}
