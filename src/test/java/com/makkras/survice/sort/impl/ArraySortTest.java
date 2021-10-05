package com.makkras.survice.sort.impl;

import com.makkras.entity.SomeArray;
import com.makkras.survice.sort.CustomSort;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySortTest {
    private SomeArray array;
    private CustomSort sort;
    @BeforeMethod
    public void setUp() {
        array = new SomeArray(4);
        array.setNumber(0,-10);
        array.setNumber(1,5);
        array.setNumber(2,12);
        array.setNumber(3,-8);
        sort = new ArraySort();
    }
    @Test
    public void testInsertSort(){
        sort.insertionSort(array);
        assertEquals(array.toString(),"SomeArray{array=[-10.0, -8.0, 5.0, 12.0]}");
    }
}