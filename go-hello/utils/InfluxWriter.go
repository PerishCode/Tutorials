package utils

import "fmt"

type InfluxWriter struct {
	DataSource string
}

func (influxWriter *InfluxWriter) Write(writeChannel chan string) {
	fmt.Println(<-writeChannel)
}
