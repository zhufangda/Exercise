
#ifndef ASIO_EXERCISE_TUTORIAL_THREAD_H_
#define ASIO_EXERCISE_TUTORIAL_THREAD_H_

#include <sys/syscall.h>
int64_t GetThreadSimpleId() {
  return static_cast<int>(syscall(SYS_gettid));
}
#endif // ASIO_EXERCISE_TUTORIAL_THREAD_H_
