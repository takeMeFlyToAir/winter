package com.winter.generator.util;


import com.winter.generator.entity.*;
import com.winter.generator.enums.FileTypeEnum;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名:
 * 创建人: wdd
 * 创建时间: 2017/12/4
 */
public class GeneratorManager {

    /**
     * @param tableInfoVO      生成表的信息
     * @param columnInfoVOList 生成表的列信息
     * @param noteInfoVO       生成表的注释信息
     * @param packageInfo    生成表的包配置信息
     * @param names            生成的模板对象名称
     */
    public static void generate(TableInfo tableInfoVO, List<FieldInfo> columnInfoVOList, NoteInfo noteInfoVO, PackageInfo packageInfo, List<PageConfig> pageConfigVOList, FileTypeEnum... names) {
        Map map = new HashMap<>();
        map.put("tableInfo", tableInfoVO);
        map.put("columnInfoList", columnInfoVOList);
        map.put("pageConfigList", pageConfigVOList);
        map.put("noteInfo", noteInfoVO);
        map.put("packageInfo", packageInfo);
        for (FileTypeEnum fileTypeEnum : names) {
            FreeMarkerUtils.generate(map, fileTypeEnum.getTemplateName(), getFileName(packageInfo, fileTypeEnum, tableInfoVO));
        }


    }

    private static String getFileName(PackageInfo packageInfo, FileTypeEnum fileTypeEnum, TableInfo tableInfoVO) {
        switch (fileTypeEnum.getName()) {
            case "po": {
                return new StringBuilder().append(packageInfo.getSavePath()).append("/").append(packageInfo.getPoPath()).append("/").append(tableInfoVO.getPoClassName()).append(fileTypeEnum.getSuffix()).toString();
            }
            case "dao": {
                return new StringBuilder().append(packageInfo.getSavePath()).append("/").append(packageInfo.getDaoPath()).append("/").append(tableInfoVO.getDaoClassName()).append(fileTypeEnum.getSuffix()).toString();
            }
            case "mapper": {
                return new StringBuilder().append(packageInfo.getSavePath()).append("/").append(packageInfo.getMapperPath()).append("/").append(tableInfoVO.getMapperClassName()).append(fileTypeEnum.getSuffix()).toString();
            }
            case "service": {
                return new StringBuilder().append(packageInfo.getSavePath()).append("/").append(packageInfo.getServicePath()).append("/").append(tableInfoVO.getServiceClassName()).append(fileTypeEnum.getSuffix()).toString();
            }
            case "serviceImpl": {
                return new StringBuilder().append(packageInfo.getSavePath()).append("/").append(packageInfo.getServiceImplPath()).append("/").append(tableInfoVO.getServiceImplClassName()).append(fileTypeEnum.getSuffix()).toString();
            }
            case "serviceTest": {
                return new StringBuilder().append(packageInfo.getSavePath()).append("/").append(packageInfo.getServiceTestPath()).append("/").append(tableInfoVO.getServiceTestClassName()).append(fileTypeEnum.getSuffix()).toString();
            }
            case "sql": {
                return new StringBuilder().append(packageInfo.getSavePath()).append("/").append(packageInfo.getViewPath()).append("/").append(tableInfoVO.getClassName()).append(fileTypeEnum.getSuffix()).toString();
            }
            case "vo": {
                return new StringBuilder().append(packageInfo.getSavePath()).append("/").append(packageInfo.getVoPath()).append("/").append(tableInfoVO.getVoClassName()).append(fileTypeEnum.getSuffix()).toString();
            }
            case "controller": {
                return new StringBuilder().append(packageInfo.getSavePath()).append("/").append(packageInfo.getControllerPath()).append("/").append(tableInfoVO.getControllerClassName()).append(fileTypeEnum.getSuffix()).toString();
            }
            case "vueView": {
                return new StringBuilder().append(packageInfo.getSavePath()).append("/").append(packageInfo.getViewPath()).append("/").append(tableInfoVO.getViewName()).append(fileTypeEnum.getSuffix()).toString();

            }
            case "ftlView": {
                return new StringBuilder().append(packageInfo.getSavePath()).append("/").append(packageInfo.getViewPath()).append("/").append(tableInfoVO.getViewName()).append(fileTypeEnum.getSuffix()).toString();
            }
            default: {
                return null;
            }
        }

    }

