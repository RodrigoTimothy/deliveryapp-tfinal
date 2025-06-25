package app.decorator.acai;

import app.decorator.Item;

public class CondimentDecorator implements Item {
    protected Item item;

    public CondimentDecorator(Item item) {
        this.item = item;
    }
    @Override
    public String getDescription(){ return this.item.getDescription(); }

    @Override
    public Double getPrice() { return this.item.getPrice(); }
}
