package com.archql.labs.householddevices;

public class Kettle extends Device{

    public int power;
    public String material;
    public Color color;
    public boolean hasWhistle;

    public Kettle() { super(Type.Kettle);}

    public Kettle(String name, String manufacturerName, String article, int price) {
        super(Type.Kettle, name, manufacturerName, article, price);
        this.power=750;
        this.color=Color.Black;
        this.hasWhistle=false;
    }

    public Kettle(String name, String manufacturerName, String article, int price, int power, String material, Color color, boolean hasWhistle) {
        super(Type.Kettle, name, manufacturerName, article, price);
        this.power=power;
        this.material=material;
        this.color=color;
        this.hasWhistle=hasWhistle;
    }

    public Kettle(String name, String manufacturerName, String article, int price, boolean isOnStall, int power, String material, Color color, boolean hasWhistle) {
        super(Type.Kettle, name, manufacturerName, article, price, isOnStall);
        this.power=power;
        this.material=material;
        this.color=color;
        this.hasWhistle=hasWhistle;
    }

    @Override
    public String toString() {
        return "Kettle{" +
                "power=" + power +
                ", material='" + material + '\'' +
                ", color=" + color +
                ", hasWhistle=" + hasWhistle +
                "} " + super.toString();
    }
}
