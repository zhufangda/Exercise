project(asio_tutorial)

add_executable(tutorial_1 tutorial_1.cpp)
target_link_libraries(tutorial_1 Boost::asio)

add_executable(tutorial_2 tutorial_2.cpp)
target_link_libraries(tutorial_2 Boost::asio glog::glog)

add_executable(tutorial_3 tutorial_3.cpp)
target_link_libraries(tutorial_3 Boost::asio glog::glog)

add_executable(tutorial_4 tutorial_4.cpp)
target_link_libraries(tutorial_4 Boost::asio glog::glog)

add_executable(tutorial_5 tutorial_5.cpp)
target_link_libraries(tutorial_5 Boost::asio glog::glog Boost::thread)


add_executable(tutorial_6 tutorial_6.cpp)
target_link_libraries(tutorial_6 Boost::asio glog::glog Boost::thread)


add_executable(datetime_1 datetime_1.cpp)
target_link_libraries(datetime_1 Boost::asio glog::glog Boost::thread)
