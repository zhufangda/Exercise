#include <vector>
#include "common/print.h"

// 844. 比较含退格的字符串

void treateData(std::string& s){
        int n = s.size();
        int slow = 0;
        for(int i=0;i<n;i++){
            if(s[i]!='#'){
                s[slow++] = s[i];  
            }else if(slow>0){
                s[--slow]='\0';
            }
            std::cout << "input = " << s << std::endl;
        }
        s.resize(slow);
}

bool backspaceCompare(std::string s, std::string t) {
    treateData(s);
    treateData(t);
    return s == t;
}



int main(){
    std::string input {"ab#c"};
    auto result = backspaceCompare("ab#c", "ad#c");
    std::cout << "result = " << result << std::endl;;

    result = backspaceCompare("ab##", "ab##");
    std::cout << "result = " << result << std::endl;;

    result = backspaceCompare("a#c", "b");
    std::cout << "result = " << result << std::endl;;

    return 1;
}