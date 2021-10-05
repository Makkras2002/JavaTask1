package com.makkras.function.imp;

import com.makkras.entity.SomeArray;
import com.makkras.function.ArrayFunctionsInterface;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

public class ArrayFunctions implements ArrayFunctionsInterface {
    public String findMaxMinElements(SomeArray array){
        double min = array.getNumber(0);
        double max = array.getNumber(0);
        int counter =0;
        while (counter< array.getLength()){
            if(min > array.getNumber(counter)){
                min = array.getNumber(counter);
            }
            if(max < array.getNumber(counter)){
                max = array.getNumber(counter);
            }
            counter++;
        }
        String result = "MAX: "+ max +"; MIN: "+ min;
        return result;
    }
    public String findMaxMinElementsWithStream(SomeArray array){
        double[] arrayCopy = array.getArrayCopy();
        DoubleSummaryStatistics intStat = Arrays.stream(arrayCopy).collect(DoubleSummaryStatistics::new,
                DoubleSummaryStatistics::accept,
                DoubleSummaryStatistics::combine);
        double min = intStat.getMin();
        double max = intStat.getMax();
        String result = "MAX: "+ max +"; MIN: "+ min;
        return result;
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
    public void changeElementsByTaskWithStream(SomeArray array,double number){
        double[] arrayCopy = array.getArrayCopy();
        int counter = 0;
        while(counter< arrayCopy.length){
            if(arrayCopy[counter] <0){
                arrayCopy[counter]/=number;
            }
            counter++;
        }
        DoubleStream doubleStream = Arrays.stream(arrayCopy);
        double[] tempArray =doubleStream.toArray();
        counter = 0;
        while(counter< array.getLength()){
            if(array.getNumber(counter) <0){
                array.setNumber(counter,tempArray[counter]);
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
    public String countPositiveNegativeAmount(SomeArray array){
        float posAmount = 0;
        float negAmount = 0;
        int counter =0;
        while (counter< array.getLength()){
            if(array.getNumber(counter) < 0){
                negAmount++;
            }
            else if(array.getNumber(counter)> 0){
                posAmount++;
            }
            counter++;
        }
        String result = "POS amount:  "+ posAmount +"; NEG amount: "+ negAmount;
        return result;
    }
    public String countPositiveNegativeAmountWithStream(SomeArray array){
        double[] arrayCopy = array.getArrayCopy();
        DoubleStream doubleStream = Arrays.stream(arrayCopy);
        long counterOfNegatives = doubleStream.filter(n -> n< 0 ).count();
        long counterOfPositives = array.getLength() - counterOfNegatives;
        String result = "POS amount:  "+ counterOfPositives +"; NEG amount: "+ counterOfNegatives;
        return result;
    }
}
