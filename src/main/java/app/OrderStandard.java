package app;

import app.decorator.Item;
import app.strategy.DStrategy;

public class OrderStandard extends Order{
    public OrderStandard(
            String orderId,
            String restaurantName,
            DStrategy discountStrategy,
            Item item) {
        super(orderId + "-STANDARD", restaurantName, discountStrategy, item);
    }
}
