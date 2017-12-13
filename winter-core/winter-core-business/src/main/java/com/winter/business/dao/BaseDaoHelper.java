package com.winter.business.dao;

import com.winter.business.entity.BusinessEntity;
import com.winter.business.mapper.BaseMapper;
import com.winter.business.util.EntityUtil;

import java.util.List;

public class BaseDaoHelper {
    /**
     * 通过主键获取对象
     *
     * @param key 主键，一般为Long
     * @return
     */
    public static <T> T get(Object key, BaseMapper<T> mapper) {
        return mapper.selectByPrimaryKey(key);
    }


    private static <T extends BusinessEntity> void initEntity(T entity) {
        if (entity.getId() != null) {
            entity.setId(EntityUtil.getAutoId());
        }
        entity.setDeleted(0);
    }

    /**
     * 保存对象，用于新建
     *
     * @param entity
     * @return
     */
    public static <T extends BusinessEntity> T save(T entity, BaseMapper<T> mapper) {
        initEntity(entity);
        if (mapper.insertSelective(entity) == 1) {
            return entity;
        } else {
            return null;
        }
    }

    /**
     * 批量插入，必须主键字段是id
     *
     * @param list
     * @return
     */
    public static <T extends BusinessEntity> int saveList(List<T> list, BaseMapper<T> mapper) {
        for (T entity : list) {
            initEntity(entity);
        }
        return mapper.insertList(list);
    }

    /**
     * 更新对象，对于没有值的属性会将数据库对应字段清空
     *
     * @param entity
     * @return
     */
    public static <T> int update(T entity, BaseMapper<T> mapper) {
        return updateSelective(entity, mapper);
    }

    /**
     * 更新对象的非空属性字段
     *
     * @param entity
     * @return
     */
    public static <T> int updateSelective(T entity, BaseMapper<T> mapper) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 删除对象，条件为对象赋值的属性
     *
     * @param entity
     * @return
     */
    public static <T> int delete(T entity, BaseMapper<T> mapper) {
        return mapper.delete(entity);
    }

    /**
     * 通过对象的主键属性查询并删除对象
     *
     * @param entity
     * @return
     */
    public static <T> int deleteByKey(T entity, BaseMapper<T> mapper) {
        return mapper.deleteByPrimaryKey(entity);
    }


    /**
     * 通过对象属性的条件查询出对象
     *
     * @param entity
     * @return
     */
    public static <T> List<T> select(T entity, BaseMapper<T> mapper) {
        return mapper.select(entity);
    }


}
