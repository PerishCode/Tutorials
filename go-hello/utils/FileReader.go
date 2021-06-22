package utils

type FileReader struct {
	FilePath string
}

func (fileReader *FileReader) Read(readChannel chan string) {
	readChannel <- "haha"
}
