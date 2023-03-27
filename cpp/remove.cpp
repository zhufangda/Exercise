#include <iostream>
#include <vector>
#include <algorithm>

int main(int argc, char const *argv[]) {
  std::vector<int> data {0, 4, 6, 8, 10};
  auto it = std::remove(data.begin(), data.end(), 8);
  data.erase(it);
  std::cout << "iter = " << *it << std::endl;
  for(const auto& elem: data){
    std::cout <<elem << " ";
  }
  

  return 0;
}
