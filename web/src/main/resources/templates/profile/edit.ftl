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
<form id="save_profile_form" class="layui-form layui-form-pane" action="/userProfile/save.htm">
    <input hidden="hidden" name="id" value="${profile.id!''}">
    <div class="layui-form-item">
        <label class="layui-form-label">配置名称</label>
        <div class="layui-input-block">
            <input type="text"
                   name="profileName"
                   value="${profile.profileName!''}"
                   autocomplete="off"
                   placeholder="请输入配置名称"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注信息</label>
        <div class="layui-input-block">
            <textarea name="memo"
                      placeholder="请输入备注"
                      class="layui-textarea">${profile.memo!''}</textarea>
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
            $('#save_profile_form').submit();
            return false;
        });
    });

</script>
</html>