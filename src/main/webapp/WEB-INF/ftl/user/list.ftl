<#include "/layout/head.ftl">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>用户列表页面</title>
</head>
<body>
    用户<br>
    <span>no</span>&nbsp;&nbsp;<span>name</span>&nbsp;&nbsp;<span>password</span>&nbsp;&nbsp;<span>age</span>&nbsp;&nbsp;<br>
    <#if userList??>
        <#list userList as user>
            <span>${user.no}</span>&nbsp;&nbsp;<span>${user.name}</span>&nbsp;&nbsp;
            <span>${user.password}</span>&nbsp;&nbsp;<span>${user.age}</span>&nbsp;&nbsp;
            <br>
        </#list>
    </#if>
</body>
</html>