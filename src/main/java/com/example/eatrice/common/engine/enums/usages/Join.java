package com.example.eatrice.common.engine.enums.usages;

import com.example.eatrice.common.engine.interfaces.SQLEnums;

// 连接方式枚举[适用于MYSQL]
public enum Join implements SQLEnums {

    NIL(" , ", "普通形式的全连接"),
    R(" RIGHT JOIN ", "右外连接"),
    L(" LEFT JOIN ", "左外连接"),
    NATURAL(" NATURAL JOIN", "内联:自然连接"),
    INNER(" INNER JOIN ", "内联:等值连接"),
    JOIN(" JOIN ", "交叉连接:笛卡尔积"),
    STRAIGHT(" STRAIGHT JOIN ", "内联:笛卡尔积（手动指定驱动表;on t1.a=t2.a[t1为驱动表]）");

    private String formula;
    private String describe;

    Join(String formula, String describe) {
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

    public static Join getJoin(String value) {
        if (null != value) {
            for (Join join : Join.values()) {
                if (value.equals(join.name()))
                    return join;
            }
        }
        return NIL;
    }

}
