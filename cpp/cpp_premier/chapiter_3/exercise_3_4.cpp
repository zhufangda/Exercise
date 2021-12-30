#include<iostream>
#include<string>

using namespace std;

int main(){
    cout << "Compare Content:" << endl;
    cout << 
    string word;
    string line;
    cout << "Type one line:";
    getline(cin, line);
    cout << line << std::endl;
    cout << "Type one word:";
    cin >> word;
    cout << word << endl;
    return 0;
}