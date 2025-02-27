public class Mocha extends CondimentDecorator {
    IBeverage beverage;

    public Mocha(IBeverage beverage) {
        this.beverage=beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + " + Mocha";
    }

    public double cost() {
        return .20 + beverage.cost();
    }
}