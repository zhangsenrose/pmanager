<%--
  Created by IntelliJ IDEA.
  User: 张森伟
  Date: 2019/5/17
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
    <link rel="stylesheet" type="text/css" href="resources/easyui/themes/default/easyui.css">
    <link  rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css">
    <link  rel="stylesheet" type="text/css" href="resources/easyui/themes/color.css">
</head>
<body class="easyui-layout layout panel-noscroll">

    <div data-options="region:'north'" style="height:20px">ES + Tika + Minio的研究</div>
    <div data-options="region:'south',split:true" style="height:50px;"></div>
    <%--<div data-options="region:'east',split:true" title="East" style="width:100px;"></div>--%>
    <div data-options="region:'west',split:true" title="导航" style="width:180px;">
        <div class="easyui-accordion">
            <div title="文件管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
               <a href="javascript:addTab(' filelist','文件管理')" class="easyui-linkbutton"
                  data-options="plain:true,iconCls:'icon-ok'"
                  style="width: 150px;">查询文件</a>
            </div>
        </div>
    </div>
<%--center--%>
    <div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
        <div class="easyui-tabs" fit="true" border="false" id="tabs">

        </div>
    </div>


</body>

<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">

    /*添加tab页面*/
  function addTab(url, text) {
      var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='"+url+"'></iframe>";
      $("#tabs").tabs("add", {
          title: text,
          closable: true,
          content: content
      });
  }

</script>
</html>
