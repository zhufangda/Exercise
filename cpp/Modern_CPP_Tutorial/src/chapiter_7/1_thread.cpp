#include <iostream>
#include <thread>

int main() {

  std::thread thread( [](){
    std::cout << "Current Thread:" << std::this_thread::get_id() << ": In Thread"<< std::endl;
    std::flush(std::cout);
  });
  std::cout << "Current Thread:" << std::this_thread::get_id() << " Create thread :" << thread.get_id() <<std::endl;
  thread.join();
  std::cout << "Current Thread:" << std::this_thread::get_id() << " Finished thread :" << thread.get_id() <<std::endl;
  return 0;
}
