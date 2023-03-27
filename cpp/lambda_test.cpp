#include <iostream>
#include <memory>

struct Data {
public:
  Data() { std::cout << "Constructor" << std::endl; }
  Data(const Data& data) { std::cout << "Copy Constructor" << std::endl; }
  Data(Data&& data) { std::cout << "Move Constructor" << std::endl; }
  Data& operator=(const Data&) { std::cout << "operator= " << std::endl; }
  ~Data() { std::cout << "deconstrutor " << std::endl; }

  int i = 0;
  float f = 2.0f;
  double d = 23.0;
};

int transfert(std::unique_ptr<Data> data) {
  std::cout << "data:" << data.get() << " data->i：" << data->i << std::endl;
  return 0;
}

int main(int argc, char const *argv[]) {
  Data data;
  std::cout << "data：" << &data << std::endl;
  auto inner = [data = data]() {
    std::cout << "data:" << &data << " data->i：" << data.i << std::endl;
  };

  inner();

  // transfert(std::move(data));
  std::cout << "data：" << &data << std::endl;

  return 0;
}
