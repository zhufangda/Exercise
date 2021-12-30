#include<string>
#include<iostream>

class Person{

    private:
        std::string name;
        std::string address;
        
    public:
        Person(const std::string& name, const std::string& address){
            this->name = name;
            this->address = address;
        }

        const std::string& getName() const{
            return name;
        }

        const std::string getAddress() const{
             std::cout << &address << std::endl;
            return address;
        }



};