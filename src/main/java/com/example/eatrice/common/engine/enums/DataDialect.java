package com.example.eatrice.common.engine.enums;

// 数据源方言枚举
public enum DataDialect {

    MYSQL8("MYSQL", "8.0.0", "MYSQL");

    private String name;
    private String version;
    private String describe;

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDescribe() {
        return describe;
    }

    DataDialect(String name, String version, String describe) {
        this.name = name;
        this.version = version;
        this.describe = describe;
    }

}
