<!<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${request.contextPath}/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${request.contextPath}/css/global.css" media="all">
</head>

<body>

<#include "../nav.ftl">
<form id="query-profile-form" class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">用户名称</label>
            <div class="layui-input-inline">
                <input id="userNameList"
                       name="userNameList"
                       value="${form.userNameList!''}"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <button class="layui-btn" lay-submit="" lay-filter="submitBtn">查询</button>
            <a class="layui-btn" href="/userProfile/edit.htm">新增</a>
        </div>
    </div>

    <input id="currentPage" name="currentPage" value="${form.currentPage}" hidden="true"/>
    <input id="pageSize" name="pageSize" value="20" hidden="true"/>
</form>

<table class="layui-table" lay-even="" lay-skin="line">
    <colgroup>
    <#--<col width="80">-->
        <col width="200">
    <#--<col width="300">-->
    <#--<col width="200">-->
        <col width="300">
        <col width="120">
        <col>
    </colgroup>
    <thead>
    <tr>
    <#--<th>ID</th>-->
        <th>配置名称</th>
    <#--<th>创建人</th>-->
    <#--<th>创建时间</th>-->
        <th>备注</th>
        <th>详情</th>
    </tr>
    </thead>
    <tbody>
    <#list page.records as profile>
    <tr>
    <#--<td>${profile.id!''}</td>-->
        <td>${profile.profileName!''}</td>
    <#--<td>${profile.creator!''}</td>-->
    <#--<td>${profile.created?string("yyyy-MM-dd")}</td>-->
        <td>${profile.memo!''}</td>
        <td>
            <a href="/userProfile/edit.htm?profileId=${profile.id}" class="layui-btn layui-btn-mini">编辑</a>
            <a href="/dnsMapping/list.htm?profileId=${profile.id}" style="background-color: #37cffe" class="layui-btn layui-btn-mini">详情</a>
            <a onclick="activateProfile('${profile.id}')" class="layui-btn layui-btn-mini">激活</a>
            <a onclick="deleteProfile('${profile.id}')" style="background-color: #ff3336" class="layui-btn layui-btn-mini">删除</a>

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

    var activateProfile = function (profileId) {
        $.ajax({
            url: "/userProfile/activate?profileId="+profileId,
            success: function (result) {
                if (result.success){
                    alert('激活成功');
                }else{
                    alert(result.message);
                }
            }
        });
    }

    var deleteProfile = function(profileId){
        $.ajax({
            url: "/userProfile/delete?profileId="+profileId,
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
            $('#query-profile-form').submit();
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