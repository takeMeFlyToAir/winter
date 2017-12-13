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
public class NoteInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 创建人
     */
    private String author;

    /**
     * 时间
     */
    private String  date;

}
