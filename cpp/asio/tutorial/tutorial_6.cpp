#include "glog/logging.h"
#include "thread.h"
#include <boost/asio.hpp>
#include <boost/asio/io_context.hpp>
#include <boost/asio/signal_set.hpp>
#include <boost/asio/spawn.hpp>
#include <boost/asio/strand.hpp>
#include <boost/bind/bind.hpp>
#include <boost/container/flat_map.hpp>
#include <boost/thread/thread.hpp>
#include <iostream>

class Printer {
public:
  explicit Printer(boost::asio::io_context &ex)
      : strand_(ex.get_executor()) {

    boost::asio::spawn(strand_, [&ex](boost::asio::yield_context yield) {
      boost::asio::steady_timer timer(ex, 20);
      boost::system::error_code error_code;
      while (!error_code) {
        timer.expires_from_now(std::chrono::milliseconds(20), error_code);
        if (error_code) {
          break;
        }
        timer.async_wait(yield[error_code]);
      }
      LOG(FATAL) << "HealthReport exited with error code: " << error_code;
    });
  }
  

private:
  boost::asio::strand<boost::asio::io_context::executor_type> strand_;
  std::shared_ptr<boost::asio::io_context> io_context_;
  int count_;
};

int main() {
  std::cout << "Main: thread=" << GetThreadSimpleId() << std::endl;

  auto io_context_ = boost::asio::io_context;

  boost::asio::signal_set signal_set(io_context_);
  boost::system::error_code error_code;
  signal_set.add(SIGINT, error_code);

  signal_set.async_wait(
      [io_context_](const boost::system::error_code &ec, int signal_no) {
        DCHECK_EQ(SIGINT, signal_no);
        io_context_->stop();
      });

  Printer p(io_context_);
  
  std::vector<std::thread> thread_pool(10);
  for (auto& thread : thread_pool) {
    thread = std::thread([io_context_]() {
      io_context_->run();
    });
  }
  
  boost::thread t(
      boost::bind(&boost::asio::io_context::run, io_context_.get()));
  io_context_->run();
  t.join();
  return 0;
}
