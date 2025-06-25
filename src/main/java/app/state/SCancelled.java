package app.state;

public class SCancelled extends SOrder {
    SCancelled() {}

    private static SCancelled instance = new SCancelled();

    public static SCancelled getInstance() {
        return instance;
    }

    @Override
    public String getDescription() {
        return "Pedido cancelado";
    }
}
