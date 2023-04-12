#include "common/print.h"
#include <algorithm>
#include <climits>
#include <cstddef>
#include <unordered_map>
#include <vector>

// 27. Remove Element
using Memo = std::unordered_map<char, bool>;

bool inline contains(Memo &map, char data) {
  return map.find(data) != map.end() && map[data] == true;
}

int lengthOfLongestSubstring(std::string &s) {
  if (s.empty()) {
    return 0;
  }
  int pos = 0, result = 0, size = s.size();
  int map[96] = {
      0,
  };

  for (int i = 0; i < size; i++) {
    pos = std::max(pos, map[s[i] - 32]);
    map[s[i] - 32] = i + 1;
    result = std::max(result, i - pos + 1);
  }
  return result;
}

int main() {
  std::string input{"abcabcbb"};
  int size = lengthOfLongestSubstring(input);
  std::cout << "size = " << size << std::endl;

  input = "bbbbb";
  size = lengthOfLongestSubstring(input);
  std::cout << "size = " << size << std::endl;

  input = "pwwkew";
  size = lengthOfLongestSubstring(input);
  std::cout << "size = " << size << std::endl;

  return 1;
}