    public static void main(String[] args) {
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.setBusinessPackageName("com.winter.business");
        packageInfo.setControllerPackageName("com.winter.controller");
        packageInfo.setModuleName("sms");
        packageInfo.setViewPackageName("com.winter.view");
        packageInfo.setSavePath("d:/aa");

        NoteInfo noteInfoVO = new NoteInfo();
        noteInfoVO.setTitle("测试用");
        noteInfoVO.setAuthor("wdd");
        noteInfoVO.setDate(String.valueOf(Instant.now()));

        TableInfo tableInfoVO = new TableInfo();
        tableInfoVO.setClassName("SmsTemplate");
        tableInfoVO.setTableName("sms_template");
        tableInfoVO.setComment("短信模板表");

        List<FieldInfo> columnInfoVOList = new ArrayList<>();
        columnInfoVOList.add(new FieldInfo("name","varchar","(255)","NOT NULL","","模版名称"));
        columnInfoVOList.add(new FieldInfo("code","varchar","(255)","NOT NULL","","模版编码"));
        columnInfoVOList.add(new FieldInfo("business_type","varchar","(4)","NOT NULL","","业务类型"));
        columnInfoVOList.add(new FieldInfo("template_content","varchar","(255)","NOT NULL","","模版内容"));
        columnInfoVOList.add(new FieldInfo("remarks","varchar","(255)","NOT NULL","","备注信息"));

        List<PageConfig> pageConfigVOList = new ArrayList<>();

        GeneratorManager.generate(tableInfoVO, columnInfoVOList, noteInfoVO, packageInfo,pageConfigVOList, FileTypeEnum.PO,FileTypeEnum.MAPPER,
                FileTypeEnum.VO, FileTypeEnum.CONTROLLER, FileTypeEnum.SERVICE,
                FileTypeEnum.SERVICE_IMPL, FileTypeEnum.SQL, FileTypeEnum.SERVICE_TEST,FileTypeEnum.VUE_VIEW);

        TableInfo tableInfoVO1 = new TableInfo();
        tableInfoVO1.setClassName("SmsSendLog");
        tableInfoVO1.setTableName("sms_send_log");
        tableInfoVO1.setComment("短信发送日志表");

        List<FieldInfo> columnInfoVOList1 = new ArrayList<>();

        columnInfoVOList1.add(new FieldInfo("phone","varchar","(255)","NOT NULL","","联系电话"));
        columnInfoVOList1.add(new FieldInfo("template_id","bigint","(20)","NOT NULL","","模版id"));
        columnInfoVOList1.add(new FieldInfo("template_content","varchar","(255)","NOT NULL","","模版内容"));
        columnInfoVOList1.add(new FieldInfo("business_type","varchar","(4)","NOT NULL","","业务类型"));
        columnInfoVOList1.add(new FieldInfo("send_data","varchar","(255)","NOT NULL","","发送数据"));
        columnInfoVOList1.add(new FieldInfo("send_id","bigint","(20)","NOT NULL","","发送响应消息ID"));
        columnInfoVOList1.add(new FieldInfo("response_msg","varchar","(20)","NOT NULL","","响应消息"));
        columnInfoVOList1.add(new FieldInfo("remarks","varchar","(255)","NOT NULL","","备注信息"));

        List<PageConfig> pageConfigVOList1 = new ArrayList<>();

        GeneratorManager.generate(tableInfoVO1, columnInfoVOList1, noteInfoVO, packageInfo,pageConfigVOList1, FileTypeEnum.PO,
                FileTypeEnum.VO, FileTypeEnum.CONTROLLER, FileTypeEnum.SERVICE,FileTypeEnum.MAPPER,
                FileTypeEnum.SERVICE_IMPL, FileTypeEnum.SQL, FileTypeEnum.SERVICE_TEST,FileTypeEnum.VUE_VIEW);


    }
}
