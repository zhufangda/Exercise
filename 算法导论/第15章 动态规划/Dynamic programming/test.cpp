/*
 * @Author: your name
 * @Date: 2019-11-01 10:44:42
 * @LastEditTime: 2019-11-01 10:46:00
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Dynamic programming\test.cpp
 */
#include <iostream>
#include<cstdio>

using namespace std;

struct ListNode{
    ListNode* next = nullptr;
    int val;
    
    ListNode(){
        this->val = 0;
    }
    
};

ListNode* reverse(ListNode* head){
    ListNode* iter = head;
    ListNode* prev = nullptr;
    
    while(iter->next!=nullptr){
        ListNode* tmp = iter->next;
        iter->next = prev;
        prev = iter;
        iter = tmp;
    }
    iter->next = prev;
    return iter;
}

void printList(ListNode* head){
     while(head != nullptr){
        printf("%d->", head->val);
    }
    printf("\n");
}

int main() {
    
    int a[3] = {2, 4, 3};
    int b[3] = {5, 6, 4};
    
    cout << "Hello World!" << endl;
    ListNode* head1 = new ListNode();
    ListNode* head2 = new ListNode();
    
    ListNode* iter = nullptr;
    
    iter = head1;
    for(int i=0;i<3;i++){
        iter->next = new ListNode();
        iter = iter->next;
        iter->val = a[i];
    }
    
    iter = head2;
    for(int i=0;i<3;i++){
        iter->next = new ListNode();
        iter = iter->next;
        iter->val = b[i];
    }
    
    head1 = reverse(head1->next);
    head2 = reverse(head2->next);
    ListNode* resultHead = head1;
    
    printList(head1);
    
    int carry = 0;
    ListNode* prev = head1;
    while(head2!=nullptr){
       int val1 = head1==nullptr?0:head1->val;
       int val2 = head2==nullptr?0:head2->val;

       int sum  = head1->val + head2->val +carry;
        
       head1->val = sum%10;
       carry = sum/10;
        
       head1 = head1->next == nullptr? new ListNode(): head1->next;
       head2 = head2->next;
    }
    
    head1->next->val = carry + head1->next->val;
    if(head1->next->val == 0){
        head1->next = nullptr;
    }
    
    resultHead = reverse(resultHead);
    
    while(resultHead != nullptr){
        printf("%d->", resultHead->val);
    }
    
}




