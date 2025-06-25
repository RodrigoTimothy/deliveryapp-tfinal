package app.strategy;

public class DFixed implements DStrategy {
    private double discountAmount;

    public DFixed(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double calculateDiscount(double totalAmount) {
        return Math.min(totalAmount, discountAmount);
    }

}
