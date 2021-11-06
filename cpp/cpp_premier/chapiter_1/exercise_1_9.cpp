#include<iostream>
#include<vector>

int main(){
    int sum=0, v1=51;

    while(v1<=100){
        std::cout << "Before sum: " << sum << " value: " << v1 << std::endl;
        sum+=v1++;
        std::cout << "After  sum: " << sum << " value: " << v1 << std::endl;
    }

    std::cout << "The sum from 50 through 100 is " << sum << std::endl;
    return 0;
}