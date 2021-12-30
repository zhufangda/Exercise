#include <string>
#include <iostream> 
#include <cstdlib>
#include <vector>
#include "sale_item.h"


int main(int argc, char const *argv[])
{
    
    double price;
    std::vector<SaleItem> transactions;

    std::cout << "Type transaction:" << std::endl;
    for(int i=0;i<100; i++){

        std::cout << "<<<<<<<<<< Transaction " << i <<" >>>>>>>>>>" << std::endl;
        std::cout << "ISBN:" ;


        std::string isbn;
        std::cin >> isbn;

        if(isbn=="-1"){
            break;
        }

        int unitsSold;
        std::cout << "Units sold:";
        std::cin >> unitsSold;

        double price;
        std::cout << "Price:";
        std::cin >> price;
        
        SaleItem item = SaleItem(isbn, unitsSold, unitsSold*price);
        transactions.push_back(item);
    }


    std::cout << "<<<<<< Summary >>>>>>>" << std::endl;
    
    if(transactions.size()==0){
        std::cerr << "No transactions found"<<std::endl;
    }

    std::vector<SaleItem>::iterator it;

    SaleItem result = SaleItem(transactions.front().getISBN());

    for(it=transactions.begin(); it<transactions.end(); it++){
        if(it->getISBN()!=result.getISBN()){
            std::cerr << "Data must refer to the same ISBN" << std::endl;
        }
        result.combine(*it);
    }


    std::cout << "ISBN:\t" << result.getISBN() << std::endl;
    std::cout << "Total Cnt:\t" << result.getUnitsSold() << std::endl;
    std::cout << "Total Revenue:\t" << result.getRevenue() << std::endl;
    std::cout << "Price:\t";


    if(result.getRevenue()==0){
        std::cout << "(no sales)" << std::endl;
    }else{
        std::cout << result.getRevenue() / result.getUnitsSold() << std::endl;
    }

    return 0;


}