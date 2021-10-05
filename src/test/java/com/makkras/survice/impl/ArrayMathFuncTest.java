package com.makkras.survice.impl;

import com.makkras.entity.SomeArray;
import com.makkras.survice.ArrayMath;
import com.makkras.survice.sort.CustomSort;
import com.makkras.survice.sort.impl.ArraySort;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.OptionalDouble;

import static org.testng.Assert.*;

public class ArrayMathFuncTest {
    private SomeArray array;
    private ArrayMath math;

    @BeforeMethod
    public void setUp() {
        array = new SomeArray(4);
        array.setNumber(0,-10);
        array.setNumber(1,5);
        array.setNumber(2,12);
        array.setNumber(3,-8);
        math = new ArrayMathFunc();
    }
    @Test
    public void testSumFuncCorrectness(){
        assertEquals(math.countElemSum(array),-1.0);
    }
    @Test
    public void testMaxElemFuncCorrectness(){
        assertEquals(math.findMaxElementWithStream(array), OptionalDouble.of(12));
    }
    @Test
    public void testMinElemFuncCorrectness(){
        assertEquals(math.findMinElement(array), -10);
    }
}