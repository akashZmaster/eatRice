package com.example.eatrice.common.engine.enums;

import com.example.eatrice.common.engine.interfaces.SQLEnums;

// 流程执行标记[引擎使用]
public enum KeyMarks implements SQLEnums {

    INIT("init","初始化标记");

    private String formula;
    private String describe;

    KeyMarks(String formula, String describe) {
        this.formula = formula;
        this.describe = describe;
    }

    @Override
    public String getFormula() {
        return formula;
    }

    @Override
    public String getDescribe() {
        return describe;
    }

}
