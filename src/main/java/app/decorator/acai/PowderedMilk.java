package app.decorator.acai;

import app.decorator.Item;

public class PowderedMilk extends CondimentDecorator{
    public PowderedMilk(Item item) {super(item);}

    @Override
    public String getDescription(){ return this.item.getDescription() + ", leite em po"; }

    @Override
    public Double getPrice(){ return this.item.getPrice() + 3d; }
}
