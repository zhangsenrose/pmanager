<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/19 0019
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件管理</title>
    <link rel="stylesheet" type="text/css" href="resources/easyui/themes/default/easyui.css">
    <link  rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css">
    <link  rel="stylesheet" type="text/css" href="resources/easyui/themes/color.css">
</head>
<body>
<div id="dg" class="easyui-datagrid"></div>
<div id="tb">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true"></a>
    <a href="javascript:openAddFileDialog();" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"></a>
</div>
</body>
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>
<%--addFileDialog--%>
<div id="dlg" class="easyui-dialog" closed="true" style="width:300px;height:200px" buttons="#dialog-buttons">
    <form id="addfileform" method="post">
        <div>
            <input type="file" name="file">
        </div>
        <div></div>
    </form>
</div>
<div id="dialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<script>
    $('#dg').datagrid({
        toolbar:'#tb',
        fitColumns:true,
        singleSelect:true,
        rownumbers:true,
        pagination:true,
        url:'',
        columns:[[
            {field:'Code', title:'Code', width:100},
            {field: 'name', title: 'Name', width: 100},
            {field:'price', title:'Price',width:100}
        ]]
    });
    
    function openAddFileDialog() {
        $("#dlg").dialog('open').dialog('setTitle', '上传文件');
        method = "POST";
    }
    function closeDialog() {
        $("#dlg").dialog("close");ss
    }
</script>
</html>
