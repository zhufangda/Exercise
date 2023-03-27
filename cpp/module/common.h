#ifndef COMMON_H
#define COMMON_H


namespace common{
class DAL{
    public:static DAL* pInstance;
    static DAL* GetInstance();

    static int data;
};

}

#endif