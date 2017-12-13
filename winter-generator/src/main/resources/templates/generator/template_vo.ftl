package ${packageInfo.voPackage};

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

<#if columnInfoList??>
    <#list columnInfoList as column>
        <#if column.dataTypeEnum.importFlag==true>
import ${column.dataTypeEnum.fullType};
        </#if>
    </#list>
</#if>

/**
 * @Title:  ${tableInfo.voClassName}
 * @Description: ${tableInfo.comment}
 * @author ${noteInfo.author}
 * @date ${noteInfo.date}
 * @version 1.0
 */
@Data
@ToString
public class ${tableInfo.voClassName} implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    *  id
    */
    private Long id;

<#if columnInfoList??>
	<#list columnInfoList as column>

	/**
	* ${column.columnComment}
	*/
    private ${column.dataTypeEnum.javaType} ${column.columnName};
	</#list>
</#if>
	
}
