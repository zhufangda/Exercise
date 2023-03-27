#include "common.h"

#include "common.h"
#include <algorithm>
#include <chrono> // NOLINT
#include <dlfcn.h>
#include <iostream>
#include <memory>
#include <regex>
#include <thread> // NOLINT
#include <thread>
#include <utility>

common::DAL *GetDAL(const std::string &path) {
  void *handle = dlopen(path.c_str(), RTLD_LAZY);

  if (!handle) {
    std::cerr << "Cannot open library: " << dlerror() << '\n';
    return nullptr;
  }

  // load the symbol
  typedef common::DAL *(*A_GETDAL)();

  // reset errors
  dlerror();
  A_GETDAL dal = (A_GETDAL)dlsym(handle, "GetDAL");
  const char *dlsym_error = dlerror();
  if (dlsym_error) {
    std::cerr << "Cannot load symbol 'hello': " << dlerror() << '\n';
    dlclose(handle);
    return nullptr;
  }

  return dal();
}

int main(int argc, char const *argv[]) {
  //     A::GetCommonData();
  //     B::GetCommonData();
  //     std::cout << &common::DAL::data << std::endl;

  // std::cout << "0:" << common::DAL::GetInstance() <<"\tdata:" <<
  // &(common::DAL::data) << " " <<common::DAL::data <<std::endl;
  // common::DAL::data++;
  std::cout << "0:" << common::DAL::GetInstance()
            << "\tdata:" << &(common::DAL::data) << " " << common::DAL::data
            << std::endl;

  // open the library
  // std::cout << "A:" << A::GetDAL() <<"\tdata:" << &(A::GetDAL() ->data) <<
  // std::endl;

  common::DAL *a =
      GetDAL("/home/zhufangda/work_dir/Exercise/cpp/build/module/libA.so");
  std::cout << "A:" << a << "\tdata:" << &(a->data) << std::endl;

  common::DAL *b =
      GetDAL("/home/zhufangda/work_dir/Exercise/cpp/build/module/libB.so");
  std::cout << "B:" << b << "\tdata:" << &(b->data) << std::endl;

  // call plugin function hello

  // std::cout << "A:" << A::GetDAL()<< std::endl;

  // std::cout << "B:" << B::GetDAL()<< std::endl;

  // std::cout << "C:" << common::DAL::GetInstance() << std::endl;
  /* code */

  return 0;
}
