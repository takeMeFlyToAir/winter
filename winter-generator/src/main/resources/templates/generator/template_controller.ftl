package ${packageInfo.controllerPackage};

import com.gt.util.page.Pager;
import com.gt.util.page.PagerResult;
import com.gt.util.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ${packageInfo.voPackage}.${tableInfo.voClassName};
import ${packageInfo.servicePackage}.${tableInfo.serviceClassName};


/**   
 * @Title:  ${tableInfo.controllerClassName}
 * @Description: ${tableInfo.comment}
 * @author ${noteInfo.author}
 * @date ${noteInfo.date}
 * @version 1.0
 */

@Controller
@RequestMapping("/${packageInfo.moduleName}/${tableInfo.className?uncap_first}")
public class ${tableInfo.controllerClassName} {

    @Autowired
    private ${tableInfo.serviceClassName} ${tableInfo.serviceClassName?uncap_first};

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult doDelete(@RequestBody ${tableInfo.voClassName} ${tableInfo.voClassName?uncap_first}) {
        ${tableInfo.serviceClassName?uncap_first}.delete(${tableInfo.voClassName?uncap_first});
        return new JsonResult("删除成功！");
    }

    @RequestMapping("/pager")
    @ResponseBody
    public PagerResult getPagerResult(@RequestBody ${tableInfo.voClassName} ${tableInfo.voClassName?uncap_first}, Pager pager) {
        pager.setCondition(${tableInfo.voClassName?uncap_first});
        return ${tableInfo.serviceClassName?uncap_first}.selectPage(pager);
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult doSave(@RequestBody ${tableInfo.voClassName} ${tableInfo.voClassName?uncap_first}) {
        if(${tableInfo.voClassName?uncap_first}.getId() != null){
            ${tableInfo.serviceClassName?uncap_first}.updateSelective(${tableInfo.voClassName?uncap_first});
        }else{
            ${tableInfo.voClassName?uncap_first} = ${tableInfo.serviceClassName?uncap_first}.save(${tableInfo.voClassName?uncap_first});
        }
        return new JsonResult("执行成功！", testInfoVO);
    }

}
