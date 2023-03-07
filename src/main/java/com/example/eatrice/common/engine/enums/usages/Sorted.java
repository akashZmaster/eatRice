package com.example.eatrice.common.engine.enums.usages;

import com.example.eatrice.common.engine.interfaces.SQLEnums;

// 排序枚举[适用于MYSQL]
public enum Sorted implements SQLEnums {

    ASC(" ASC ", "正序排序"),
    DESC(" DESC ", "倒序排序"),
    UTF_ASC(" UTF_ASC ", "中文正序"),
    UTF_DESC(" UTF_DESC", "中文倒序");

    private String formula;
    private String describe;

    Sorted(String formula, String describe) {
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

    public static Sorted getSorted(String value) {
        if (null != value) {
            for (Sorted sorted : Sorted.values()) {
                if (value.equals(sorted.name()))
                    return sorted;
            }
        }
        return UTF_DESC;
    }
}
