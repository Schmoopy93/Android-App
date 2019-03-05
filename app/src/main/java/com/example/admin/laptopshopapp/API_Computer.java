package com.example.admin.laptopshopapp;

import java.util.ArrayList;


public class API_Computer {

    public static ArrayList<computer> getComputers(){
        ArrayList<computer> computers = new ArrayList<>();
        computers.add(new computer(1,"Samsung","M40", "Laptop", true, 250));
        computers.add(new computer(2,"Apple","Macbook", "Laptop", false, 500));
        computers.add(new computer(3,"Samsung","XPS", "Desktop", true, 300));
        computers.add(new computer(4,"HP","Pavilion", "Laptop", true, 750));
        computers.add(new computer(5,"Samsung","Tabloid", "Tablet", false, 800));
        return computers;
    }
}
