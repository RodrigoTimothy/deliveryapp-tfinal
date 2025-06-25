package app.decorator.acai;

import app.decorator.Item;

public class Grape extends CondimentDecorator{
    public Grape(Item item) {super(item);}

    @Override
    public String getDescription(){ return this.item.getDescription() + ", uva"; }

    @Override
    public Double getPrice(){ return this.item.getPrice() + 2d; }
}
