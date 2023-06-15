#include <sys/ipc.h>
#include <unistd.h>
#include <cstdio>
#include <sys/shm.h>
#include <cstring>

constexpr int MAX_LINE = 26;


int main(int argv, char** argc){
    // 创建key
    key_t key = ftok("/dev/shm/test", 0);
    // 获取共享存储标识符
    int shm_id = shmget(key, 0x400000, IPC_CREAT|0660);
    printf("IPC Key = %d SHM ID=%d\n", key, shm_id);
    char *p = (char*) shmat(shm_id, NULL, 0);
    
    memset(p, 'A', 0x400000);
    shmdt(p);
    return 0;
}

