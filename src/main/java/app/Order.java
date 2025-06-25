package app;

import app.decorator.Item;
import app.state.SConfirmed;
import app.state.SOrder;
import app.strategy.DStrategy;

import java.util.Observable;

public abstract class Order extends Observable {
    private String orderId, restaurantName;
    private DStrategy discountStrategy;
    private Item item;
    private SOrder state;

    public Order(
            String orderId,
            String restaurantName,
            DStrategy discountStrategy,
            Item item) {

        this.orderId = orderId;
        this.restaurantName = restaurantName;
        this.state = SConfirmed.getInstance();
        this.discountStrategy = discountStrategy;
        this.item = item;
    }

    public boolean confirmed()     { return this.state.confirmed(this); }
    public boolean preparing()     { return this.state.preparing(this); }
    public boolean onTheWay()      { return this.state.onTheWay(this); }
    public boolean delivered()     { return this.state.delivered(this); }
    public boolean cancel()        { return this.state.cancel(this); }

    public void setState(SOrder state) {
        this.state = state;
        this.setChanged();
        this.notifyObservers(
                "Seu pedido #%s do %s está com status: %s"
                        .formatted(this.orderId, this.restaurantName, this.state.getDescription()));
    }

    public String getOrderId()           { return orderId; }
    public String getRestaurantName()    { return restaurantName; }
    public SOrder getState()         { return state; }
    public void setDiscount(DStrategy strategy) { this.discountStrategy = strategy; }
    public void setItem(Item item)   { this.item = item; }
    public String getDescription()       { return this.item.getDescription(); }

    public double getFinalAmount() {
        var totalAmount = this.item.getPrice();
        double discount = discountStrategy.calculateDiscount(totalAmount);
        return totalAmount - discount;
    }
}
