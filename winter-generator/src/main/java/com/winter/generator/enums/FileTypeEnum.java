package com.winter.generator.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名:
 * 创建人: wdd
 * 创建时间: 2017/12/4
 */

public enum FileTypeEnum {
    PO("po",".java", "template_entity.ftl"),
    DAO("dao",".java", "template_dao.ftl"),
    MAPPER("mapper",".java", "template_mapper.ftl"),
    SERVICE("service",".java", "template_service.ftl"),
    SERVICE_IMPL("serviceImpl",".java", "template_service_impl.ftl"),
    SERVICE_TEST("serviceTest",".java", "template_service_Test.ftl"),
    SQL("sql",".sql", "template_sql.ftl"),
    VO("vo",".java", "template_vo.ftl"),
    CONTROLLER("controller",".java","template_controller.ftl"),
    VUE_VIEW("vueView",".vue", "template_vue_view.ftl"),
    FTL_VIEW("ftlView",".ftl", "template_ftl_view.ftl");

    private final String name;
    private final String suffix;
    private final String templateName;

    private static Map<String, FileTypeEnum> map = new HashMap<String, FileTypeEnum>();
    static {
        for (FileTypeEnum fileTypeEnum : FileTypeEnum.values()) {
            map.put(fileTypeEnum.getName(), fileTypeEnum);
        }
    }

    public static FileTypeEnum from(String name) {
        return map.get(name);
    }

    FileTypeEnum(String name, String suffix, String templateName) {
        this.name = name;
        this.suffix = suffix;
        this.templateName = templateName;
    }

    public String getName() {
        return name;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getTemplateName() {
        return templateName;
    }
}
