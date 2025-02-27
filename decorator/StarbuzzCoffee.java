public class StarbuzzCoffee {
    public static  void main(String args[]) {

        IBeverage beverage = new Espresso();
        System.out.println(beverage.getDescription()
        + " $" + beverage.cost());

        IBeverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.getDescription()
        + " $" + beverage2.cost());
    }
}