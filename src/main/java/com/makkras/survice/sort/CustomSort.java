package com.makkras.survice.sort;

import com.makkras.entity.impl.SomeArray;

public interface CustomSort {
    void bubbleSort(SomeArray array);
    void selectionSort(SomeArray array);
    void insertionSort(SomeArray array);
    void arraySortWithStream(SomeArray array);
}
