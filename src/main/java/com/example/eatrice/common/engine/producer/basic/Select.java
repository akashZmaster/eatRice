package com.example.eatrice.common.engine.producer.basic;

import cn.hutool.core.util.StrUtil;
import com.example.eatrice.common.engine.enums.KeyMarks;

import java.util.ArrayList;

public class Select extends Basic {

    public Select() {
        super.keyMarks = new ArrayList<>();
    }

    /**
     * [查询]自定义模式
     * -> new Select("select * from bs_table")
     *
     * @param customSQL 自定义模式
     */
    public Select(String customSQL) {
        super.keyMarks = new ArrayList<>();
        super.keyMarks.add(
                super.generateKeyMark(
                        KeyMarks.INIT,
                        new String[]{"useCustom", "customSQL"},
                        true,
                        customSQL
                )
        );
    }

    /**
     * [查询]简单模式
     * TODO 指定主表表名 + 别名
     * -> new Select("bs_table", "table")
     *
     * @param tableName 主表表名
     * @param alias     主表别名 [别名为空时,系统将默认使用主表表名为别名]
     */
    public Select(String tableName, String alias) {
        super.keyMarks = new ArrayList<>();
        super.keyMarks.add(
                super.generateKeyMark(
                        KeyMarks.INIT,
                        new String[]{"tableName", "alias"},
                        tableName,
                        (null == alias || "".equals(alias.trim())) ? tableName : alias)
        );
    }

    /**
     * [查询]嵌套子查询:引擎模式
     *
     * @param childSQL 子查询对象
     * @param alias    别名 [在使用嵌套子查询:引擎模式时,'主'表别名为必填项!]
     */
    public Select(Select childSQL, String alias) {
        super.keyMarks = new ArrayList<>();
        if (!StrUtil.isEmptyIfStr(alias)) {
            super.keyMarks.add(
                    super.generateKeyMark(
                            KeyMarks.INIT,
                            new String[]{"useEngine", "childSql", "alias"},
                            true,
                            childSQL.generateSQL(),
                            alias)
            );
        }
    }

    /**
     * [查询]嵌套子查询模式
     *
     * @param child    是否手动指定SQL
     * @param childSQL 手动SQL
     * @param alias    别名 [在使用嵌套子查询:引擎模式时,'主'表别名为必填项!]
     */
    public Select(boolean child, String childSQL, String alias) {
        super.keyMarks = new ArrayList<>();
        if (child) {
            if (!StrUtil.isEmptyIfStr(alias)) {
                super.keyMarks.add(
                        super.generateKeyMark(
                                KeyMarks.INIT,
                                new String[]{"useEngine", "childSql", "alias"},
                                false,
                                childSQL,
                                alias)
                );
            }
        }
    }




}
