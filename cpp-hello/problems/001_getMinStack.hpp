#include <fstream>
#include <string>
#include <vector>
using namespace std;

enum Opeation { POP, PUSH, MIN };

class min_stack {
 private:
  vector<pair<int, int>> stack;

  int currentMin = -1;

 public:
  int pop() {
    auto p = stack.back();
    stack.pop_back();
    currentMin = stack.back().second;
    return p.first;
  }

  int push(int num) {
    if (num < currentMin || currentMin == -1) currentMin = num;
    stack.push_back({num, currentMin});
    return num;
  }

  int min() { return currentMin; }
};

class Solution {
 public:
  static void run(ifstream& in, ofstream& out) {
    int lines = 0, operation = 0, num = 0;

    min_stack stack;

    in >> lines;
    out << lines << endl;

    while (lines--) {
      in >> operation;

      switch (operation) {
        case POP:
          out << stack.pop();
          break;

        case PUSH:
          in >> num;
          out << stack.push(num);
          break;

        case MIN:
          out << stack.min();
          break;
      }

      out << endl;
    }
  }
};