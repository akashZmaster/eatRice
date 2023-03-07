package com.example.eatrice.common.engine.enums.usages;

import com.example.eatrice.common.engine.interfaces.SQLEnums;

// 条件关联枚举[适用于MYSQL]
public enum Query implements SQLEnums {

    AND(" AND ", "和"),
    OR(" OR ", "或"),
    AND_START(" AND_START ", "多级组合:和 *开始标记 [ 示例: ( and xxx = '1' ]"),
    OR_START(" OR_START ", "多级组合:或 *开始标记 [ 示例: ( or xxx = '1' ]"),
    AND_END(" AND_END ", "多级组合:和 *结束标记 [ 示例:  and xxx = '1') ]"),
    OR_END(" OR_END ", "多级组合:或 *结束标记 [ 示例:  or xxx = '1') ]");

    private String formula;
    private String describe;

    Query(String formula, String describe) {
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

    public static Query getQuery(String value) {
        if (null != value) {
            for (Query query : Query.values()) {
                if (value.equals(query.name()))
                    return query;
            }
        }
        return AND;
    }
}
