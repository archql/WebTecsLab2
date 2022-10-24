package com.archql.labs;

import com.archql.labs.householddevices.*;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.Callable;

public class Main {

    private static IDatabase db;
    private final static Scanner sc = new Scanner(System.in);
    private static Map<Class, Callable<Object>> doByClass;

    private static void init()
    {
        db = (IDatabase) new Catalogue("data.xml");
        db.load();

        doByClass = new HashMap<>();
        doByClass.put(Integer.TYPE, () -> { int a = sc.nextInt(); sc.nextLine(); return a; });
        doByClass.put(String.class, sc::nextLine);
        doByClass.put(Boolean.TYPE, () -> { boolean a = sc.nextBoolean(); sc.nextLine(); return a; });
        doByClass.put(Color.class, () -> { Color a = Color.fromInt(sc.nextInt()); sc.nextLine(); return a;} );
    }

    public static void main(String[] args) {
        init();

        boolean working = true;

        while (working) {
            System.out.println();
            System.out.println("Type number and press Enter:");
            System.out.println("1 for adding device");
            System.out.println("2 for showing all devices");
            System.out.println("3 for searching all kettles");
            System.out.println("4 for searching the cheapest");
            System.out.println("5 for clear all devices");
            System.out.println("6 for exit");
            System.out.println();

            System.out.print("> ");

            int res = sc.nextInt();

            switch (res) {
                case 1: addItem(); break;
                case 2: showItems(); break;
                case 3: searchType(); break;
                case 4: searchCheapest(); break;
                case 5: db.clear(); break;
                case 6: working = false; db.save(); break;
                default : {
                    System.out.println("Input out of bounds");
                    System.out.println();
                }
            }
        }
    }

    private static void addItem() {
        System.out.println("Select item type: ");
        System.out.println("0 for Fridge");
        System.out.println("1 for Kettle");
        System.out.println("2 for RobotVacuum");

        Device item = null;

        int res = sc.nextInt();
        switch (res){
            case 0:
                Fridge fridge = new Fridge();
                for (Field f: Fridge.class.getFields()) {
                    readField(fridge, f);
                }
                item = fridge;
                break;
            case 1:
                Kettle kettle = new Kettle();
                for (Field f: Kettle.class.getFields()) {
                    readField(kettle, f);
                }
                item = kettle;
                break;
            case 2:
                RobotVacuum robotVacuum = new RobotVacuum();
                for (Field f: RobotVacuum.class.getFields()) {
                    readField(robotVacuum, f);
                }
                item = robotVacuum;
                break;
            default:
                System.out.println("Failed to read item type");
        }

        if (item == null)
            return;
        System.out.println("item " + item);
        db.add(item);
    }

    private static void readField(Object o, Field f) {
        if (f.getName().equals("type"))
            return;
        System.out.print("input (" + f.getType().getName() + ") " + f.getName() + ": ");
        f.setAccessible(true);
        if(doByClass.containsKey(f.getType())) {
            try {
                f.set(o, doByClass.get(f.getType()).call());
            } catch (Exception e) {
                e.printStackTrace();
                sc.nextLine();
            }
        }

        f.setAccessible(false);
    }

    private static void searchCheapest() {
        List<Device> dl = db.select(d -> true); // just return all items // ineffective
        int cheapestId = 0, cheapestPrice = Integer.MAX_VALUE, id = -1;
        for (Device d: dl) {
            id++;
            if (d.price < cheapestPrice) {
                cheapestPrice = d.price;
                cheapestId = id;
            }
        }
        if (id >= 0)
            System.out.println(dl.get(cheapestId));
        else
            System.out.println("Failed to find any");
    }

    private static void showItems()
    {
        db.select(d -> {
            System.out.println(d);
            return false;
        });
    }
    private static void searchType()
    {
        db.select(d -> {
            if (d.type == Type.Kettle)
                System.out.println(d);
            return false;
        });
        // or
//        List<Device> dl = db.select(d -> (d.type == Type.Kettle));
//        for (Device d: dl)
//            System.out.println(d);
    }
}
