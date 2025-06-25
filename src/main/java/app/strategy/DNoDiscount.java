package app.strategy;

public class DNoDiscount implements DStrategy{
    @Override
    public double calculateDiscount(double totalAmount) {
        return 0;
    }
}