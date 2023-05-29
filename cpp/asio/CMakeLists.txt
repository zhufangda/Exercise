cmake_minimum_required(VERSION 3.14)

project(asio_exercise)

set(CMAKE_CXX_STANDARD 17)
set(FETCHCONTENT_QUIET FALSE)
cmake_policy(SET CMP0135 NEW)

find_package(Threads)

include(FetchContent)

message("Fetch Boost")

FetchContent_Declare(
  Boost
  URL https://github.com/boostorg/boost/releases/download/boost-1.81.0/boost-1.81.0.tar.xz
  URL_MD5 6cf0cdd797bca685910d527ae3c08cb3
  DOWNLOAD_EXTRACT_TIMESTAMP ON
)

FetchContent_MakeAvailable(Boost)

message("BOOST_INCLUDE_LIBRARIES=${BOOST_INCLUDE_LIBRARIES}")
message("Boost_LIBRARIES=${Boost_LIBRARIES}")

message("Fetch GLog")
FetchContent_Declare(
  glog
  URL https://github.com/google/glog/archive/v0.6.0.zip
  URL_HASH SHA256=122fb6b712808ef43fbf80f75c52a21c9760683dae470154f02bddfc61135022
)

FetchContent_MakeAvailable(glog)
FetchContent_GetProperties(glog)
if(NOT glog_POPULATED)
  FetchContent_Populate(glog)
endif()

add_subdirectory(tutorial)
