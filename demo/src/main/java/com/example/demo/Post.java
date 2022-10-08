package com.example.demo;

public class Post {
    int a;
    String name;
    String c;

    public Post(int a, String b, String c) {
        this.a = a;
        this.name = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return name;
    }

    public void setB(String b) {
        this.name = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
