#include "common/print.h"
#include <algorithm>
#include <climits>
#include <cstddef>
#include <cstdio>
#include <unordered_map>
#include <vector>

using namespace std;

vector<int> findDisappearedNumbers(vector<int> &nums) {
  int n = nums.size();
  for (int num: nums) {
    int idx = (num-1) % n;
    nums[idx] +=n;
  }
  
  int pos = 0;
  for (int i=0; i<n;i++) {
    if (nums[i] <= n) {
      nums[pos++] = i + 1;
    }
  }
  nums.resize(pos);
  return nums;
}
int main() {
  std::vector input{4,3,2,7,8,2,3,1};
  int target = 9;
  PrintContainer(findDisappearedNumbers(input));

  input = {1,1};
  PrintContainer(findDisappearedNumbers(input));

  input = {3, 3};
  target = 6;
  PrintContainer(findDisappearedNumbers(input));

  return 1;
}