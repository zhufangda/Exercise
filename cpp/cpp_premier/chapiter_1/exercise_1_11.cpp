#include<iostream>
#include<vector>

int main(){
    int start = 0, end = 0;

    std::cout<<"Type start and end of the rang:";
    std::cin >> start >> end;

    while(end>=start){
        std::cout << start ++ << " ";        
    }

    return 0;
}