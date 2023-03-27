#include <iostream>
#include <memory>

struct Data {
public:
  // Data() { std::cout << "Constructor" << std::endl; }
  // Data(const Data& data) { std::cout << "Copy Constructor" << std::endl; }
  // Data(Data&& data) { std::cout << "Move Constructor" << std::endl; }
  // Data& operator=(const Data&) { std::cout << "operator= " << std::endl; }
  // ~Data() { std::cout << "deconstrutor " << std::endl; }

  int i = 0;
  float f = 2.0f;
  double d = 23.0;
};

void DoWrite(const Data& data){
  std::cout << "const  DoWrite&:" << &data << " data->i：" << data.i << std::endl;
}

// void DoWrite(Data data){
//   std::cout << "DoWrite:" << &data << " data->i：" << data.i << std::endl;
// }

void DoWrite(Data&& data){
  std::cout << "DoWrite &&:" << &data << " data->i：" << data.i << std::endl;
}


template<typename M>
int transfert(M&& data) {
  std::cout << "data:" << &data << " data->i：" << data.i << std::endl;
  DoWrite(std::forward<M>(data));
  return 0;
}

int main(int argc, char const *argv[]) {
  Data data {0,2.0, 4.0};

  std::cout << "data：" << &data << std::endl;
  transfert<Data>({14,2.0, 4.0});
  // transfert(std::move(data));
  std::cout << "data：" << &data << std::endl;

  return 0;
}
