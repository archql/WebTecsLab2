package com.archql.labs;

import com.archql.labs.householddevices.Device;
import com.archql.labs.householddevices.IDeviceFilter;

import java.util.List;

/**
 * class that holds all basic functions of a DB
 * @autor archql
 * @version 1.0
 */
public interface IDatabase {
    /**
     * adds device d to a DB with quantity 0 and status Created
     * @param d - device to add
     * @return - `true` if there is no duplicate
     */
    boolean add(Device d);
    /**
     * adds device d to a DB with quantity and status QuantityAdded.
     * if there is duplicate then adds quantity to existing device instead
     * @param d - device to add
     * @param quantity - quantity to add
     * @return - `true`
     */
    boolean add(Device d, int quantity);

    /**
     * subtracts quantity from a device d record
     * @param d - device from to subtract
     * @param quantity - quantity to subtract
     * @return - `true` if DB has enough quantity of device
     */
    boolean subtract(Device d, int quantity);

    /**
     * get DB record for a device d
     * @param d - device to search
     * @return DBRecord or null if there is no such device
     */
    DBRecord get(Device d);

    /**
     *
     */
    void generateReport();

    /**
     * selects Devices from DB that are accepted by the given filter
     * @param f - filter of IDeviceFilter. @see IDeviceFilter
     * @return list of devices or null if there are no devices to fit in requirements
     */
    List<Device> select(IDeviceFilter f);
}
