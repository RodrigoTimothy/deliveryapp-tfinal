package app.decorator.acai;

import app.decorator.Item;

public class Banana extends CondimentDecorator{
    public Banana(Item item) {super(item);}

    @Override
    public String getDescription(){ return this.item.getDescription() + ", banana"; }

    @Override
    public Double getPrice(){ return this.item.getPrice() + 3d; }
}
