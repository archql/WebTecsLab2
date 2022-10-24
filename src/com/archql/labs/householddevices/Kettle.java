package com.archql.labs.householddevices;

/**
 * class Kettle that holds general information of a Kettle device
 * property <b>power</b> refers to a power consumption in watts
 * property <b>material</b> refers to its material
 * property <b>hasWhistle</b> whether kettle has a whistle installed
 * property <b>color</b> refers to color
 * @see Device to learn about base class
 * @version 1.0
 */
public class Kettle extends Device{

    /** property <b>power</b> refers to a power consumption in watts*/
    public int power;
    /** property <b>material</b> refers to its material */
    public String material;
    /** property <b>color</b> refers to color */
    public Color color;
    /** property <b>hasWhistle</b> whether kettle has a whistle installed */
    public boolean hasWhistle;

    /**
     * creates an empty instance of Kettle only type set
     * @see Device#Device(Type)
     */
    public Kettle() { super(Type.Kettle);}
    /**
     * initializes base instance
     * @see Device#Device(Type, String, String, String, int)
     */
    public Kettle(String name, String manufacturerName, String article, int price) {
        super(Type.Kettle, name, manufacturerName, article, price);
        this.power=750;
        this.color=Color.Black;
        this.hasWhistle=false;
    }
    /**
     * initializes base instance
     * includes Kettle characteristics
     * @see Device#Device(Type, String, String, String, int)
     */
    public Kettle(String name, String manufacturerName, String article, int price, int power, String material, Color color, boolean hasWhistle) {
        super(Type.Kettle, name, manufacturerName, article, price);
        this.power=power;
        this.material=material;
        this.color=color;
        this.hasWhistle=hasWhistle;
    }
    /**
     * initializes extended instance
     * includes Kettle characteristics
     * @see Device#Device(Type, String, String, String, int, boolean)
     */
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
