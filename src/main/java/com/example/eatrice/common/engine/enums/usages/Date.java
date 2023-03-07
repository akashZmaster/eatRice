package com.example.eatrice.common.engine.enums.usages;

import com.example.eatrice.common.engine.interfaces.SQLEnums;

// 时间日期函数[适用于MYSQL]
public enum Date implements SQLEnums {

    NIL("", "默认:不使用时间日期函数"),
    NOW(" NOW() ", "返回当前系统的日期和时间"),
    CUR_DATE(" CURDATE() ", "只返回系统当前的日期，不包含时间"),
    CUR_TIME(" CURTIME() ", "只返回当前的时间，不包含日期"),
    YEAR(" YEAR() ", "获取日期和时间中的年"),
    MONTH(" MONTH() ", "获取日期和时间中的月"),
    DAY(" DAY() ", "获取日期和时间中的日"),
    HOUR(" HOUR() ", "获取日期和时间中的时"),
    MINUTE(" MINUTE() ", "获取日期和时间中的分"),
    SECOND(" SECOND() ", "获取日期和时间中的秒"),
    WEEK_OF_YEAR(" WEEKOFYEAR ", "获取当前时刻所属周数"),
    QUARTER(" QUARTER ", "获取当前时刻所属的季度"),
    STD(" STR_TO_DATE ", "将日期格式转换为字符串，转换成指定格式的日期"),
    DF(" DATE_FORMAT ", "将日期转换成日期字符串"),
    DATE_ADD(" DATE_ADD ", "向前、向后偏移日期和时间，正号为向后，负号为向前"),
    LAST_DAY(" LAST_DAY ", "提取某个月最后一天的日期"),
    DATE_DIFF(" DATEDIFF ", "时间差"),
    TIME_DIFF(" TIMESTAMPDIFF ", "计算两个时间返回的年/月/天数");

    private String formula;
    private String describe;

    Date(String formula, String describe) {
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

    public static Date getDate(String value) {
        if (null != value) {
            for (Date date : Date.values()) {
                if (value.equals(date.name()))
                    return date;
            }
        }
        return NIL;
    }
}
