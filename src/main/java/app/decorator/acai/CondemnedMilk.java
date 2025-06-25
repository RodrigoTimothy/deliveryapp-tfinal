package app.decorator.acai;

import app.decorator.Item;

public class CondemnedMilk extends CondimentDecorator{
    public CondemnedMilk(Item item) {super(item);}

    @Override
    public String getDescription(){ return this.item.getDescription() + ", leite condensado"; }

    @Override
    public Double getPrice(){ return this.item.getPrice() + 3d; }
}
