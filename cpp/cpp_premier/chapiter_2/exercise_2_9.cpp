#include <string>
#include <iostream> 
#include <cstdlib>
#include <vector>
#include <cstdio>

void function(){
    int i = {3};
}

int main(int argc, char const *argv[]){
    int local_int_1;
    int local_int_2;
    printf("%d %d\n",local_int_1, local_int_2);
    std::string localStr;
    std::string localStr2;
    std::cout << localStr << std::endl;
    std::cout << localStr2 << std::endl;
    return 0;
}

