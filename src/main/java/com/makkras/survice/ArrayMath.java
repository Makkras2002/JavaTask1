package com.makkras.survice;

import com.makkras.entity.impl.SomeArray;

import java.util.OptionalDouble;

public interface ArrayMath{
    double findMaxElement(SomeArray array);
    double findMinElement(SomeArray array);
    OptionalDouble findMaxElementWithStream(SomeArray array);
    OptionalDouble findMinElementWithStream(SomeArray array);
    void changeElementsByTask(SomeArray array,double number);
    double countAverage(SomeArray array);
    double countElemSum(SomeArray array);
    int countPositiveAmount(SomeArray array);
    int countNegativeAmount(SomeArray array);
    double countAverageWithStream(SomeArray array);
    double countElemSumWithStream(SomeArray array);
    long countPositiveAmountWithStream(SomeArray array);
    long countNegativeAmountWithStream(SomeArray array);
}
