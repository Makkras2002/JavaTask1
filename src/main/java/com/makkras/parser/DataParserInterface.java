package com.makkras.parser;

import com.makkras.entity.SomeArray;
import com.makkras.exception.FileInteractionException;

import java.util.List;

public interface DataParserInterface {
    SomeArray extractToArray(List<String> list) throws FileInteractionException;
}
