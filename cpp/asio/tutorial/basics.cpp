#include <boost/asio.hpp>

int main(){
  // Execution Context- 如何理解
  boost::asio::io_context io_context;

  // IO对象
  boost::asio::ip::tcp::socket socket(io_context);

  boost::system::error_code ec;
  // 如果传递error_code, 失败的操作信息会通过ec传递，否则会抛出异常
  socket.connect(server_endpoint, ec);

  //

}

// Handler
void your_completion_handler(const boost::system::error_code& ec);

int main(){
  // Execution Context- 如何理解
  boost::asio::io_context io_context;

  // IO对象
  boost::asio::ip::tcp::socket socket(io_context);

  boost::system::error_code ec;
  // 如果传递error_code, 失败的操作信息会通过ec传递，否则会抛出异常
  socket.async_connect(server_endpoint, your_completion_handler);

  io_context::run();
  //

}
