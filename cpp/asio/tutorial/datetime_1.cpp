#include <boost/array.hpp>
#include <boost/asio.hpp>
#include <iostream>

using boost::asio::ip::tcp;
// 创建client端以接收消息。
int main(int argc, char *argv[]) {
  try {
    // 检查用户是否提供服务端IP
    if (argc != 2) {
      std::cerr << "Usage: client <host>" << std::endl;
      return 1;
    }

    boost::asio::io_context io_context;
    // 解析server name与host name
    tcp::resolver resolver(io_context);
    tcp::resolver::results_type endpoints =
        resolver.resolve(argv[1], "daytime");
    std::cout << "[" << endpoints->service_name()
              << "]:" << endpoints->host_name() << std::endl;

    // 创建链接
    tcp::socket socket(io_context);
    boost::asio::connect(socket, endpoints);

    for (int i = 0; i < 10; i++) {
      for (;;) {
        boost::array<char, 128> buf;
        boost::system::error_code error;

        size_t len = socket.read_some(boost::asio::buffer(buf), error);

        if (error == boost::asio::error::eof)
          break; // Connection closed cleanly by peer.
        else if (error)
          throw boost::system::system_error(error); // Some other error.

        std::cout.write(buf.data(), len);
      }
      std::cout << std::endl;
    }
  } catch (std::exception &e) {
    std::cerr << e.what() << std::endl;
  }

  return 0;
}
