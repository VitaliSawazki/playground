public abstract class Beverage implements IBeverage {
String description = "Unknown beverage";

@Override
public String getDescription() {
return description;
}
@Override
public abstract double cost();
}