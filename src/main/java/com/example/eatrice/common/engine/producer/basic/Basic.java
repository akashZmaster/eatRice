package com.example.eatrice.common.engine.producer.basic;

import com.example.eatrice.common.engine.enums.KeyMarks;
import com.example.eatrice.common.engine.enums.usages.Condition;
import com.example.eatrice.common.entity.BaseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

public class Basic implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Logger logger = LoggerFactory.getLogger(Basic.class);

    // 参数记录;
    BaseData data;
    // 引擎行为记录;
    List<BaseData> keyMarks;
    // 是否分组标记;
    boolean group = false;
    // 是否执行标记;
    boolean execute = false;

    /**
     * @param mark
     * @param keys
     * @param values
     * @return
     */
    public BaseData generateKeyMark(KeyMarks mark, String[] keys, Object... values) {
        BaseData markData = new BaseData();
        markData.put("keyMark", KeyMarks.INIT);
        return markData.simplePut(keys, values);
    }

    /**
     * 生成SQL
     *
     * @return
     */
    public String generateSQL() {
        StringBuffer sb = new StringBuffer();
        for (BaseData keyMark : keyMarks) {
            sb.append(parsing(keyMark));
        }
        return sb.toString();
    }

    private String parsing(BaseData data) {
        KeyMarks keyMark = (KeyMarks) data.get("keyMark");
        StringBuffer sb = new StringBuffer(" SELECT * FROM ");
        if (KeyMarks.INIT.equals(keyMark)) {
            if (data.getBoolean("useCustom")) {
                sb.setLength(0);
                sb.append(data.get("customSQL"));
            } else {
                if (null == data.get("useEngine")) {
                    sb.append("`").append(data.get("tableName")).append("` AS `").append(data.get("alias")).append("`");
                } else {
                    sb.append(" ( ").append(data.get("childSql")).append(" ) AS `").append(data.get("alias")).append("`");
                }
            }
        }
        return sb.toString();
    }

}
