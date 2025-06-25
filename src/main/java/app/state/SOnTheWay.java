package app.state;

public class SOnTheWay extends SOrder{
    SOnTheWay() {}

    private static SOnTheWay instance = new SOnTheWay();

    public static SOnTheWay getInstance() {
        return instance;
    }

    @Override
    public String getDescription() {
        return "Pedido a caminho";
    }
}
