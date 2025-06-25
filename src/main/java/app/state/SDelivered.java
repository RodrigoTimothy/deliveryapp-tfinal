package app.state;

public class SDelivered extends SOrder{
    SDelivered() {}

    private static SDelivered instance = new SDelivered();

    public static SDelivered getInstance() {
        return instance;
    }

    @Override
    public String getDescription() {
        return "Pedido entregue";
    }
}
