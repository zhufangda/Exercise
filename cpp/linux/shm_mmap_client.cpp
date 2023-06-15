#include <cstdint>
#include <errno.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

int main(int argc, char **argv) {
  int ret;
  int fd;
  void *addr;
  struct stat s;

  if (argc != 2) {
    printf("%s [filename]\n", argv[0]);
    return -1;
  }

  fd = open(argv[1], O_RDWR);
  if (fd < 0) {
    printf("failed to open %s\n", argv[1]);
    return -1;
  }

  ret = stat(argv[1], &s);
  if (ret < 0) {
    printf("failed to stat %s\n", argv[1]);
    return -1;
  } else {
    printf("ID of device containing file    :\t%lu\n", s.st_dev);
    printf("Inode number                    :\t%lu\n", s.st_ino);
    printf("File type and mode              :\t%d\n", s.st_mode);
    printf("Number of hard lin              :\t%lu\n", s.st_nlink);
    printf("User ID of owner                :\t%d\n", s.st_uid);
    printf("Group ID of owner               :\t%d\n", s.st_gid);
    printf("Device ID (if special file)     :\t%lu\n", s.st_rdev);
    printf("Total size, in bytes            :\t%ld\n", s.st_size);
    printf("Block size for filesystem I/O   :\t%ld\n", s.st_blksize);
    printf("Number of 512B blocks allocated :\t%ld\n", s.st_blocks);
  }

  addr = mmap(NULL, s.st_size, PROT_READ | PROT_WRITE, MAP_PRIVATE, fd, 0);
  if (!addr) {
    printf("Failed to mmap %s\n", strerror(errno));
    return -1;
  }

  printf("data at the address %p is %s\n", addr, addr);
  munmap(addr, s.st_size);
  close(fd);
  return 0;
}