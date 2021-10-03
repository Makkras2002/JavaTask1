package com.makkras.functions;

import com.makkras.entities.SomeArray;

public interface ArrayFunctionsInterface {
    String findMaxMinElements(SomeArray array);
    void changeElementsByTask(SomeArray array,double number);
    double countAverage(SomeArray array);
    double countElemSum(SomeArray array);
    String countPositiveNegativeAmount(SomeArray array);
    String findMaxMinElementsWithStream(SomeArray array);
    void changeElementsByTaskWithStream(SomeArray array,double number);
    double countAverageWithStream(SomeArray array);
    double countElemSumWithStream(SomeArray array);
    String countPositiveNegativeAmountWithStream(SomeArray array);
}
