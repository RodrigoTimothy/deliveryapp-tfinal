package app;

import app.decorator.acai.StandardAcai;
import app.strategy.DNoDiscount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SOrderTest {
    private String orderId, restaurantName;
    private User user;
    private Order standardOrder, expressOrder;

    @BeforeEach
    void setUp(){
        this.restaurantName = "restaurante";
        this.orderId = "01";
        var noDiscount = new DNoDiscount();
        var item = new StandardAcai();
        this.standardOrder = OrderFactory.getInstance().createOrder("OrderStandard", orderId, restaurantName, noDiscount, item);
        this.expressOrder = OrderFactory.getInstance().createOrder("OrderStandard", orderId, restaurantName, noDiscount, item);
        this.user = new User("001", "usuario");
    }
    private String buildExpectedMessage(String status, String deliveryType) {
        return "Seu pedido #%s-%s do %s está com status: %s"
                .formatted(this.orderId, deliveryType, this.restaurantName, status);
    }

    @Test
    public void deveNotificarUsuarioComEntregaPadraoEstadoPreparacao(){
        this.user.placeOrder(standardOrder);
        this.standardOrder.preparing();
        var expectedMessage = this.buildExpectedMessage("Pedido em preparação", "STANDARD");
        assertEquals(expectedMessage, user.getLastNotification());
    }
    @Test
    public void deveNotificarUsuarioExpressoEstadoPreparacao(){
        this.user.placeOrder(expressOrder);
        this.expressOrder.preparing();
        var expectedMessage = this.buildExpectedMessage("Pedido em preparação", "EXPRESS");
        assertEquals(expectedMessage, user.getLastNotification());
    }
    @Test
    public void deveNotificarUsuarioPadraoPedidoCancelado(){
        this.user.placeOrder(standardOrder);
        this.standardOrder.preparing();
        this.standardOrder.cancel();
        var expectedMessage = this.buildExpectedMessage("Pedido em preparação", "STANDARD");
        this.standardOrder.cancel();
        expectedMessage = this.buildExpectedMessage("Pedido cancelado", "STANDARD");
        assertEquals(expectedMessage, user.getLastNotification());
    }
}