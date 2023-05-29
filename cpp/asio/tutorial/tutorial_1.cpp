#include <boost/asio.hpp>
#include <iostream>

void print(const boost::system::error_code & /*e*/) {
  std::cout << "Hello, world!" << std::endl;
}

int main() {
  boost::asio::io_context io;
  boost::asio::steady_timer t(io, boost::asio::chrono::seconds(5));
  t.wait();
  std::cout << "Hello, world!\n";

  return 0;
}