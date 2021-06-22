package core

type Reader interface {
	Read(readChannel chan string)
}
