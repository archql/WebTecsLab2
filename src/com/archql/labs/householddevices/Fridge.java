package com.archql.labs.householddevices;

public class Fridge extends Device {

    public Fridge() { super(Type.Fridge);}
    public Fridge(String name, String manufacturerName, String article, int price) {
        super(Type.Fridge, name, manufacturerName, article, price);
    }

    public Fridge(String name, String manufacturerName, String article, int price, int power, int height, int width, Color color) {
        super(Type.Fridge, name, manufacturerName, article, price);
        this.power = power;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public Fridge(String name, String manufacturerName, String article, int price, boolean isOnStall, int power, int height, int width, Color color) {
        super(Type.Fridge, name, manufacturerName, article, price, isOnStall);
        this.power = power;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public int power = 300;
    public int height = 150;
    public int width = 100;
    public Color color = Color.Black;

    @Override
    public String toString() {
        return "Fridge{" +
                "power=" + power +
                ", height=" + height +
                ", width=" + width +
                ", color=" + color +
                "} " + super.toString();
    }
}
