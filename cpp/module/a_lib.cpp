#include "a_lib.h"
#include <iostream>

extern "C" common::DAL* GetDAL() {
  return A::GetDAL();
}

namespace A{
void GetCommonData(){
       std::cout << &common::DAL::data << std::endl;
}

common::DAL* GetDAL(){
    return common::DAL::GetInstance();
}
}
