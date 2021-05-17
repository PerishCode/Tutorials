#include <string.h>

#include <string>
#include <vector>
using namespace std;

class Solution {
  string transfer(const string& pattern, bool& allBlur) {
    string result;
    int index = 0, length = pattern.length();
    while (index < length) {
      char c = pattern[index];
      if (index + 1 < length && pattern[index + 1] == '*') {
        result += ((c >= 'a' && c <= 'z') ? c - 32 : '@');
        index += 2;
      } else {
        result += c;
        index += 1;
        allBlur = false;
      }
    }
    return result;
  }

  // "mississippi"
  // "mis*is*p*."

 public:
  void run() { isMatch("mississippi", "mis*is*p*."); }

 public:
  bool isMatch(string s, string pattern) {
    bool allBlur = true;

    string p = transfer(pattern, allBlur);

    int a = s.length(), b = p.length();

    bool** dp = new bool*[a + 1];
    for (int i = 0; i < a + 1; ++i) {
      dp[i] = new bool[b + 1];
      memset(dp[i], 0, b + 1);
      // for (int j = 0; j < b + 1; ++j) dp[i][j] = false;
    }

    dp[0][0] = true;
    if (allBlur) memset(dp[0], true, b + 1);

    for (int i = 1; i < a + 1; ++i) {
      for (int j = 1; j < b + 1; ++j) {
        char c = p[j - 1];
        if (c == '.')
          dp[i][j] = dp[i - 1][j - 1];
        else if (c == '@')
          dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1];
        else if (c <= 'Z')
          dp[i][j] = dp[i][j - 1] || (dp[i - 1][j - 1] && s[i - 1] == c + 32);
        else
          dp[i][j] = dp[i - 1][j - 1] && s[i - 1] == c;
      }
    }

    return dp[a][b];
  }
};