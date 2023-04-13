#include "common/print.h"
#include <algorithm>
#include <map>
#include <vector>

// 2404. 出现最频繁的偶数元素

int mostFrequentEven(std::vector<int> &nums) {
  std::map<int, int> memo;
  int cnt = 0;
  for (auto &num : nums) {
    if (num % 2 == 1) {
      continue;
    }

    if (memo.find(num) == memo.end()) {
      memo[num] = 1;
    } else {
      memo[num]++;
    }
    cnt = std::max(memo[num], cnt);
  }

  int num = -1;
  for (const auto &[key, value] : memo) {
    if (value == cnt) {
      return key;
    } 
  }
  return -1;
}
  int main() {
    std::vector<int> input{0,1,2,2,4,4,1};
    int size = mostFrequentEven(input);
    std::cout << "size = " << size << std::endl;

    input = {4,4,4,9,2,4};
    size = mostFrequentEven(input);
    std::cout << "size = " << size << std::endl;

    input = {29,47,21,41,13,37,25,7};
    size = mostFrequentEven(input);
    std::cout << "size = " << size << std::endl;

    return 1;
  }