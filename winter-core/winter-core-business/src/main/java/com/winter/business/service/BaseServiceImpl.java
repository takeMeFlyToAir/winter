package com.winter.business.service;

import com.winter.business.dao.BaseDaoHelper;
import com.winter.business.entity.BusinessEntity;
import com.winter.business.mapper.BaseMapper;
import com.winter.business.page.Pager;
import com.winter.business.page.PagerResult;
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
        return toVO(BaseDaoHelper.save(toPO(entity),getBaseMapper()));
    }

    /**
     * 保存列表 自动生成id属性
     *
     * @param entity
     * @return
     */
    @Override
    public int saveList(List<V> entity) {
        return BaseDaoHelper.saveList(toPOList(entity),getBaseMapper());
    }

    /**
     * 更新所有字段
     *
     * @param entity
     * @return
     */
    @Override
    public int update(V entity) {
        return BaseDaoHelper.update(toPO(entity),getBaseMapper());
    }

    /**
     * 更新对象的非空属性字段
     *
     * @param entity
     * @return
     */
    @Override
    public int updateSelective(V entity) {
        return BaseDaoHelper.updateSelective(toPO(entity),getBaseMapper());
    }

    /**
     * 删除
     *
     * @param entity
     * @return
     */
    @Override
    public int delete(V entity) {
        return BaseDaoHelper.delete(toPO(entity),getBaseMapper());
    }

    /**
     * 根据key删除
     *
     * @param entity
     * @return
     */
    @Override
    public int deleteByKey(V entity) {
        return BaseDaoHelper.deleteByKey(toPO(entity),getBaseMapper());
    }

    /**
     * 根据key查询对象
     *
     * @param key
     * @return
     */
    @Override
    public V get(Object key) {
        return toVO(BaseDaoHelper.get(key,getBaseMapper()));
    }

    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    @Override
    public List<V> select(V entity) {
        return toVOList(BaseDaoHelper.select(toPO(entity),getBaseMapper()));
    }


    private Pager<P> toPagerPO(Pager<V> pager){
        Pager<P> pagerP = new Pager<>();
        pagerP.setLimit(pager.getLimit());
        pagerP.setOffset(pager.getOffset());
        pagerP.setCondition(toPO(pager.getCondition()));
        return  pagerP;
    }

    private PagerResult<V> toPagerResultVO(PagerResult<P> pPagerResult){
        PagerResult<V> pagerResultVO = pPagerResult.convertPagerResult(new PagerResult.Converter<P, V>(){
            @Override
            public V convert(P p) {
                V vo = toVO(p);
                return vo;
            }
        });
        return pagerResultVO;
    }
    /**
     * 分页查询
     *
     * @param pager
     * @return
     */
    @Override
    public PagerResult<V> getPagerResult(Pager<V> pager) {
          return toPagerResultVO(BaseDaoHelper.getPagerResult(toPagerPO(pager),getBaseMapper()));
    }
}
