package com.archql.labs.householddevices;

/**
 * device filter
 * @autor archql
 * @version 1.0
 */
public interface IDeviceFilter {
    /**
     * returns true whether d fits logics provided in the method
     * @param d - device to check
     * @return - `true` if it fits logics
     */
    boolean check(Device d);
}
