#include <string.h>

#include <string>
#include <vector>
using namespace std;

class Solution {
 public:
  void run() { longestPalindrome("babad"); }

 public:
  string longestPalindrome(string s) {
    if (s.length() < 2) return s;
    if (s.length() < 3) return s[0] == s[1] ? s : s.substr(0, 1);

    int length = s.length();

    int maxIndex = 0;
    int maxLength = 1;

    bool *pre2 = new bool[length];
    bool *pre1 = new bool[length];

    memset(pre2, true, length);
    memset(pre1, true, length);

    for (int i = 0; i + 1 < length; ++i) {
      bool flag = false;

      for (int j = 0; j + i + 1 < length; ++j) {
        pre2[j] = pre2[j + 1] && s[j] == s[j + i + 1];

        if (pre2[j] && maxLength < i + 2) {
          maxIndex = j;
          maxLength = i + 2;
          flag = true;
        }
      }

      bool *temp = pre2;
      pre2 = pre1;
      pre1 = temp;
    }

    return s.substr(maxIndex, maxLength);
  }
};