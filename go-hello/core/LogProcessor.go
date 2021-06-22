package core

import "strings"

type LogProcessor struct {
	Reader Reader
	Writer Writer

	ReadChannel  chan string
	WriteChannel chan string
}

func (logProcessor *LogProcessor) Read() {
	logProcessor.Reader.Read(logProcessor.ReadChannel)
}

func (logProcessor *LogProcessor) Write() {
	logProcessor.Writer.Write(logProcessor.WriteChannel)
}

func (logProcessor *LogProcessor) Process() {
	text := <-logProcessor.ReadChannel

	logProcessor.WriteChannel <- strings.ToUpper(text)
}
