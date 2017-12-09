<!DOCTYPE html>
<html lang="en">
<head>
<#include "/layout/meta.ftl"/>
    <title>用户列表</title>
<#include "/layout/headCss.ftl"/>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
<#include "/layout/header.ftl"/>
<#include "/layout/menu.ftl"/>

    <div class="layui-body">
        <form class="layui-form" action="">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <fieldset class="layui-elem-field">
                <div class="layui-field-box">
                    <button class="layui-btn layui-btn-sm" id="add">
                        <i class="layui-icon">&#xe608;</i> 添加
                    </button>
                    <button class="layui-btn layui-btn-sm" id="batchRemove">
                        <i class="layui-icon">&#xe640;</i> 批量删除
                    </button>
                </div>
            </fieldset>
            <fieldset class="layui-elem-field">
                <div class="layui-field-box">
                    <div class="layui-inline">
                    <label class="layui-form-label">编号：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="no" autocomplete="off" class="layui-input">
                    </div>
                    </div>
                    <div class="layui-inline">
                    <label class="layui-form-label">名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" autocomplete="off" class="layui-input">
                    </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">生日：</label>
                        <div class="layui-input-inline" style="width: 100px;">
                            <input type="text" name="birthDayStart" id="birthDayStart" class="layui-input">
                        </div>
                        -
                        <div class="layui-input-inline" style="width: 100px;">
                            <input type="text" name="birthDayEnd" id="birthDayEnd" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">&nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="layui-btn layui-btn-sm">
                            查询
                        </button>
                    </div>
                </div>
            </fieldset>
            <table class="layui-table" id="mainTable">
                <colgroup>
                    <col width="8%">
                    <col width="10%">
                    <col width="15%">
                    <col width="15%">
                    <col width="20%">
                    <col width="15%">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th><input type="checkbox" name="" lay-filter="checkAll" lay-skin="primary"></th>
                    <th>序号</th>
                    <th>编号</th>
                    <th>名称</th>
                    <th>年龄</th>
                    <th>生日</th>
                    <th>创建时间</th>
                </tr>
                </thead>
                <tbody>
                <#if userList??>
                    <#list userList as user>
                    <tr>
                        <td><input type="checkbox" data-id="${user.id!''}" lay-skin="primary"></td>
                        <td>${user_index+1}</td>
                        <td>${user.no!''}</td>
                        <td>${user.name!''}</td>
                        <td>${user.age!0}</td>
                        <td><#if user.birthDay??>${user.birthDay?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
                        <td><#if user.createTime??>${user.createTime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
                    </tr>
                    </#list>
                </#if>
                </tbody>
            </table>
        </div>
        </form>
    </div>

<#include "/layout/footer.ftl"/>
</div>

<#include "/layout/footJs.ftl"/>
<script src="${ctx}/static/js/user/list.js" type="text/javascript"></script>
</body>
</html>
