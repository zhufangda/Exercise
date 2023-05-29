#include <cstdint>
#include <iostream>
#include <string>

// 测试自类方法对父类方法的隐藏

//父类
class A{
public:
    virtual void fun(int a){
		std::cout << "A中的fun函数" << std::endl;
	}

    virtual void fun(char* a) {
	   std::cout << "A中的fun函数" << std::endl;
   }
};

//子类
class B : public A{
public:
    using A::fun;
    //隐藏父类的fun函数
   void fun(char* a) override {
	   std::cout << "A中的fun函数" << std::endl;
   }
};


int main(){
    B b;
    b.fun(2); //报错，调用的是B中的fun函数，参数类型不对
    b.A::fun(2); //调用A中fun函数
    return 0;
}