#include <iostream>
#include <iomanip>
#include <thread>
#include <mutex>


void critical_section(int input) {
  static std::mutex mtx;
  std::lock_guard<std::mutex> lockGuard(mtx);
  std::cout << "Current Thread-" << input << " : " << std::this_thread::get_id() << ": In Thread"
            << std::endl;
}

int main() {
  std::cout << "Current Thread - main :" << std::this_thread::get_id() << std::endl;
  std::thread thread1(critical_section, 1), thread2(critical_section, 2);
  std::this_thread::sleep_for(std::chrono::seconds(10));
  thread1.detach();
  std::cout << std::setw(5) << " T1 : " << thread1.get_id() << " Finished"
            << std::endl;
  thread2.detach();
  std::cout << std::setw(5) << " T2 : " << thread2.get_id() << " Finished"
            << std::endl;
  return 0;
}
di