package edu.entity;

import java.util.HashMap;

public class User {
    private int uid;
    private String username;
    private String password;
    private HashMap<Integer,HashMap<Integer,Goods>> goodsCar;

    public HashMap<Integer, HashMap<Integer, Goods>> getGoodsCar() {
        return goodsCar;
    }

    public void setGoodsCar(HashMap<Integer, HashMap<Integer, Goods>> goodsCar) {
        this.goodsCar = goodsCar;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }
}
