package app.strategy;

public class DPercentage implements DStrategy{
    private double percentage;

    public DPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double calculateDiscount(double totalAmount) {
        var discountPrice = totalAmount * (percentage / 100.0);
        if (discountPrice > totalAmount) {
            return totalAmount;
        }

        return discountPrice;
    }
}
