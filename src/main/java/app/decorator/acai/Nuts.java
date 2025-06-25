package app.decorator.acai;

import app.decorator.Item;

public class Nuts extends CondimentDecorator{
    public Nuts(Item item) {super(item);}

    @Override
    public String getDescription(){ return this.item.getDescription() + ", amendoim"; }

    @Override
    public Double getPrice(){ return this.item.getPrice() + 3d; }
}
