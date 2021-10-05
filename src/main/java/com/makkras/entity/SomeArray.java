package com.makkras.entity;

import java.util.Arrays;

public class SomeArray {
    private double[] array;
    public SomeArray(int size){
        array = new double[size];
    }
    public SomeArray(){
    }
    public void setNumber(int index, double number){
        array[index] = number;
    }
    public double getNumber(int index){
        return array[index];
    }
    public int getLength(){
        return array.length;
    }
    public double[] getArrayCopy(){
        return array.clone();
    }
    @Override
    public String toString() {
        return "SomeArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeArray someArray = (SomeArray) o;
        return Arrays.equals(array, someArray.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
