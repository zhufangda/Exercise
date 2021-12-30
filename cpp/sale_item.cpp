#include<string>
#include<iostream>

#include "sale_item.h"

std::string SaleItem::getISBN() const{
    return this->isbn;
}


std::string& combine(const SaleItem& item){
    this->unitsSold += item.unitsSold;
    this->revenue += item.revenue;
    return *this;
}
