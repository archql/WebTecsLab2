package com.archql.labs.householddevices;

import java.util.Objects;

/**
 * class that holds general information of an abstract device
 * property <b>name</b> refers to a product name
 * property <b>price</b> refers to its cost
 * property <b>manufacturerName</b> refers to a company name that produced the item
 * property <b>article</b> refers to a unique code assigned to the item by manufacturer
 * property <b>isOnStall</b> reflects if object is currently can be bought
 * property <b>price</b> refers to its type
 * @version 1.0
 */
public class Device {

    /**  property <b>name</b> refers to a product name */
    public String name;
    /** property <b>manufacturerName</b> refers to a company name that produced the item */
    public String manufacturerName;
    /**property <b>article</b> refers to a unique code assigned to the item by manufacturer */
    public String article;

    /** property <b>isOnStall</b> reflects if object is currently can be bought */
    public boolean isOnStall = false;

    /** property <b>price</b> refers to its cost */
    public int price;

    /** property <b>price</b> refers to its type */
    public final Type type;

    /**
     * new divece
     * @see Device#Device(Type, String, String, String, int, boolean)
     */
    public Device(Type type) { this.type = type; }
    /**
     * new divece
     * @param name - a product name
     * @param manufacturerName - company name that produced the item
     * @param article - unique code assigned to the item by manufacturer
     * @param price - cost of the single item
     * @see Device#Device(Type, String, String, String, int, boolean)
     */
    public Device(Type type, String name, String manufacturerName, String article, int price)
    {
        this.name = name;
        this.manufacturerName = manufacturerName;
        this.article = article;
        this.price = price;
        this.type = type;
    }

    /**
     * new divece
     * @param name - a product name
     * @param manufacturerName - company name that produced the item
     * @param article - unique code assigned to the item by manufacturer
     * @param price - cost of the single item
     * @param isOnStall - if object is currently can be bought
     * @see Device#Device(Type, String, String, String, int)
     */
    public Device(Type type, String name, String manufacturerName, String article, int price, boolean isOnStall)
    {
        this(type, name, manufacturerName, article, price);
        this.isOnStall = isOnStall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return isOnStall == device.isOnStall && price == device.price && Objects.equals(name, device.name) && Objects.equals(manufacturerName, device.manufacturerName) && Objects.equals(article, device.article) && type == device.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, manufacturerName, article, isOnStall, price, type);
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", article='" + article + '\'' +
                ", isOnStall=" + isOnStall +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}

