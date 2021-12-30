#include <iostream>
#include <boost/asio.hpp>
#include <boost/bind/bind.hpp>
#include <boost/date_time/posix_time/posix_time.hpp>

class Printer{
  public:
    Printer(boost::asio::io_context& io)
    : timer_(io, boost::posix_time::seconds(0)), 
    count_(0),
    last_execute_time_(boost::posix_time::microsec_clock::local_time())
    {
      this->timer_.async_wait(boost::bind(&Printer::print, this));
    }
    ~Printer(){
       std::cout << "Final count is " << this->count_ << std::endl;
    }

    void print(){
      if(this->count_ < 5){
        std::cout << "Current CNT:" << this->count_ << "\t Expiration Time" << timer_.expires_at() << "\t Current Time:"<< boost::posix_time::microsec_clock::local_time()<< std::endl;
        this->count_++;
        this->timer_.expires_at(timer_.expires_at() + boost::posix_time::seconds(1));
        this->timer_.async_wait(boost::bind(&Printer::print, this));
        timer
      }
    }

    private:
      boost::asio::deadline_timer timer_;
      int count_;
      decltype(boost::posix_time::microsec_clock::local_time()) last_execute_time_;

};

int main()
{
  boost::asio::io_context io;
  Printer p(io);
  io.run();

  return 0;
}