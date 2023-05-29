#include <boost/asio.hpp>
#include <boost/bind/bind.hpp>
#include <glog/logging.h>
#include <iostream>

class Printer {
public:
  explicit Printer(boost::asio::io_context &io)
      : timer_(io, boost::asio::chrono::seconds(1)), count_(0) {
    timer_.async_wait([this] { print(); });
  }

  ~Printer() { std::cout << "Final count is " << count_ << std::endl; }
  void print() {
    if (count_ < 5) {
      std::cout << count_ << std::endl;
      ++count_;

      timer_.expires_at(timer_.expiry() + boost::asio::chrono::seconds(1));
      timer_.async_wait([this] { print(); });
    }
  }

private:
  boost::asio::steady_timer timer_;
  int count_;
};


int main()
{
  boost::asio::io_context io(5);
  Printer p(io);
  io.run();

  return 0;
}
