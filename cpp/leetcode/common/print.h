#include <iostream>
#include <iostream>
#include <sstream>

template<typename Container>
void PrintContainer(Container container){
    std::cout << "[";
    for(auto element: container){
        std::cout << element << " ";
    }
   std::cout << "]" << std::endl;;
    
}