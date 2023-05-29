#include <boost/asio.hpp>
#include <boost/bind/bind.hpp>
#include <boost/thread/thread.hpp>
#include <iostream>

#include "thread.h"

class Printer {
public:
  explicit Printer(std::shared_ptr<boost::asio::io_context> &io)
      : io_service_(io),
        timer1_(*io, boost::asio::chrono::seconds(1)),
        timer2_(*io, boost::asio::chrono::seconds(1)), count_(0) {

    timer1_.async_wait(boost::asio::bind_executor(
        *io, boost::bind(&Printer::print1, this)));

    timer2_.async_wait(boost::asio::bind_executor(
        *io, boost::bind(&Printer::print2, this)));
  }
  void print1() {
    if (count_ < 10) {
      std::cout << "Timer 1: " << count_ << " thread=" << GetThreadSimpleId() << std::endl;
      ++count_;

      timer1_.expires_at(timer1_.expiry() + boost::asio::chrono::seconds(1));

      timer1_.async_wait(boost::asio::bind_executor(
          *io_service_, boost::bind(&Printer::print1, this)));
    }
  }

  void print2() {
    if (count_ < 10) {
      std::cout << "Timer 2: " << count_ << " thread=" << GetThreadSimpleId() << std::endl;
      ++count_;

      timer2_.expires_at(timer2_.expiry() + boost::asio::chrono::seconds(1));

      timer2_.async_wait(boost::asio::bind_executor(
          *io_service_, boost::bind(&Printer::print2, this)));
    }
  }

private:
  boost::asio::strand<boost::asio::io_context::executor_type> strand_;
  std::shared_ptr<boost::asio::io_service> io_service_;
  boost::asio::steady_timer timer1_;
  boost::asio::steady_timer timer2_;
  int count_;
};

int main() {
  std::cout << "Main: thread=" << GetThreadSimpleId() << std::endl;
  auto io = std::make_shared<boost::asio::io_context>();
  Printer p(io);
  boost::thread t(boost::bind(&boost::asio::io_context::run, io.get()));
  io->run();
  t.join();
  return 0;
}
