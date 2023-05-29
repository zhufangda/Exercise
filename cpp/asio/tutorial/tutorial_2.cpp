#include <boost/asio.hpp>
#include <glog/logging.h>
#include <iostream>

void print(const boost::system::error_code &error_code) {
  LOG(ERROR) << "Hello, world!";
  LOG(ERROR) << "ErrorCode=" << error_code;
}
int main() {
  boost::asio::io_context io;
  boost::asio::steady_timer t(io, boost::asio::chrono::seconds(5));
  t.async_wait(&print);
  LOG(ERROR) << "After";
  io.run();
  return 0;
}
