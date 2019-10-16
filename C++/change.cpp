#include <cmath>
#include <iostream>
using namespace std;

// Do not modify the Change​​​​​​‌​​​‌​​​‌​​​​‌​​​​‌​‌‌‌‌‌ structure
typedef struct {
    long coin2;
    long bill5;
    long bill10;
} Change;



void print_coins(int* coins){
    printf("Coin 2:%d\tBill 5:%d\tBill 10:%d\n", coins[0], coins[1], coins[2]);
}

class Answer
{
public:
    static bool optimalChange(long s, Change &c)
    {
        c.coin2 = 0;
        c.bill5 = 0;
        c.bill10 = 0;
        
        return false;
    }
};

bool optimalChange(long s, Change &c){
    int total = s;
    int money[] = {2, 5, 10};
    bool is_possible= false;
    
    for(int i=0; i<3; i++){
        long _sum = s;
        long _rel_sum = 0;
        long _total = 0 ;
        int coins[] = {0,0,0};
        
        coins[i] = _sum/money[i];
        _sum = _sum%money[i];
        _total += coins[i]; 
        _rel_sum += coins[i] * money[i];
        
        for(int j=0; j<3; j++){
            if(coins[j] != 0) continue;
                
            coins[j] = _sum/money[j];
            _sum = _sum%money[j];
            _total += coins[j];
            _rel_sum += coins[j] * money[j];
            
            for(int k=0; k<3; k++){
                if(coins[k] != 0) continue;
                coins[k] = _sum/money[k];
                _sum = _sum%money[k];
                _total += coins[k];
                _rel_sum += coins[k] * money[k];

                printf("I:%d\tJ:%d\tK:%d\n",money[i], money[j], money[k]);
                print_coins(coins);
                if(_total < total && _rel_sum == s){
                    c.coin2 = coins[0];
                    c.bill5 = coins[1];
                    c.bill10 = coins[2];
                    is_possible= true;
                }   
            
            }
        
        }
        
    }
    return is_possible;
    
}

int main(){
    long s = 15;
    Change change;
    bool is_possible = optimalChange(s, change);

    cout << "Coin 2 : " << change.coin2 << endl;
    cout << "Bill 5 : " << change.bill5 << endl;
    cout << "Bill 10 : " << change.bill10 << endl;

    int result = 2*change.coin2 + 5*change.bill5 + 10 * change.bill10;
    cout << "Result:" << result << endl;
}
