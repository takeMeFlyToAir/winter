package com.winter.generator.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名:
 * 创建人: wdd
 * 创建时间: 2017/12/4
 */
public enum DataTypeEnum {

    CHAR("char","String","java.lang.String",false),
    VARCHAR("varchar","String","java.lang.String",false),
    NVARCHAR("nvarchar","String","java.lang.String",false),
    MEDIUMTEXT("mediumtext","String","java.lang.String",false),
    TINYTEXT("char","String","java.lang.String",false),
    TEXT("text","String","java.lang.String",false),
    LONGTEXT("longtext","String","java.lang.String",false),

    TINYINT("tinyint", "Integer", "java.lang.Integer", false),
    SMALLINT("smallint", "Integer", "java.lang.Integer", false),
    MEDIUMINT("mediumint", "Integer", "java.lang.Integer", false),
    INT("int", "Integer", "java.lang.Integer", false),
    INTEGER("integer", "Integer", "java.lang.Integer", false),
    BIGINT("bigint", "Long", "java.lang.Long", false),
    FLOAT("float", "Double", "java.lang.Double", false),
    DOUBLE("double", "Double", "java.lang.Double", false),
    DECIMAL("decimal", "BigDecimal", "java.math.BigDecimal", true),
    DATE("date", "Date", "java.util.Date", true),
    TIME("time", "Date", "java.util.Date", true),
    YEAR("year", "Date", "java.util.Date", true),
    DATETIME("datetime", "Date", "java.util.Date", true),
    TIMESTAMP("timestamp", "Timestamp", "java.sql.Timestamp", true);

//    BINARY("tinyint", "Integer", "java.lang.Integer", true),
//    VARBINARY("tinyint", "Integer", "java.lang.Integer", true);

    private final String name;              // 数据库
    private final String javaType;          // java类型
    private final String fullType;          //全类型
    private final boolean importFlag;         //是否需要导入

    private static Map<String, DataTypeEnum> map = new HashMap<String, DataTypeEnum>();

    static {
        for (DataTypeEnum o : DataTypeEnum.values()) {
            map.put(o.getName(), o);
        }
    }

    public static DataTypeEnum from(String name) {
        return map.get(name);
    }

    DataTypeEnum(String name, String javaType, String fullType, boolean importFlag) {
        this.name = name;
        this.javaType = javaType;
        this.fullType = fullType;
        this.importFlag = importFlag;
    }

    public String getName() {
        return name;
    }

    public String getJavaType() {
        return javaType;
    }

    public String getFullType() {
        return fullType;
    }

    public boolean isImportFlag() {
        return importFlag;
    }
}
