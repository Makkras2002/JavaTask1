package com.makkras.survice.sort.impl;

import com.makkras.entity.SomeArray;
import com.makkras.survice.sort.CustomSort;

import java.util.Arrays;
import java.util.stream.DoubleStream;


public class ArraySort implements CustomSort {
    public void bubbleSort(SomeArray array){
        boolean hasReplaced = true;
        int counter = 0;
        while(hasReplaced){
            hasReplaced = false;
            counter = 0;
            while(counter<array.getLength()-1){
                if(array.getNumber(counter)>array.getNumber(counter+1)){
                    double replacer = array.getNumber(counter);
                    array.setNumber(counter,array.getNumber(counter+1));
                    array.setNumber(counter+1,replacer);
                    hasReplaced = true;
                }
                counter++;
            }
        }
    }
    public void selectionSort(SomeArray array){
        for (int left = 0; left < array.getLength(); left++) {
            int minInd = left;
            for (int i = left; i < array.getLength(); i++) {
                if (array.getNumber(i) < array.getNumber(minInd)) {
                    minInd = i;
                }
            }
            double replacer = array.getNumber(left);
            array.setNumber(left,array.getNumber(minInd));
            array.setNumber(minInd,replacer);
        }
    }
    public void insertionSort(SomeArray array){
        for (int left = 0; left < array.getLength(); left++) {
            double value = array.getNumber(left);
            int i = left - 1;
            while (i >= 0){
                if (value < array.getNumber(i)) {
                    array.setNumber(i+1,array.getNumber(i));
                } else {
                    break;
                }
                i--;
            }
            array.setNumber(i+1,value);
        }
    }
    public void arraySortWithStream(SomeArray array){
        double[] arrayCopy = array.getArrayCopy();
        DoubleStream doubleStream = Arrays.stream(arrayCopy);
        arrayCopy = doubleStream.sorted().toArray();
        int tempCounter =0;
        while (tempCounter<arrayCopy.length){
            array.setNumber(tempCounter,arrayCopy[tempCounter]);
            tempCounter++;
        }
    }
}
