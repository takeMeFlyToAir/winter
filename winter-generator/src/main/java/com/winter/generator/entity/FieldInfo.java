package com.winter.generator.entity;

import com.winter.generator.enums.DataTypeEnum;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类名:
 * 创建人: wdd
 * 创建时间: 2017/12/4
 */
@Data
@ToString
public class FieldInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 表格主键
     */
    private Long tableId;
    /**
     * 字段名称
     */
    private String columnName;
    /**
     * 字段类型
     */
    private String columnType;
    /**
     * 长度
     */
    private String columnLength;

    /**
     * 是否为空
     */
    private String columnNull;
    /**
     * 备注
     */
    private String columnComment;
    /**
     * 默认值
     */
    private String columnDefault;
    /**
     * 表格主键
     */
    private String primaryFlag;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 数据类型
     */
    private DataTypeEnum dataTypeEnum;

    public DataTypeEnum getDataTypeEnum() {
        return DataTypeEnum.from(columnType);
    }

    public FieldInfo(String columnName, String columnType, String columnLength, String columnNull, String columnDefault, String columnComment) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.columnLength = columnLength;
        this.columnNull = columnNull;
        this.columnDefault = columnDefault;
        this.columnComment = columnComment;
    }
    public FieldInfo(){

    }

}
