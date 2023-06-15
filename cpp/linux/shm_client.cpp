#include <sys/ipc.h>
#include <unistd.h>
#include <cstdio>
#include <sys/shm.h>
#include <cstring>

constexpr int MAX_LINE = 26;


int main(int argv, char** argc){
    // 创建key
    key_t key = ftok("/dev/shm/test", 0);

    // 获取共享存储标识符, 返回值为shm_id, 通过ipcs可以查询
    int shm_id = shmget(key, 0x400000, 0660);
    printf("IPC Key = %d SHM ID=%d\n", key, shm_id);
    char *p = (char*) shmat(shm_id, NULL, 0);
    
    printf("%c %c %c %c\n", p[0], p[1], p[2], p[3]);
    return 0;
}