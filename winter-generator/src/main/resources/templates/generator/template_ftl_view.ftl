package ${packageInfo.controllerPackage};

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ${packageInfo.voPackage}.${tableInfo.voClassName};


/**   
 * @Title: ${noteInfo.title}
 * @Description: ${noteInfo.description}
 * @author ${noteInfo.author}
 * @date ${noteInfo.date}
 * @version 1.0
 */

@Controller
@RequestMapping("/${packageInfo.moduleName}/${tableInfo.className?uncap_first}")
public class ${tableInfo.controllerClassName} extends BaseController<${tableInfo.voClassName}> {


}
