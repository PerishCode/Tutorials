package utils

import "fmt"

type User struct {
	Name string
}

// 接口组合
type Administer interface {
	Sayable
}

type Sayable interface {
	Say()
}

// 接口的指针接收者方式定义只能使用指针进行赋值
func (u *User) Say() {
	fmt.Println(u.Name)
}

func init() {
	fmt.Println("b's init")
}

func SayHello() {

	var u Sayable

	u = &User{
		Name: "小韩",
	}

	u.Say()

	u = &User{
		Name: "gogogo",
	}

	u.Say()
}
