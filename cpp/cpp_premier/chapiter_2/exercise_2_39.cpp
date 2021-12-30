#include <string>
#include <iostream> 
#include <cstdlib>
#include <vector>
struct SalesData{
    std::string isbn;
    unsigned int unitsSold = 0;
    double revenue = 0.0;
};


int main(int argc, char const *argv[])
{
    
    double price;
    std::vector<SalesData> transactions;

    std::cout << "Type transaction:" << std::endl;
    for(int i=0;i<100; i++){
        SalesData data;
        std::cout << "<<<<<<<<<< Transaction " << i <<" >>>>>>>>>>" << std::endl;
        std::cout << "ISBN:" ;
        std::cin >> data.isbn;

        if(data.isbn=="-1"){
            break;
        }

        std::cout << "Units sold:";
        std::cin >> data.unitsSold;
        std::cout << "Price:";
        std::cin >> price;
        data.revenue = data.unitsSold * price;
        transactions.push_back(data);

    }


    std::cout << "<<<<<< Summary >>>>>>>" << std::endl;
    
    if(transactions.size()==0){
        std::cerr << "No transactions found"<<std::endl;
    }

    std::vector<SalesData>::iterator it;
    unsigned totalCnt = 0;
    double totalRevenue = 0;
    std::string isbn = transactions.front().isbn;

    for(it=transactions.begin(); it<transactions.end(); it++){
        totalCnt += it->unitsSold;
        totalRevenue += it->revenue;
        if(it->isbn!=isbn){
            std::cerr << "Data must refer to the same ISBN" << std::endl;
        }
    }


    std::cout << "ISBN:\t" << isbn << std::endl;
    std::cout << "Total Cnt:\t" << totalCnt << std::endl;
    std::cout << "Total Revenue:\t" << totalRevenue << std::endl;
    std::cout << "Price:\t";


    if(totalCnt==0){
        std::cout << "(no sales)" << std::endl;
    }else{
        std::cout << totalRevenue / totalCnt << std::endl;
    }

    return 0;


}