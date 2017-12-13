package com.winter.generator.entity;

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
public class PackageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String businessPackageName;

    private String controllerPackageName;

    private String viewPackageName;

    private String moduleName;

    private String savePath;

    public String getPoPath() {
        return this.getPoPackage().replace(".", "/");
    }

    public String getPoPackage() {
        return new StringBuilder().append(businessPackageName).append(".entity.").append(moduleName).toString();
    }

    public String getVoPath() {
        return this.getVoPackage().replace(".", "/");
    }

    public String getVoPackage() {
        return new StringBuilder().append(businessPackageName).append(".entity.").append(moduleName).append(".vo").toString();
    }

    public String getDaoPath() {
        return this.getDaoPackage().replace(".", "/");
    }

    public String getDaoPackage() {
        return new StringBuilder().append(businessPackageName).append(".dao.").append(moduleName).toString();
    }

    public String getMapperPath() {
        return this.getMapperPackage().replace(".","/");
    }

    public String getMapperPackage() {
        return new StringBuilder().append(businessPackageName).append(".mapper.").append(moduleName).toString();
    }

    public String getServicePath() {
        return this.getServicePackage().replace(".", "/");
    }

    public String getServicePackage() {
        return new StringBuilder().append(businessPackageName).append(".service.").append(moduleName).toString();
    }

    public String getServiceImplPath() {
        return this.getServiceImplPackage().replace(".", "/");
    }

    public String getServiceImplPackage() {
        return new StringBuilder().append(businessPackageName).append(".service.").append(moduleName).toString();
    }

    public String getServiceTestPath() {
        return this.getServiceTestPackage().replace(".", "/");
    }

    public String getServiceTestPackage() {
        return new StringBuilder().append(businessPackageName).append(".test.").append(moduleName).toString();
    }

    public String getControllerPath() {
        return this.getControllerPackage().replace(".","/");
    }

    public String getControllerPackage() {
        return new StringBuilder().append(controllerPackageName).append(".").append(moduleName).toString();
    }

    public String getViewPath() {
        return this.getViewPackage().replace(".","/");
    }

    public String getViewPackage() {
        return new StringBuilder().append(viewPackageName).append(".").append(moduleName).toString();
    }

    public static void main(String[] args) {

    }
}
