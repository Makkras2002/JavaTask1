package entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SomeArray {
    private static Logger logger = LogManager.getLogger();
    private float[] array;
    public SomeArray(int size){
        array = new float[size];
    }
    public SomeArray(){
    }
    public void setNumber(int index, float number){
        array[index] = number;
    }
    public void showArray(){
        for(float o : array){
            logger.info(o);
        }
    }
    public float getNumber(int index){
        return array[index];
    }
    public int getLength(){
        return array.length;
    }
}
