package com.winter.generator.entity;

import com.sun.deploy.util.StringUtils;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 类名:
 * 创建人: wdd
 * 创建时间: 2017/12/4
 */
@ToString
@Data
public class TableInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    /**
     * 表格名称
     */
    @NotBlank
    private String tableName;
    /**
     * 类名称
     */
    private String className;
    /**
     * 数据表创建类型
     */
    private Integer createType;
    /**
     * 备注
     */
    private String comment;

    /**
     * 用户编号
     */
    private Long userId;


    public String getClassName() {
        if (className != null &&! "" .equals(className)) {
            return className;
        }else{
            return tableName;
        }
    }


    public String getPoClassName() {
        return getClassName();
    }



    public String getDaoClassName() {
        return getClassName()+"DAO";
    }

    public String getMapperClassName() {
        return getClassName() +"Mapper";
    }

    public String getServiceClassName() {
        return getClassName() +"Service";
    }

    public String getServiceImplClassName() {
        return getServiceClassName() +"Impl";
    }
    public String getServiceTestClassName() {
        return getServiceClassName() +"Test";
    }
    public String getVoClassName() {
        return getClassName()+"VO";
    }
    public String getControllerClassName(){
        return  getClassName() + "Controller";
    }

    public String getViewName() {
        return getClassName();
    }
}
