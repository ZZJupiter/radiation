<!<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>DNS 管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${request.contextPath}/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${request.contextPath}/css/global.css" media="all">
</head>

<body>
<#include "../nav.ftl">
<form id="query-dns-form" class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">ip地址</label>
            <div class="layui-input-inline">
                <input id="userNameList"
                       name="userNameList"
                       value="${form.ip!''}"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">域名</label>
            <div class="layui-input-inline">
                <input id="userNameList"
                       name="userNameList"
                       value="${form.domain!''}"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <button class="layui-btn" lay-submit="" lay-filter="submitBtn">查询</button>
            <a class="layui-btn" href="/dnsMapping/edit.htm?profileId=${form.profileId}">新增</a>
        </div>
    </div>

    <input id="currentPage" name="currentPage" value="${form.currentPage}" hidden="true"/>
    <input id="pageSize" name="pageSize" value="20" hidden="true"/>
</form>

<table class="layui-table" lay-even="" lay-skin="line">
    <colgroup>
    <#--<col width="80">-->
        <col width="200">
        <col width="200">
        <col width="200">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
    <#--<th>ID</th>-->
        <th>IP地址</th>
        <th>域名</th>
    <#--<th>创建时间</th>-->
        <th>备注</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <#list page.records as dnsMapping>
    <tr>
    <#--<td><a href="http://www.baidu.com" target="_blank">${profile.freightName!''}</a></td>-->
    <#--<td>${dnsMapping.id!''}</td>-->
        <td>${dnsMapping.ip!''}</td>
        <td>${dnsMapping.domain!''}</td>
    <#--<td>${dnsMapping.created?string("yyyy-MM-dd HH:mm:ss zzzz")}</td>-->
        <td>${dnsMapping.memo!''}</td>
        <td>
            <a href="/dnsMapping/edit.htm?dnsMappingId=${dnsMapping.id}&profileId=${form.profileId}" class="layui-btn layui-btn-mini">编辑</a>
            <a onclick="deleteDnsMapping('${dnsMapping.id}')" style="background-color: #ff4c3f" class="layui-btn layui-btn-mini">删除</a>
        </td>
    </tr>
    </#list>
    </tbody>
</table>

<div id="pageBar"></div>

</body>
<script src="${request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script src="${request.contextPath}/js/jquery-1.11.1.min.js" charset="utf-8"></script>
<script>

    $(function () {

    });

    var getNextPage = function (obj, first) {
        $('#currentPage').val(obj.curr);
        if (!first) {
            $('#query-profile-form').submit();
        }
    }

    var deleteDnsMapping = function(dnsMappingId){
        $.ajax({
            url: "/dnsMapping/delete?dnsMappingId="+dnsMappingId,
            success: function (result) {
                if (result.success){
                    location.reload();
                    alert('删除成功');
                }else{
                    alert(result.message);
                }
            }
        });
    }

    layui.use(['laypage', 'form'], function () {
        var laypage = layui.laypage;
        var form = layui.form();
        laypage({
            cont: 'pageBar',
            pages: ${page.pages!0},
            skin: '#1E9FFF',
            jump: getNextPage,
            curr:${form.currentPage}
        });

        //监听提交
        form.on('submit(submitBtn)', function (data) {
            $('#currentPage').val(1);
            $('#query-order-form').submit();
            return false;
        });


    });
    var openEditPage = function () {
        //iframe窗
        layer.open({
            type: 2,
            title: '编辑配置',
            shadeClose: true,
            shade: false,
            maxmin: true, //开启最大化最小化按钮
            area: ['893px', '600px'],
            content: '/userProfile/edit.htm'
        });
    }


</script>

</html>