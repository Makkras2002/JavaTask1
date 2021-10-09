package com.makkras.survice.impl;

import com.makkras.entity.impl.SomeArray;
import com.makkras.survice.ArrayMath;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class ArrayMathFunc implements ArrayMath {
    public double findMaxElement(SomeArray array){
        double max = array.getNumber(0);
        int counter =0;
        while (counter< array.getLength()){
            if(max < array.getNumber(counter)){
                max = array.getNumber(counter);
            }
            counter++;
        }
        return max;
    }
    public double findMinElement(SomeArray array){
        double min = array.getNumber(0);
        int counter =0;
        while (counter< array.getLength()){
            if(min > array.getNumber(counter)){
                min = array.getNumber(counter);
            }
            counter++;
        }
        return min;
    }
    public OptionalDouble findMaxElementWithStream(SomeArray array){
        double[] arrayCopy = array.getArrayCopy();
        DoubleStream doubleStream = Arrays.stream(arrayCopy);
        OptionalDouble max = doubleStream.max();
        return max;
    }
    public OptionalDouble findMinElementWithStream(SomeArray array){
        double[] arrayCopy = array.getArrayCopy();
        DoubleStream doubleStream = Arrays.stream(arrayCopy);
        OptionalDouble min = doubleStream.min();
        return min;
    }
    public void changeElementsByTask(SomeArray array,double number){
        int counter = 0;
        while(counter< array.getLength()){
            if(array.getNumber(counter) <0){
                array.setNumber(counter,array.getNumber(counter)/number);
            }
            counter++;
        }
    }
    public double countAverage(SomeArray array){
        float result =0;
        int counter = 0;
        while(counter< array.getLength()){
            result+=array.getNumber(counter);
            counter++;
        }
        return result/array.getLength();
    }
    public double countAverageWithStream(SomeArray array){
        double[] arrayCopy = array.getArrayCopy();
        DoubleSummaryStatistics intStat = Arrays.stream(arrayCopy).collect(DoubleSummaryStatistics::new,
                DoubleSummaryStatistics::accept,
                DoubleSummaryStatistics::combine);
        return intStat.getAverage();
    }
    public double countElemSum(SomeArray array){
        float result =0;
        int counter = 0;
        while(counter< array.getLength()){
            result+=array.getNumber(counter);
            counter++;
        }
        return result;
    }
    public double countElemSumWithStream(SomeArray array){
        double[] arrayCopy = array.getArrayCopy();
        DoubleSummaryStatistics intStat = Arrays.stream(arrayCopy).collect(DoubleSummaryStatistics::new,
                DoubleSummaryStatistics::accept,
                DoubleSummaryStatistics::combine);
        return intStat.getSum();
    }
    public int countPositiveAmount(SomeArray array){
        int posAmount = 0;
        int counter =0;
        while (counter< array.getLength()){
            if(array.getNumber(counter)> 0){
                posAmount++;
            }
            counter++;
        }
        return posAmount;
    }
    public int countNegativeAmount(SomeArray array){
        int negAmount = 0;
        int counter =0;
        while (counter< array.getLength()){
            if(array.getNumber(counter) < 0){
                negAmount++;
            }
            counter++;
        }
        return negAmount;
    }
    public long countPositiveAmountWithStream(SomeArray array){
        double[] arrayCopy = array.getArrayCopy();
        DoubleStream doubleStream = Arrays.stream(arrayCopy);
        long counterOfPositives = doubleStream.filter(n -> n> 0 ).count();
        return counterOfPositives;
    }
    public long countNegativeAmountWithStream(SomeArray array){
        double[] arrayCopy = array.getArrayCopy();
        DoubleStream doubleStream = Arrays.stream(arrayCopy);
        long counterOfNegatives = doubleStream.filter(n -> n< 0 ).count();
        return counterOfNegatives;
    }
}
