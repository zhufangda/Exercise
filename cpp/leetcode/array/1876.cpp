#include "common/print.h"
#include <algorithm>
#include <climits>
#include <cstddef>
#include <unordered_map>
#include <vector>

// 1876. 长度为三且各字符不同的子字符串

int countGoodSubstrings(std::string s) {
  int pos = 0, cnt = 0, size = s.size();
  if (size < 3) {
    return 0;
  }
  bool memo[128] = {
      false,
  };
  for (int i = 0; i < size; i++) {
    while (memo[s[i]] || i-pos >2) {
      memo[s[pos++]] = false;
    }
    if (i - pos == 2) {
      cnt++;
    }
    memo[s[i]] = true;
  }
  return cnt;
}

int main() {
  std::string input{"xyzzaz"};
  int size = countGoodSubstrings(input);
  std::cout << "size = " << size << std::endl;

  input = "aababcabc";
  size = countGoodSubstrings(input);
  std::cout << "size = " << size << std::endl;

  input = "owuxoelszb";
  size = countGoodSubstrings(input);
  std::cout << "size = " << size << std::endl;

  return 1;
}