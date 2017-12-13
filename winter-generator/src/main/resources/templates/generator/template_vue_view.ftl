<template>
    <div>
        <el-row>
            <el-col :span="24" >
                <el-form :inline="true" :model="filters">
                    <el-form-item>
                        <el-button type="primary" @click="handleAdd">新增</el-button>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="handleDelete">删除</el-button>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
    </div>


    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" @selection-change="selectionChange">
        <el-table-column type="selection" width="55">
        </el-table-column>
        <el-table-column type="index" width="60">
        </el-table-column>
    <#if columnInfoList??>
        <#list columnInfoList as column>
        <el-table-column prop="column.columnName" label="columnComment"  :formatter="formatSex">
        </el-table-column>
        </#list>
    </#if>
        <el-table-column label="操作" width="150">
            <template scope="scope">
                <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            </template>
        </el-table-column>
    </el-table>
</template>