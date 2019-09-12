<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎页</title>
<style type="text/css">

	div{
		width: 50%;
		margin: auto;
	}
	table{
		
		margin: auto;
		margin-top: 100px;
		height: 300px;
		width: 500px;
	
	}
	h1{
		text-align: center;
	}
	table tr{
		padding: 20px;
	}
	td{
		font-size: 20px;
		text-align: center;
		

	}
	.input1{
		
		width: 99%;
		height: 100%;
	}
	.input{
		width: 50px;
		margin: 10px;
		height: 25px;
	}
	
	

	#span{
		color: blue;
	
		display: none;
	}
	#span1{
		color: red;
		display: none;
	}
	select{
		width: 50%;
		height: 25px;
	}
	#td1{
		text-align: left;
	}
</style>


</style>
</head>
<body>
	<div id="div">
		<form action="fina.action?operate=addfina" method="post">
			<table id="table"   align="center">
				<tr><td colspan="3"><h1>新增产品</h1></td></tr>
				<tr><td>产品代码</td>
					<td  colspan="2"><input id="input1" class="input1" type="text" name="name" value="" /></td>
					<td id="td"><span id="span">名称可用</span><span id="span1">名称不可用</span></td>
				</tr>
				<tr><c:forEach var="f" items="${finalist }">
					<input type="hidden"  name="flowername" id="" value="${f.id }" />
				</c:forEach>
				</tr>
				<tr><td>风险评级</td><td colspan="2" id="td1"><select id="select" name="risk">
		<option value="0" selected="selected">请选择</option>
		<option value="1">R1</option>
		<option value="2">R2</option>
		<option value="3">R3</option>
	</select></td></tr>
				<tr><td>预期收益</td>
					<td colspan="2"><input id="input2" class="input1" type="text" name="nickname" value="" /></td>
					</tr>
					<tr>
						<td>发售起始日</td>
						<td colspan="2"><input id="input3" class="input1" type="text" name="property" value="" /></td>
						<td>yyyy-MM-dd</td>
					</tr>
					<tr>
						<td>发售截至日</td>
						<td colspan="2"><input id="input4" class="input1" type="text" name="price" value="" /></td>
						<td>yyyy-MM-dd</td>
					</tr>
					<tr>
						<td>产品到期日</td>
						<td colspan="2"><input id="input5" class="input1" type="text" name="production" value="" /></td>
						<td>yyyy-MM-dd</td>
					</tr>
					<tr><td colspan="3"><input type="button" class="input" id="input" value="添加" /><input type="reset" class="input" name="" id="" value="重置" /></td></tr>
			</table>
			
		</form>
	</div>
</body>
</html>
<script src="js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		$("#input1").blur(function(){
			user();
		});
		$("#input2").blur(function(){
			nick();
		});
		$("#input3").blur(function(){
			property();
		});
		$("#input4").blur(function(){
			price();
		});
		$("#input5").blur(function(){
			production();
		});
		$("#input").click(function(){
			var f=user()&&select1()&&nick()&&property()&&price()&&production();
			if(f==true){
				$("#input").attr("type","submit");
			}
		});
		
	});
	function user(){
		var user=$("#input1").val();
		var flowername=document.getElementsByName("flowername");
		var f=true;
		if(user==""){
			alert("代码不可为空");
			f=false;
		}
		for (var i=0;i<flowername.length;i++) {
			if(user==flowername[i].value){
				$("#span1").css("display","block");
			f=false;
			}
		}
		if(f==true){
			$("#span").css("display","block");
			$("#span1").css("display","none");
		}
		return f;
	}
	function nick(){
		var user=$("#input2").val();
		
		var f=true;
		if(user==""){
			alert("收益不可为空");
			f=false;
		}
		return f;
	}
		function property(){
		var user=$("#input3").val();
		var reg=/^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
		var f=true;
		if(user==""){
			alert("发售日期不可为空");
			f=false;
		}else if(reg.test(user)==false){
			alert("发售日期格式不对");
				f=false;
		}
		return f;
	}
			function price(){
		var user=$("#input4").val();
		var reg=/^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
		var f=true;
		if(user==""){
			alert("截至日期不可为空");
			f=false;
		}else if(reg.test(user)==false){
			alert("截至日期格式不对");
			f=false;
		}
		return f;
	}
	function production(){
		var user=$("#input5").val();
			var reg=/^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
		var f=true;
		if(user==""){
			alert("到期日期不可为空");
			f=false;
		}else if(reg.test(user)==false){
			alert("截至日期格式不对");
			f=false;
		}
		return f;
	}
	function select1(){
		var sel=$("#select").val();
		var f=true;
		if(sel==0){
			alert("风险评级不可为空");
			f=false;
		}
		return f;
	}
</script>
