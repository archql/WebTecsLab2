package com.archql.labs.householddevices;

/**
 * class fridge that holds general information of a fridge device
 * property <b>power</b> refers to a power consumption in watts
 * property <b>height</b> refers to its height in cm
 * property <b>width</b> refers to its width in cm
 * property <b>color</b> refers to color
 * @see Device to learn about base class
 * @version 1.0
 */
public class Fridge extends Device {

    /**
     * creates an empty instance of Fridge only type set
     * @see Device#Device(Type)
     */
    public Fridge() { super(Type.Fridge);}
    /**
     * initializes base instance
     * @see Device#Device(Type, String, String, String, int)
     */
    public Fridge(String name, String manufacturerName, String article, int price) {
        super(Type.Fridge, name, manufacturerName, article, price);
    }
    /**
     * initializes base instance
     * includes Fridge characteristics
     * @see Device#Device(Type, String, String, String, int)
     */
    public Fridge(String name, String manufacturerName, String article, int price, int power, int height, int width, Color color) {
        super(Type.Fridge, name, manufacturerName, article, price);
        this.power = power;
        this.height = height;
        this.width = width;
        this.color = color;
    }
    /**
     * initializes extended instance
     * includes Fridge characteristics
     * @see Device#Device(Type, String, String, String, int, boolean)
     */
    public Fridge(String name, String manufacturerName, String article, int price, boolean isOnStall, int power, int height, int width, Color color) {
        super(Type.Fridge, name, manufacturerName, article, price, isOnStall);
        this.power = power;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    /** property <b>power</b> refers to a power consumption in watts*/
    public int power = 300;
    /** property <b>height</b> refers to its height in cm */
    public int height = 150;
    /** property <b>width</b> refers to its width in cm */
    public int width = 100;
    /** property <b>color</b> refers to color */
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
