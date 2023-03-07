package com.example.eatrice.common.engine.producer.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Select extends Basic {
    private static final long serialVersionUID = 1L;
    private final Logger logger = LoggerFactory.getLogger(Select.class);
    // 默认构造
    public Select() {
        super.records = new ArrayList<>();
    }


}
