package app;

import app.decorator.Item;
import app.strategy.DStrategy;

public class OrderExpress extends Order{
    public OrderExpress(
            String orderId,
            String restaurantName,
            DStrategy discountStrategy,
            Item item) {
        super(orderId + "-EXPRESS", restaurantName, discountStrategy, item);
    }
}
