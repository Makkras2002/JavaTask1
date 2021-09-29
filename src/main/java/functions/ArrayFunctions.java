package functions;

import entities.SomeArray;

public class ArrayFunctions {
    public String findMaxMinElements(SomeArray array){
        float min = array.getNumber(0);
        float max = array.getNumber(0);
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
    public void changeElementsByTask(SomeArray array){
        int counter = 0;
        while(counter< array.getLength()){
            if(array.getNumber(counter) <0){
                array.setNumber(counter,array.getNumber(counter)/2);
            }
            counter++;
        }
    }
    public float countAverage(SomeArray array){
        float result =0;
        int counter = 0;
        while(counter< array.getLength()){
            result+=array.getNumber(counter);
            counter++;
        }
        return result/array.getLength();
    }
    public float countElemSum(SomeArray array){
        float result =0;
        int counter = 0;
        while(counter< array.getLength()){
            result+=array.getNumber(counter);
            counter++;
        }
        return result;
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
}
