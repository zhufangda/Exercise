#include <cstdint>
#include <iostream>
#include <string>

// struct Segment{
//     uint32_t b1;
//     uint32_t b2;
//     uint32_t b3;
//     uint32_t b4;
//     uint32_t b5;
//     uint32_t b6;
//     uint32_t b7;
//     uint32_t b8;
// };


// struct Info{
//     uint8_t b1;
//     uint8_t b2;
//     Segment b;
//     uint8_t a1;
// };

struct Segment{
    char b1; // 1
    int b2; // 4
};


struct Info{
    char b1; // 1
    
    Segment b2; // 8

};


int main(int argc,char* argv[]){
    std::cout << "short   size=" << sizeof(short) << "\talign= " << alignof(short) << std::endl;
    std::cout << "int     size=" << sizeof(int) << "\talign= " << alignof(int) << std::endl;
    std::cout << "long    size=" << sizeof(long) << "\talign= " << alignof(long) << std::endl;
    std::cout << "float   size=" << sizeof(float) << "\talign= " << alignof(float) << std::endl;
    std::cout << "double  size=" << sizeof(double) << "\talign= " << alignof(double) << std::endl;
    std::cout << "Segment size=" << sizeof(Segment) << "\talign= " << alignof(Segment) << std::endl;
    std::cout << "Info: \tsize=" << sizeof(Info) << "\talign= " << alignof(Info) << std::endl;
}