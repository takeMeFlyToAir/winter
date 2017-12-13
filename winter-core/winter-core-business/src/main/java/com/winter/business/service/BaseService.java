package com.winter.business.service;


import java.util.List;

public interface BaseService<T> {


    /**
     * 保存  生成id属性
     *
     * @param entity
     * @return
     */
    T save(T entity);


    /**
     * 保存列表 自动生成id属性
     *
     * @param entity
     * @return
     */
    int saveList(List<T> entity);


    /**
     * 更新所有字段
     *
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 更新对象的非空属性字段
     *
     * @param entity
     * @return
     */
    int updateSelective(T entity);


    /**
     * 删除
     * @param entity
     * @return
     */
    int delete(T entity);

    /**
     * 根据key删除
     * @param entity
     * @return
     */
    int deleteByKey(T entity);

    /**
     * 根据key查询对象
     * @param key
     * @return
     */
    T get(Object key);

    /**
     * 查询列表
     * @param entity
     * @return
     */
    List<T> select(T entity);





}
