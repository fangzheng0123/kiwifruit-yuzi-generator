package ${basePackage}.model;

import lombok.Data;

@Data
public class DataModel {
<#list modelConfig.models as modelsInfo>
    <#if modelsInfo.description??>
    /*
    * ${modelsInfo.description}
    */</#if>
    private ${modelsInfo.type} ${modelsInfo.fieldName}<#if modelsInfo.defaultValue??> = ${modelsInfo.defaultValue?c}</#if>;
</#list>

}
