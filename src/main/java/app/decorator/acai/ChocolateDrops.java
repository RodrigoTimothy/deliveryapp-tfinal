package app.decorator.acai;

import app.decorator.Item;

public class ChocolateDrops extends CondimentDecorator{
    public ChocolateDrops(Item item) {super(item);}

    @Override
    public String getDescription(){ return this.item.getDescription() + ", gotas de chocolate"; }

    @Override
    public Double getPrice(){ return this.item.getPrice() + 3d; }
}
