package com.winter.business.service;

import com.winter.business.dao.BaseDaoHelper;
import com.winter.business.entity.BusinessEntity;
import com.winter.business.mapper.BaseMapper;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public abstract class BaseServiceImpl<P extends BusinessEntity,V> implements BaseService<V> {


    protected abstract BaseMapper<P> getBaseMapper();

    protected abstract V toVO(P p);

    protected abstract P toPO(V v);

    protected List<P> toPOList(List<V> voList) {
        List<P> poList = new ArrayList<P>();
        for(V v: voList) {
            poList.add(toPO(v));
        }
        return poList;
    }

    protected List<V> toVOList(List<P> poList) {
        List<V> voList = new ArrayList<V>();
        for(P p : poList) {
            voList.add(toVO(p));
        }
        return voList;
    }
    /**
     * 保存  生成id属性
     *
     * @param entity
     * @return
     */
    @Override
    public V save(V entity) {
        return toVO(BaseDaoHelper.save(toPO(entity),getBaseMaper()));
    }

    /**
     * 保存列表 自动生成id属性
     *
     * @param entity
     * @return
     */
    @Override
    public int saveList(List<V> entity) {
        return BaseDaoHelper.saveList(toPOList(entity),getBaseMaper());
    }

    /**
     * 更新所有字段
     *
     * @param entity
     * @return
     */
    @Override
    public int update(V entity) {
        return BaseDaoHelper.update(toPO(entity),getBaseMaper());
    }

    /**
     * 更新对象的非空属性字段
     *
     * @param entity
     * @return
     */
    @Override
    public int updateSelective(V entity) {
        return BaseDaoHelper.updateSelective(toPO(entity),getBaseMaper());
    }

    /**
     * 删除
     *
     * @param entity
     * @return
     */
    @Override
    public int delete(V entity) {
        return BaseDaoHelper.delete(toPO(entity),getBaseMaper());
    }

    /**
     * 根据key删除
     *
     * @param entity
     * @return
     */
    @Override
    public int deleteByKey(V entity) {
        return BaseDaoHelper.deleteByKey(toPO(entity),getBaseMaper());
    }

    /**
     * 根据key查询对象
     *
     * @param key
     * @return
     */
    @Override
    public V get(Object key) {
        return toVO(BaseDaoHelper.get(key,getBaseMaper()));
    }

    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    @Override
    public List<V> select(V entity) {
        return toVOList(BaseDaoHelper.select(toPO(entity),getBaseMaper()));
    }
}
