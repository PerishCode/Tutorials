package main // 声明文件所在的包

import (
	"fmt"

	"perish.top/hello/utils"
) // 引入程序需要使用的包

func init() {
	fmt.Println("main's init")
}

// main 函数：可执行函数的入口
func main() {

	sum := 10 // 变量赋值 等价于 var sum int = 10 等价于 var sum = 10

	// for 循环不能使用 var i = 1 的形式初始化入口参数
	for i := 1; i < 5; i++ {
		sum += i
	}

	fmt.Println(sum)

	utils.SayHello()

	utils.SayHi()
}
