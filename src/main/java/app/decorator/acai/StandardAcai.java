package app.decorator.acai;

import app.decorator.Item;

public class StandardAcai implements Item {
    @Override
    public Double getPrice(){
        return 10d;
    }
    @Override
    public String getDescription(){
        return "Açai";
    }
}
