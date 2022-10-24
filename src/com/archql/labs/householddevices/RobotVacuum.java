package com.archql.labs.householddevices;

/**
 * class RobotVacuum that holds general information of a RobotVacuum device
 * property <b>timeToWork</b> refers to time in h which robot can work autonomously
 * property <b>areaToWork</b> refers to area that it can cover in m^2
 * property <b>color</b> refers to color
 * @see Device to learn about base class
 * @version 1.0
 */
public class RobotVacuum extends Device{

    /** property <b>timeToWork</b> refers to time in h which robot can work autonomously */
    public int timeToWork = 30;
    /** property <b>areaToWork</b> refers to area that it can cover in m^2 */
    public int areaToWork = 300;
    /** property <b>color</b> refers to color */
    public Color color = Color.Black;

    /**
     * creates an empty instance of RobotVacuum only type set
     * @see Device#Device(Type)
     */
    public RobotVacuum() { super(Type.RobotVacuum);}

    /**
     * initializes base instance
     * @see Device#Device(Type, String, String, String, int)
     */
    public RobotVacuum(String name, String manufacturerName, String article, int price) {
        super(Type.RobotVacuum, name, manufacturerName, article, price);
    }

    /**
     * initializes base instance
     * includes RobotVacuum characteristics
     * @see Device#Device(Type, String, String, String, int)
     */
    public RobotVacuum(String name, String manufacturerName, String article, int price, int timeToWork, int areaToWork, Color color) {
        super(Type.RobotVacuum, name, manufacturerName, article, price);

        this.timeToWork  = timeToWork ;
        this.areaToWork  = areaToWork ;
        this.color = color;
    }
    /**
     * initializes extended instance
     * includes RobotVacuum characteristics
     * @see Device#Device(Type, String, String, String, int, boolean)
     */
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
