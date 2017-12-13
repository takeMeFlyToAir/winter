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
public class NoteInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 简述
     */
    private String  title;

    /**
     * 描述
     */
    private String  description;

    /**
     * 创建人
     */
    private String author;

    /**
     * 时间
     */
    private String  date;

}
