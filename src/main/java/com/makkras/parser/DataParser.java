package com.makkras.parser;

import com.makkras.entity.impl.SomeArray;

import java.util.List;

public interface DataParser {
    SomeArray extractToArray(List<String> list);
}
