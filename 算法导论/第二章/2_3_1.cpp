#include<vector>
#include<algorithm>

using namespace std;

void merge(vector<int> &array, int p, int q, int r){
      
    vector<int> left_array(array.begin()+p, array.begin()+q+1);
    vector<int> right_array(array.begin()+q+1, array.begin()+r+1);
    
    for(std::vector<int>::iterator it=array.begin()+p; it !=array.begin()+r+1; it++){


    }


}

int main(){

}