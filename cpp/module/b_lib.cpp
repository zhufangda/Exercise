#include "b_lib.h"

#include "common.h"
#include <iostream>

extern "C" common::DAL* GetDAL() {
  return B::GetDAL();
}

namespace B{
void GetCommonData(){
       std::cout << &common::DAL::data << std::endl;
}

common::DAL* GetDAL(){
    return common::DAL::GetInstance();
}

}
