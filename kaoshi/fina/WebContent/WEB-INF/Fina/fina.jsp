<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table tr:nth-child(odd){
	background-color:fuchsia;
	color: black;
}
a{
	float: right;
color: black;
}
a:hover{
color: red;
}
table td{
	text-align: center;
}
#td{
border:0px;
color: red;
}
span{
margin：10px;
cursor: default;}
</style>

</head>
<body>

<form action="fina.action?operate=select" method="post">
	

<table width=80% border="1" align="center">
<tr><th colspan="5">产品代码<input type="text" id="inp" name="id" value=""/>风险评级
	<select name="risk">
		<option value="0" selected="selected">请选择</option>
		<option value="1">R1</option>
		<option value="2">R2</option>
		<option value="3">R3</option>
	</select>
	<input type="submit" name="" id="" value="查询" /></th>

	<td ><a href="fina.action?operate=add">新增理财信息</a></td>
</tr>
<tr><td colspan="6">
<c:forEach var="id" items="${cookieList }">
<span class="span">${id }</span>
</c:forEach>
</td></tr>
<tr>
<td>产品代码</td>
<td>风险评级</td>
<td >预期收益</td>
<td>发售起始日</td>
<td>发售截至日</td>
<td>产品到期日</td>

</tr>
	<c:forEach var="f" items="${finalist }">
	<tr>
	<td>${f.id}</td>
	<td>R${f.risk}</td>
	<td>${f.income}</td>
	<td>${f.salestarting}</td>
	<td>${f.saleend}</td>
	<td>${f.end}</td>

	</tr>
	</c:forEach>
	<tr>
<td colspan="6" id="td">${name }</td>


</tr>
</table>
</form>
</body>
</html>
<script src="js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
 $(function(){
 	$(".span").click(function(){
 		var id=$(this).text();
 		$("#inp").val(id);
 	});
 });
</script>