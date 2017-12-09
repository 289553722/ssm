<!DOCTYPE html>
<html lang="en">
<head>
    <#include "/layout/meta.ftl"/>
    <title>用户管理系统</title>
    <#include "/layout/headCss.ftl"/>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <#include "/layout/header.ftl"/>
    <#include "/layout/menu.ftl"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">欢迎访问</div>
    </div>

    <#include "/layout/footer.ftl"/>
</div>

<#include "/layout/footJs.ftl"/>
<script src="${ctx}/static/js/list.js" type="text/javascript"></script>
</body>
</html>
