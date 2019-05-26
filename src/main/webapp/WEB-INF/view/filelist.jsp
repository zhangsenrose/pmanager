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
    <form id="addfileform"  enctype="multipart/form-data">
        <input type="file" id="file" name="file">
    </form>
</div>
<div id="dialog-buttons">
    <a href="javascript:addFile()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<script>
    $('#dg').datagrid({
        toolbar:'#tb',
        fitColumns:true,
        singleSelect:true,
        rownumbers:true,
        pagination:true,
        fit:true,
        url:'file/filelist',
        columns:[[
            {field:'fileName', title:'fileName', width:100},
            {field: 'fileSize', title: 'fileSize', width: 100},
            {field:'fileExtension', title:'fileExtension',width:100},
            {field:'fileUniqueName', title:'fileUniqueName',width:100}
        ]]
    });
    
    function openAddFileDialog() {
        $("#dlg").dialog('open').dialog('setTitle', '上传文件');
        method = "POST";
    }
    function closeDialog() {
        $("#dlg").dialog("close");
    }
    function addFile() {
        //上传文件
        var data = new FormData()
        data.append('file', $('#file')[0].files[0])
        $.ajax('file/fileadd', {
            method:'POST',
            data: data,
            processData:false,
            contentType:false,
            success:function (data) {
                if (data.code == 200){
                    //请求成功，弹出信息，然后自动关闭
                    $.messager.alert('文件上传','上传成功', 'info',function () {
                        $("#dlg").dialog("close");
                        //重新加载 datag reload
                        $('#dlg').datagrid('reload');
                    })
                }else{
                    //弹出框，网络异常，请重试
                }
            }
        })



    }
</script>
</html>
