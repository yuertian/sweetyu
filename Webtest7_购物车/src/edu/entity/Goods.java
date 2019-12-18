package edu.entity;

public class Goods {
    private int gid;
    private String gname;
    private double price;
    private int number;

    public Goods(int gid, String gname, double price, int number) {
        this.gid = gid;
        this.gname = gname;
        this.price = price;
        this.number = number;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Goods() {
    }
}


