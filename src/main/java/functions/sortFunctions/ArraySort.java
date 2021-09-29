package functions.sortFunctions;

import entities.SomeArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ArraySort {
    private static Logger logger = LogManager.getLogger();
    public void bubbleSort(SomeArray array){
        boolean hasReplaced = true;
        int counter = 0;
        while(hasReplaced){
            hasReplaced = false;
            counter = 0;
            while(counter<array.getLength()-1){
                if(array.getNumber(counter)>array.getNumber(counter+1)){
                    float replacer = array.getNumber(counter);
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
            float replacer = array.getNumber(left);
            array.setNumber(left,array.getNumber(minInd));
            array.setNumber(minInd,replacer);
        }
    }
    public void insertionSort(SomeArray array){
        for (int left = 0; left < array.getLength(); left++) {
            float value = array.getNumber(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array.getNumber(i)) {
                    array.setNumber(i+1,array.getNumber(i));
                } else {
                    break;
                }
            }
            array.setNumber(i+1,value);
        }
    }
}
