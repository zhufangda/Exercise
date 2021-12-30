#include <string>
#include <iostream> 
#include <cstdlib>
#include <vector>
#include "person.h"


int main(int argc, char const *argv[])
{
    
    Person person = Person("Zhang Ziyi", "Hai Dian");
    
    const std::string& address = person.getAddress();

    // address.append("x");

    std::cout << person.getAddress() << std::endl;

    std::cout << &address << std::endl;

    return 0;


}