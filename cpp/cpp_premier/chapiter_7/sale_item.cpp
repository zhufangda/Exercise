#include<string>
#include<iostream>

#include "sale_item.h"


SaleItem&  SaleItem::combine(const SaleItem& item){
    this->unitsSold += item.unitsSold;
    this->revenue += item.revenue;
    return *this;
}