

DROP TABLE IF EXISTS `${tableInfo.tableName}`;

/**
* @author ${noteInfo.author}
* @date ${noteInfo.date}
* @version 1.0
*/

CREATE TABLE `${tableInfo.tableName}` (
<#if columnInfoList??>
 <#list columnInfoList as column>
  `${column.columnName!}`  ${column.columnType!}  ${column.columnLength!} ${column.columnNull!}  <#if column.columnDefault??>${column.columnDefault}</#if>  COMMENT '${column.columnComment!}',
 </#list>
</#if>
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='${tableInfo.comment!}';