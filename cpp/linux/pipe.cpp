#include <unistd.h>
#include <stdio.h>
#include <iostream>

constexpr int MAX_LINE = 26;


int main(int argv, char** argc){
    int n;
    int fd[2];
    pid_t pid;
    char line[MAX_LINE];

    if(pipe(fd)<0){
        std::cerr << "PIPE Error"<<std::endl;
    }

    if((pid = fork()) <0){
        printf("Fork error\n");
    }else if(pid>0) { // parent 
        printf("Parent\t%d\tfd\t%d\n", pid, fd[0]);
        close(fd[0]);
        write(fd[1], "Hello world\n", 12);
    }else{
        printf("Child\t%d\tfd\t%d\n", pid, fd[1]);
        close(fd[1]);
        n = read(fd[0], line, MAX_LINE);
        write(STDOUT_FILENO, line, n);
    }
    return 0;
}