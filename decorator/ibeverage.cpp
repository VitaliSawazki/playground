#include <string>
#include <iostream>

class IBeverage
{
    public:

    virtual std::string getDescription() const = 0;

    virtual double cost() const = 0;
};

class Espresso : public IBeverage {
    private:
    const double price = 1.99;

    public:
    std::string description = "Espresso";
    std::string getDescription() const override
    {
        return description;
    }
    double cost() const override {
        return price;
    }
};

class ICondimentDecorator : public IBeverage
{
    protected:
    IBeverage* ibptr;

    public:
    ICondimentDecorator(IBeverage* ib)
    : ibptr(ib) {}

    std::string getDescription() const override
    {
        return "blabla";
    }
    double cost() const override
    {
        return ibptr->cost();
    }
};

class Mocha : public ICondimentDecorator
{
    public:
    Mocha(IBeverage* ib)
    : ICondimentDecorator(ib) {}

    std::string getDescription() const override {
        return ibptr->getDescription() + " and  Mocha";
    }

    double cost() const override {
        return ibptr->cost() + 0.5;
    }
};

int main(){
IBeverage* espresso = new Espresso();
std::cout << espresso->getDescription() + ", costs $" << espresso->cost() << std::endl;
IBeverage* espressoMocha = new Mocha(espresso);
espressoMocha->getDescription();
//std::cout << espressoMocha->getDescription() << espressoMocha->cost() << std::endl;

std::cout << espressoMocha->getDescription() + ", costs $" << espressoMocha->cost() << std::endl;
};