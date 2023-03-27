#include <vector>
#include "common/print.h"

// 27. Remove Element

int removeElement(std::vector<int>& nums, int val) {
    auto end =  -1; // index of last elemet for new array
    int size = 0;
    for(int i=0; i< nums.size(); i++){
        if(nums[i]==val){
            continue;
        }

        end++;
        nums[end] = nums[i];
        size ++;
    }
    return size;
}

int main(){
    std::vector<int> input {1,2,3,4,5,6,6,7,8};
    int size = removeElement(input, 6);
    PrintContainer(input);
    std::cout << "size = " << size << std::endl;;

    input = {};
    size = removeElement(input, 6);
    PrintContainer(input);
    std::cout << "size = " << size << std::endl;;


    input = {0,0,0,0,0,0};
    size = removeElement(input, 0);
    PrintContainer(input);
    std::cout << "size = " << size << std::endl;;

    input = {2,0,6,7,0,1};
    size = removeElement(input, 0);
    PrintContainer(input);
    std::cout << "size = " << size << std::endl;;
    return 1;
}