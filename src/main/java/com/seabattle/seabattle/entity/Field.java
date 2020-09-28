package com.seabattle.seabattle.entity;


public class Field {

    private int id;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        if (id != field.id) return false;
        if (a != null ? !a.equals(field.a) : field.a != null) return false;
        if (b != null ? !b.equals(field.b) : field.b != null) return false;
        if (c != null ? !c.equals(field.c) : field.c != null) return false;
        if (d != null ? !d.equals(field.d) : field.d != null) return false;
        return e != null ? e.equals(field.e) : field.e == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        result = 31 * result + (e != null ? e.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public void putShip(int n) {
        switch (n){
            case 1: this.a = "ship";
            case 2: this.b = "ship";
            case 3: this.c = "ship";
            case 4: this.d = "ship";
            case 5: this.e = "ship";
            default: this.a = "ship";
        }
    }
}
