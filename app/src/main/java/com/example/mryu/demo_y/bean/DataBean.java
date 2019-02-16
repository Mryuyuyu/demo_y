package com.example.mryu.demo_y.bean;

public class DataBean {
    private int id;
    private String Data;
    private int Gangjuan;
    private float M1_up;
    private float M1_down;
    private float F1_up;
    private float F1_down;
    private float pressure;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public int getGangjuan() {
        return Gangjuan;
    }

    public void setGangjuan(int gangjuan) {
        Gangjuan = gangjuan;
    }

    public float getM1_up() {
        return M1_up;
    }

    public void setM1_up(float m1_up) {
        M1_up = m1_up;
    }

    public float getM1_down() {
        return M1_down;
    }

    public void setM1_down(float m1_down) {
        M1_down = m1_down;
    }

    public float getF1_up() {
        return F1_up;
    }

    public void setF1_up(float f1_up) {
        F1_up = f1_up;
    }

    public float getF1_down() {
        return F1_down;
    }

    public void setF1_down(float f1_down) {
        F1_down = f1_down;
    }


    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

}
