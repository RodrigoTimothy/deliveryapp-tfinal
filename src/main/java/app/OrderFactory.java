package app;

import app.decorator.Item;
import app.strategy.DStrategy;

import java.lang.reflect.Constructor;

public class OrderFactory {
    private static OrderFactory instance;

    private OrderFactory() {}

    public static OrderFactory getInstance() {
        if (instance == null) {
            instance = new OrderFactory();
        }

        return instance;
    }

    public Order createOrder(
            String type,
            String orderId,
            String restaurantName,
            DStrategy discountStrategy,
            Item item) {
        Class<?> clazz = null;
        Object obj = null;
        try {
            clazz = Class.forName("app." + type);

            Constructor<?> constructor =
                    clazz.getDeclaredConstructor(
                            String.class, String.class, DStrategy.class, Item.class);

            obj = constructor.newInstance(orderId, restaurantName, discountStrategy, item);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid order type");
        }
        if (!(obj instanceof Order)) {
            throw new IllegalArgumentException("Invalid order type");
        }
        return (Order) obj;
    }
}