#include "common/print.h"
#include <algorithm>
#include <climits>
#include <cstddef>
#include <unordered_map>
#include <vector>
#include <cstdio>

std::vector<int> twoSum(std::vector<int>& nums, int target) {
  std::vector<int> result(2,0);
  std::unordered_map<int, int> memo;
  for(int i = 0; i< nums.size(); i++){
    if(memo.find(target - nums[i]) != memo.end()){
        return std::vector<int>{memo[target - nums[i]],i};
    }
    memo[nums[i]] = i;
    // printf("memo[%d] = %d\n",nums[i], i);
  } 
  return {0, 0};
}

int main() {
  std::vector input{2,7,11,15};
  int target = 9;
  PrintContainer(twoSum(input, target));

  input = {3,2,4};
  target = 6;
  PrintContainer(twoSum(input, target));

  input = {3,3};
  target = 6;
  PrintContainer(twoSum(input, target));

  return 1;
}