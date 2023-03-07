package com.example.eatrice.common.engine.producer.basic;

import com.example.eatrice.common.entity.BaseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

public class Basic implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Logger logger = LoggerFactory.getLogger(Basic.class);

    // 参数记录;
    BaseData data;
    // 引擎行为记录;
    List<BaseData> records;
    // 是否分组标记;
    boolean group = false;
    // 是否执行标记;
    boolean execute = false;


}
