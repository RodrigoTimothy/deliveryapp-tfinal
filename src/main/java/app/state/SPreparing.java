package app.state;

import app.Order;

public class SPreparing extends SOrder{
    SPreparing() {}

    private static SPreparing instance = new SPreparing();

    public static SPreparing getInstance() {
        return instance;
    }

    @Override
    public boolean cancel(Order order) {
        order.setState(SCancelled.getInstance());
        return true;
    }

    @Override
    public boolean onTheWay(Order order) {
        order.setState(SOnTheWay.getInstance());
        return true;
    }

    @Override
    public String getDescription() {
        return "Pedido em preparação";
    }
}
