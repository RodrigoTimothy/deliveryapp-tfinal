package app.state;

import app.Order;

public class SConfirmed extends SOrder {
    SConfirmed() {}

    private static SConfirmed instance = new SConfirmed();

    public static SConfirmed getInstance() {
        return instance;
    }

    @Override
    public boolean cancel(Order order) {
        order.setState(SCancelled.getInstance());
        return true;
    }

    @Override
    public boolean preparing(Order order) {
        order.setState(SPreparing.getInstance());
        return true;
    }

    @Override
    public String getDescription() {
        return "Pedido confirmado";
    }
}
