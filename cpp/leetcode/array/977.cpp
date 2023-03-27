#include <vector>
#include "common/print.h"

// 844. 比较含退格的字符串

std::vector<int> sortedSquares(std::vector<int>& nums) {
    int n=nums.size(), i = 0, j = n-1, k=n-1;
    std::vector<int> output(n, 0);
    
    for(int i=0;i<n;i++){
        nums[i] *= nums[i];
    }

    while(i<=j){
        if(nums[i]>nums[j]){
            output[k--] = nums[i++];
        }else{
            output[k--] = nums[j--];
        }
    }
    
    return output;

}





int main(){
    std::vector<int> input {-4,-1,0,3,10};
    PrintContainer(sortedSquares(input));

    input = {1,2,3,10};
    PrintContainer(sortedSquares(input));
    
    input = {-7,-3,2,3,11};
    PrintContainer(sortedSquares(input));


    input = {-5,-3,-2,-1};
    PrintContainer(sortedSquares(input));
    return 1;
}