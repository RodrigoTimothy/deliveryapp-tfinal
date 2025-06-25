package app.decorator.acai;

import app.decorator.Item;

public class Strawberry extends CondimentDecorator{
    public Strawberry(Item item) {super(item);}

    @Override
    public String getDescription(){ return this.item.getDescription() + ", morango"; }

    @Override
    public Double getPrice(){ return this.item.getPrice() + 1d; }
}
