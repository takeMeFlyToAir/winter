
package com.winter.generator.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class PageConfig implements Serializable{
    private static final long serialVersionUID = -5752419857830990301L;

    private Long id;

    /**
     * 表格主键
     */
    private Long tableId;
    /**
     * 字段主键
     */
    private Long columnId;
    /**
     * 字段名称
     */
    private String columnName;
    /**
     * 字段显示名称
     */
    private String displayName;
    /**
     * 是否列表
     */
    private Integer listFlag;
    /**
     * 格式化属性
     */
    private Integer formatter;
    /**
     * 是否表单
     */
    private Integer formFlag;
    /**
     * input 类型
     */
    private Integer inputType;
    /**
     * 校验规则
     */
    private Integer validType;
    /**
     * 是否查询
     */
    private Integer searchFlag;
    /**
     * 查询类型
     */
    private Integer searchType;
    /**
     * 备注
     */
    private String remarks;

}
