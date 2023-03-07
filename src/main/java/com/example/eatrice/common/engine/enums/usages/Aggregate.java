package com.example.eatrice.common.engine.enums.usages;

import com.example.eatrice.common.engine.interfaces.SQLEnums;

// 聚合计算函数[适用于MYSQL]
public enum Aggregate implements SQLEnums {

    NIL("", "默认:不使用聚合函数"),
    AVG(" AVG ", "平均值"),
    COUNT(" COUNT ", "总行数"),
    MAX(" MAX ", "最大值"),
    MIN(" MIN ", "最小值"),
    SUM(" SUM ", "总计（求和）"),
    DISTINCT(" DISTINCT ", "去重"),
    GROUP_CONCAT(" GROUP_CONCAT ","分组字段值拼接");

    private String formula;
    private String describe;

    Aggregate(String formula, String describe) {
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

    public static Aggregate getAggregate(String value) {
        if (null != value) {
            for (Aggregate aggregate : Aggregate.values()) {
                if (value.equals(aggregate.name()))
                    return aggregate;
            }
        }
        return NIL;
    }

}
