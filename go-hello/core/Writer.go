package core

type Writer interface {
	Write(writeChannel chan string)
}
