package com.archql.labs;

import com.archql.labs.householddevices.Device;
import com.archql.labs.householddevices.IDeviceFilter;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

/**
 * class that holds hashmap of all devices
 * property <b>catalogue</b> is a hashmap with all devices
 * property <b>dataFilePath</b> path to a xml file where hashmap is stored
 * @autor archql
 * @version 1.0
 */
public class Catalogue implements IDatabase {

    /** property <b>catalogue</b> is a hashmap with all devices */
    private HashMap<Device, DBRecord> catalogue;

    /** property <b>dataFilePath</b> path to a xml file where hashmap is stored */
    private final String dataFilePath;
    /**
     * create new catalogue
     * @param filename - file to which catalogue is saved
     */
    Catalogue(String filename)
    {
        this.dataFilePath = filename;

        catalogue = new HashMap<>();
    }

    @Override
    public boolean add(Device d) {
        if (catalogue.containsKey(d))
            return false;
        catalogue.put(d, new DBRecord());
        return true;
    }

    @Override
    public boolean add(Device d, int quantity) {
        if (catalogue.containsKey(d)) {
            catalogue.get(d).add(quantity);
            return true;
        }
        catalogue.put(d, new DBRecord(quantity));
        return true;
    }

    @Override
    public boolean subtract(Device d, int quantity) {
        if (catalogue.containsKey(d)) {
            return catalogue.get(d).sub(quantity) > 0;
        }
        return false;
    }

    @Override
    public DBRecord get(Device d) {
        return catalogue.get(d);
    }

    @Override
    public void generateReport() {

    }

    @Override
    public List<Device> select(IDeviceFilter f) {
        ArrayList<Device> filtered = new ArrayList<>();
        catalogue.forEach((key, value) -> {
            if (f.check(key))
                filtered.add(key);
        });
        return filtered;
    }

    /**
     * loads DB from dataFilePath file
     */
    private void load()
    {
        try
        {
            XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(dataFilePath)));
            catalogue = (HashMap<Device, DBRecord>) d.readObject();
            d.close();
        }
        catch (Exception e)
        {
            System.err.println("ERR: loading: " + e.getMessage());
        }
    }

    /**
     * saves DB to dataFilePath file
     */
    private void save()
    {
        try
        {
            XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(dataFilePath)));
            e.writeObject(catalogue);
            e.close();
        }
        catch (Exception e)
        {
            System.err.println("ERR: flushing: " + e.getMessage());
        }
    }
}
