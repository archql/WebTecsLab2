package com.archql.labs.householddevices;

public class RobotVacuum extends Device{

    public int timeToWork = 30;
    public int areaToWork = 300;
    public Color color = Color.Black;

    public RobotVacuum() { super(Type.RobotVacuum);}

    public RobotVacuum(String name, String manufacturerName, String article, int price) {
        super(Type.RobotVacuum, name, manufacturerName, article, price);
    }

    public RobotVacuum(String name, String manufacturerName, String article, int price, int timeToWork, int areaToWork, Color color) {
        super(Type.RobotVacuum, name, manufacturerName, article, price);

        this.timeToWork  = timeToWork ;
        this.areaToWork  = areaToWork ;
        this.color = color;
    }

    public RobotVacuum(String name, String manufacturerName, String article, int price, boolean isOnStall, int timeToWork, int areaToWork, Color color) {
        super(Type.RobotVacuum, name, manufacturerName, article, price, isOnStall);

        this.timeToWork  = timeToWork ;
        this.areaToWork  = areaToWork ;
        this.color = color;
    }

    @Override
    public String toString() {
        return "RobotVacuum{" +
                "timeToWork=" + timeToWork +
                ", areaToWork=" + areaToWork +
                ", color=" + color +
                "} " + super.toString();
    }
}
