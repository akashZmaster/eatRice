package com.example.eatrice.common.engine.enums.usages;

import com.example.eatrice.common.engine.interfaces.SQLEnums;

// 字符函数[适用于MYSQL]
public enum Character implements SQLEnums {

    NIL("", "默认:不使用字符函数"),
    LEN(" LENGTH ", "获取字节数"),
    CONCAT(" CONCAT ", "字符串拼接"),
    UP(" UPPER ", "大写转换"),
    LOW(" LOWER", "小写转换"),
    SUB_STR(" SUBSTR ", " 截取字符串"),
    IN_STR(" INSTR ", "查找指定子串在字符串中第一次出现的位置"),
    TRIM(" TRIM ", "去空格"),
    L_PAD(" LPAD ", "左填充"),
    R_PAD(" RPAD", "右填充"),
    REPLACE(" REPLACE ", "替换字符串");

    private String formula;
    private String describe;

    Character(String formula, String describe) {
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

    public static Character getCharacter(String value) {
        if (null != value) {
            for (Character character : Character.values()) {
                if (value.equals(character.name()))
                    return character;
            }
        }
        return NIL;
    }

}
