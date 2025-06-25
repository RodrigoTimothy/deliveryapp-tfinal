package app;

import app.decorator.Item;
import app.decorator.acai.*;
import app.strategy.DNoDiscount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class DecoratorTest {
    private String orderId, restaurantName;
    private User user;
    private Order order;
    private OrderFactory orderFactory;
    private Item acai;

    @BeforeEach
    void setUp() {
        this.restaurantName = "Açaiteria Foda";
        this.orderId = "01";

        var discount = new DNoDiscount();
        this.orderFactory = OrderFactory.getInstance();
        this.user = new User("001", "Kreiton");
        this.order =
                orderFactory.createOrder("OrderStandard", this.orderId, this.restaurantName, discount,this.acai);
    }
    @Test
    void deveRetornarAcaiBasico(){
        Item item = new StandardAcai();
        order.setItem(item);
        assertEquals("Açai", order.getDescription());
        assertEquals(10d, order.getFinalAmount(), 0.01);
    }

    @Test
    void deveRetornarAcaiComUva(){
        Item item = new StandardAcai();
        Item grape = new Grape(item);
        order.setItem(grape);
        assertEquals("Açai, uva", order.getDescription());
        assertEquals(12d, order.getFinalAmount(), 0.01);
    }
    @Test
    void deveRetornarAcaiComUvaMorango(){
        Item item = new StandardAcai();
        Item grape = new Grape(item);
        Item strawberry = new Strawberry(grape);
        order.setItem(strawberry);
        assertEquals("Açai, uva, morango", order.getDescription());
        assertEquals(13d, order.getFinalAmount(), 0.01);
    }
    @Test
    void deveRetornarAcaiComUvaMorangoBanana(){
        Item item = new StandardAcai();
        Item grape = new Grape(item);
        Item strawberry = new Strawberry(grape);
        Item banana = new Banana(strawberry);
        order.setItem(banana);
        assertEquals("Açai, uva, morango, banana", order.getDescription());
        assertEquals(16d, order.getFinalAmount(), 0.01);
    }
    @Test
    void deveRetornarAcaiComUvaMorangoBananaAmendoim(){
        Item item = new StandardAcai();
        Item grape = new Grape(item);
        Item strawberry = new Strawberry(grape);
        Item banana = new Banana(strawberry);
        Item nuts = new Nuts(banana);
        order.setItem(nuts);
        assertEquals("Açai, uva, morango, banana, amendoim", order.getDescription());
        assertEquals(19d, order.getFinalAmount(), 0.01);
    }
}