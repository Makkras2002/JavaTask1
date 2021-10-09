package com.makkras.entity;

public interface CustomArray {
    public void setNumber(int index, double number);
    public double getNumber(int index);
    public int getLength();
    public double[] getArrayCopy();
}
