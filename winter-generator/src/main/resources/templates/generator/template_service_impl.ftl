package ${packageInfo.serviceImplPackage};

import com.winter.business.mapper.BaseMapper;
import com.winter.business.service.BaseServiceImpl;
import com.winter.business.util.EntityConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${packageInfo.poPackage}.${tableInfo.poClassName};
import ${packageInfo.voPackage}.${tableInfo.voClassName};
import ${packageInfo.servicePackage}.${tableInfo.serviceClassName};


/**
 * @Title:  ${tableInfo.serviceImplClassName}
 * @Description: ${tableInfo.comment}
 * @author ${noteInfo.author}
 * @date ${noteInfo.date}
 * @version 1.0
 */

@Service
public class ${tableInfo.serviceImplClassName} extends BaseServiceImpl<${tableInfo.poClassName},${tableInfo.voClassName}> implements ${tableInfo.serviceClassName} {

    @Autowired
    private BaseMapper<${tableInfo.poClassName}> mapper;

    @Override
    protected BaseMapper<${tableInfo.poClassName}> getBaseMapper() {
        return mapper;
    }

    @Override
    protected ${tableInfo.voClassName} toVO(${tableInfo.poClassName} ${tableInfo.poClassName?uncap_first}) {
        return EntityConvertUtil.poToVo(${tableInfo.poClassName?uncap_first},${tableInfo.voClassName}.class);
    }

    @Override
    protected ${tableInfo.poClassName} toPO(${tableInfo.voClassName} ${tableInfo.voClassName?uncap_first}) {
        return EntityConvertUtil.voToPo(${tableInfo.voClassName?uncap_first},${tableInfo.poClassName}.class);
    }

}
