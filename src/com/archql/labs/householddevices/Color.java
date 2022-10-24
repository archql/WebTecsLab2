package com.archql.labs.householddevices;

/**
 * describes a color of device
 */
public enum Color {
    None(0),
    Red(1),
    Green(2),
    Blue(3),
    Black(4);

    /**
     * id of color
     */
    int id;
    /**
     * sets color by its id
     */
    Color(int i){id = i;}

    /**
     * returns Color by id
     */
    public static Color fromInt(int _id)
    {
        Color[] As = Color.values();
        for (Color a : As) {
            if (a.id == _id)
                return a;
        }
        return Color.None;
    }
}
