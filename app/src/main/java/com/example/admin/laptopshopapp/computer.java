package com.example.admin.laptopshopapp;

import org.json.JSONObject;

public class computer {

    private String brand, naziv, tip;
    private boolean dostava;
    private int id, cena;

    public computer() {

    }

    public computer(int id, String brand, String naziv, String tip, boolean dostava, int cena) {
        this.id = id;
        this.brand = brand;
        this.naziv = naziv;
        this.tip = tip;
        this.dostava = dostava;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isDostava() {
        return dostava;
    }

    public void setDostava(boolean dostava) {
        this.dostava = dostava;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }


    public static computer parseJSON(JSONObject object) {
        computer computer = new computer();

        try {
            if (object.has("id")) {
                computer.setId(object.getInt("id"));
            }
            if (object.has("brand")) {
                computer.setBrand(object.getString("brand"));
            }
            if (object.has("naziv")) {
                computer.setNaziv(object.getString("naziv"));
            }
            if (object.has("tip")) {
                computer.setTip(object.getString("tip"));
            }
            if (object.has("dostava")) {
                computer.setDostava(object.getBoolean("dostava"));
            }
            if (object.has("cena")) {
                computer.setCena(object.getInt("cena"));
            }

        } catch (Exception e) {

        }

        return computer;
    }

}