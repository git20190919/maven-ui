<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css" href="assets/plugins/easyui/themes/default/easyui.css">
<link rel="stylesheet" style="text/css" href="assets/plugins/easyui/themes/icon.css">
<script type="text/javascript" src="assets/plugins/easyui/jquery.min.js"></script>
<script type="text/javascript" src="assets/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="assets/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
function getValue(){
	 var row = $('#tt').datagrid('getSelected');
		alert(row.sno);
	
}
	/* $(function(){
		$("#tt").click({
			
		})
	}) */

</script>
</head>
<body>
<input type="button" value="获取值" onclick="getValue()">
 <table id="tt" class="easyui-datagrid" style="width:700px;height:450px"
            url="data/show"
            title="表格加载数据" iconCls="icon-save"
            rownumbers="true" pagination="true">
        <thead>
            <tr>
                <th field="sno" width="80">学号</th>
                <th field="sname" width="120">姓名</th>
                <th field="sage" width="80" align="right">年龄</th>
                <th field="ssex" width="80" align="right">性别</th>
            </tr>
        </thead>
    </table>
</body>
</html>