public class Chicken extends Cookable implements PricedProduct
{
    @Override
    public String toString() {
        return "chicken";
    }

    @Override
    public int price() {
        return 50;
    }
}
