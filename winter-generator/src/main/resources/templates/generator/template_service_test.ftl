package ${packageInfo.servicePackage};

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import ${packageInfo.voPackage}.${tableInfo.voClassName};
import ${packageInfo.servicePackage}.${tableInfo.serviceClassName};

/**   
 * @Title: ${tableInfo.serviceTestClassName}
 * @Description:
 * @author ${noteInfo.author}
 * @date ${noteInfo.date}
 * @version 1.0
 */
@DirtiesContext
@ContextConfiguration(locations = { "/context/applicationContext.xml" })
public class ${tableInfo.serviceTestClassName} extends AbstractJUnit4SpringContextTests{

    @Autowired
    private ${tableInfo.serviceClassName} ${tableInfo.serviceClassName?uncap_first};

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save(){
        ${tableInfo.voClassName} ${tableInfo.voClassName?uncap_first} = new ${tableInfo.voClassName}();
        //TODO 此处需要添加具体类型代码
        ${tableInfo.serviceClassName?uncap_first}.save(${tableInfo.voClassName?uncap_first});
    }

}
