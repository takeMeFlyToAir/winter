package ${packageInfo.poPackage};

import javax.persistence.Table;
import lombok.Data;
import com.winter.business.entity.BusinessEntity;
import lombok.EqualsAndHashCode;
import lombok.ToString;
<#if columnInfoList??>
    <#list columnInfoList as column>
        <#if column.dataTypeEnum.importFlag==true>
import ${column.dataTypeEnum.fullType} ;
        </#if>
    </#list>
</#if>

/**
 * @Title:  ${tableInfo.poClassName}
 * @Description: ${tableInfo.comment}
 * @author ${noteInfo.author}
 * @date ${noteInfo.date}
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@Table(name="${tableInfo.tableName}")
public class ${tableInfo.className} extends BusinessEntity {

<#if columnInfoList??>
	<#list columnInfoList as column>

	/**
	* ${column.columnComment}
	*/
    private ${column.dataTypeEnum.javaType} ${column.columnName};
	</#list>
</#if>
	
}
