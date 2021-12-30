#include<string>
#include<iostream>

class SaleItem{

    private:
        std::string isbn;
        unsigned unitsSold = 0;
        double revenue = 0.0;

    public:
        SaleItem(const std::string& isbn, const int& unitsSold, const double& revenue){
            this->isbn = isbn;
            this->unitsSold = unitsSold;
            this->revenue = revenue;
        }

        SaleItem(const std::string& isbn){
            this->isbn = isbn;
        }
        
        std::string getISBN() const{
            return this->isbn;
        }
        
        int getUnitsSold() const{
            return this->unitsSold;
        }

        double getRevenue() const{
            return this->revenue;
        }

        SaleItem& combine(const SaleItem& item);
};