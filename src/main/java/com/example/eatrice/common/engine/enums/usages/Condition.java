package com.example.eatrice.common.engine.enums.usages;

import com.example.eatrice.common.engine.interfaces.SQLEnums;

// 条件枚举[适用于:MYSQL]
public enum Condition implements SQLEnums {

    EQ(" = ", "等于"),
    LIKE(" LIKE ", "模糊匹配"),
    N_LIKE(" NOT LIKE ", "反向模糊匹配"),
    B_LIKE(" LIKE BINARY ", "模糊匹配:区分大小写"),
    ESCAPE(" ESCAPE ", "通配符转义"),
    GT(" > ", "大于"),
    GT_EQ(" >= ", "大于等于"),
    LT(" < ", "小于"),
    LT_EQ(" <= ", "大于等于"),
    N_EQ(" <> ", "不等于"),
    IN(" IN ", "包含"),
    N_IN(" NOT IN", "不包含"),
    NULL(" IS NULL ", "空值验证"),
    N_NULL(" IS NOT NULL", "非空验证"),
    BETWEEN(" BETWEEN ", "区间值");


    private String formula;
    private String describe;

    Condition(String formula, String describe) {
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

    public static Condition getCondition(String value) {
        if (null != value) {
            for (Condition condition : Condition.values()) {
                if (value.equals(condition.name()))
                    return condition;
            }
        }
        return EQ;
    }
}
