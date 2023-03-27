#include "common.h"

namespace common {
    int DAL::data = 5;
    DAL* DAL::pInstance;
    DAL* DAL::GetInstance(){
        if(pInstance==nullptr){
            pInstance = new DAL();
        }
        return pInstance;
    }
}

