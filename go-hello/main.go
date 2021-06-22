package main

import (
	"time"

	"perish.top/hello/core"
	"perish.top/hello/utils"
)

func main() {
	logProcessor := &core.LogProcessor{
		Reader: &utils.FileReader{
			FilePath: "/a",
		},
		Writer: &utils.InfluxWriter{
			DataSource: "/b",
		},
		ReadChannel:  make(chan string),
		WriteChannel: make(chan string),
	}

	go logProcessor.Read()
	go logProcessor.Process()
	go logProcessor.Write()

	time.Sleep(time.Second * 1)
}
