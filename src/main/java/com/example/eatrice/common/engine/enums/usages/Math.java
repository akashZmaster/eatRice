package com.example.eatrice.common.engine.enums.usages;

import com.example.eatrice.common.engine.interfaces.SQLEnums;


// 数学函数[适用于MYSQL]
public enum Math implements SQLEnums {

    NIL("", "默认:不使用数学函数"),
    ROUND(" ROUND ", "四舍五入,保留X位小数"),
    CEIL(" CEIL ", "向上取整，返回>=该参数的最小整数"),
    FLOOR(" FLOOR ", "向下取整，返回<=该参数的最大整数"),
    TRUNCATE(" TRUNCATE ", "截断小数点后X位"),
    MOD(" MOD ", "取余运算"),
    POW(" POW ", "指数运算");

    private String formula;
    private String describe;

    Math(String formula, String describe) {
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

    public static Math getMath(String value) {
        if (null != value) {
            for (Math math : Math.values()) {
                if (value.equals(math.name()))
                    return math;
            }
        }
        return NIL;
    }

}
