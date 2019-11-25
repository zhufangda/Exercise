/*
 * @Author: your name
 * @Date: 2019-11-02 19:35:17
 * @LastEditTime: 2019-11-02 21:59:23
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \第10章 基本数据结构\stack.cpp
 */

class Stack{
    private:
        int* array;
        int top;
        int capacity;
        int size;
    public:
        Stack();
        Stack(int capacity);
        bool isEmpty();
        bool push(int val);
        int pop();
        int peek();
};

Stack::Stack(){
    this->capacity = 10;
    this->array = new int[capacity];
    this->top = -1;
}

Stack::Stack(int capacity){
    this->capacity = capacity;

}
bool Stack::isEmpty(){
    return this->top = -1;
}

bool Stack::push(int val){
    if(top==capacity-1){
        this->capacity<<1;
        int oldCapacity = 
        int* newArray = new int[capacity];
        for(int i=0)
    }
}

