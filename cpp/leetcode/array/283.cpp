#include <vector>
#include "common/print.h"

// 283. 移动零

void moveZeroes(std::vector<int>& nums) {
    auto end =  0; // index of last elemet for new array
    
    for(int i=0; i< nums.size(); i++){
        if(nums[i]!=0){
            nums[end++] = nums[i];
        }
    }

    for(int i=end;i<nums.size();i++){
            nums[i] = 0;
    }
}

int main(){
    std::vector<int> input {0,1,0,3,12};
    moveZeroes(input);
    PrintContainer(input);
    // std::cout << "size = " << size << std::endl;;

    input = {0};
    moveZeroes(input);
    PrintContainer(input);
    // std::cout << "size = " << size << std::endl;;


    input = {0,0,6,0,0,0};
    moveZeroes(input);
    PrintContainer(input);
    // std::cout << "size = " << size << std::endl;;

    input = {2,0,6,7,0,1};
    moveZeroes(input);
    PrintContainer(input);
    // std::cout << "size = " << size << std::endl;;
    return 1;
}