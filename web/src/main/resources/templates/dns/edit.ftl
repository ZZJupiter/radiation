<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>编辑配置</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${request.contextPath}/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${request.contextPath}/css/global.css" media="all">
</head>
<body>
<#include "../nav.ftl">
<form id="save_dns_mapping_form" class="layui-form layui-form-pane" action="/dnsMapping//save.htm">
    <input hidden="hidden" name="profileId" value="${form.profileId}">
    <input hidden="hidden" name="id" value="${dnsMapping.id!''}">
    <div class="layui-form-item">
        <label class="layui-form-label">IP</label>
        <div class="layui-input-block">
            <input type="text"
                   name="ip"
                   value="${dnsMapping.ip!''}"
                   autocomplete="off"
                   placeholder="请填写IP地址"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">域名</label>
        <div class="layui-input-block">
            <input type="text"
                   name="domain"
                   value="${dnsMapping.domain!''}"
                   autocomplete="off"
                   placeholder="请填写域名"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="memo"
                      placeholder="请输入备注"
                      class="layui-textarea">${dnsMapping.memo!''}</textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn" lay-submit="" lay-filter="saveBtn">保存</button>
    </div>
</form>
</body>
<script src="${request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script src="${request.contextPath}/js/jquery-1.11.1.min.js" charset="utf-8"></script>
<script>

    $(function () {

    });

    layui.use(['form',], function () {
        var form = layui.form();
        //监听提交
        form.on('submit(saveBtn)', function () {
            $('#save_dns_mapping_form').submit();
            return false;
        });
    });

</script>
</html>