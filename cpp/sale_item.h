#include<string>
#include<iostream>

class SaleItem{

    private:
        std::string isbn;
        unsigned unitsSold = 0;
        double revenue = 0.0;

    public:
        std::string getISBN() const;
};