package com.winter.generator.util;

import com.winter.generator.entity.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class GeneratorManagerConfig {


    private TableInfo tableInfo;

    private List<FieldInfo> fieldInfoList;

    private NoteInfo noteInfo;

    private PackageInfo packageInfo;

    private List<PageConfig> pageConfigList;

    private GeneratorManagerConfig(){}

    public static  GeneratorManagerConfig newInstance(){
        return new GeneratorManagerConfig();
    }

    public  GeneratorManagerConfig build(){
        return  this;
    }

    public  GeneratorManagerConfig setTableInfo(TableInfo tableInfo){
        if(tableInfo != null){
            this.tableInfo = tableInfo;
        }else{
            throw new IllegalArgumentException("tableInfo 值不能为 null");
        }
        return this;
    }

    public GeneratorManagerConfig setFieldInfoList(List<FieldInfo> fieldInfoList){
        if(fieldInfoList != null && !fieldInfoList.isEmpty()){
            this.fieldInfoList = fieldInfoList;
        }else{
            throw new IllegalArgumentException("fieldInfoList 值不能为空");
        }
        return this;
    }

    public GeneratorManagerConfig setNoteInfo(NoteInfo noteInfo){
        if(noteInfo != null){
            this.noteInfo = noteInfo;
        }else{
            this.noteInfo = new NoteInfo();
            this.noteInfo.setAuthor("wdd");
            this.noteInfo.setDate(Instant.now().toString());
        }
        return this;
    }
    public GeneratorManagerConfig setPackageInfo(PackageInfo packageInfo){
        if(packageInfo != null){
            this.packageInfo = packageInfo;
        }else{
            throw new IllegalArgumentException("packageInfo 值不能为空");
        }
        return this;
    }
    public GeneratorManagerConfig setpageConfigList(List<PageConfig> pageConfigList){
        if(pageConfigList != null && !pageConfigList.isEmpty()){
            this.pageConfigList = pageConfigList;
        }else{
            throw new IllegalArgumentException("pageConfigList 值不能为空");
        }
        return this;
    }
}
