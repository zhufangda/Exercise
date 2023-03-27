#include <vector>
#include "common/print.h"

// 27. Remove Element

int removeDuplicates(std::vector<int>& nums) {
    auto end =  -1;
    int size = 0;

    if( nums.size()>=1){
        end = 0;
        size = 1;
    }

    for(int i=1; i< nums.size(); i++){
        if(nums[i]!=nums[i-1]){
            end++;
            nums[end] = nums[i];
            size ++;
        }
    }
    return size;
}

int main(){
    std::vector<int> input {1,2,3,4,5,6,6,7,8};
    int size = removeDuplicates(input);
    PrintContainer(input);
    std::cout << "size = " << size << std::endl;

    input = {};
     size = removeDuplicates(input);
    PrintContainer(input);
    std::cout << "size = " << size << std::endl;


    input = {0,0,0,0,0,0};
 size = removeDuplicates(input);
    PrintContainer(input);
    std::cout << "size = " << size<< std::endl;

    input = {0,0,1,2,6,7,7};
     size = removeDuplicates(input);
    PrintContainer(input);
    std::cout << "size = " <<size << std::endl;
    return 1;
}