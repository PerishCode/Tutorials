#include <iostream>

#include "problems/001_getMinStack.hpp"

int main(int argc, char *argv[]) {
  if (argc != 3) {
    cout << "请正确输入参数个数" << endl;
    return 0;
  }

  string input_file_name = argv[1];
  string output_file_name = argv[2];

  cout << "输入文件：" << input_file_name << endl;
  cout << "输出文件：" << output_file_name << endl;

  ifstream input_file_stream(input_file_name);
  ofstream output_file_stream(output_file_name);

  Solution::run(input_file_stream, output_file_stream);

  input_file_stream.close();
  output_file_stream.close();

  return 0;
}