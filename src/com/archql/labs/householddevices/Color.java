package com.archql.labs.householddevices;

public enum Color {
    None(0),
    Red(1),
    Green(2),
    Blue(3),
    Black(4);

    int id;
    Color(int i){id = i;}

    public static Color fromInt(int _id)
    {
        Color[] As = Color.values();
        for(int i = 0; i < As.length; i++)
        {
            if(As[i].id == _id)
                return As[i];
        }
        return Color.None;
    }
}
