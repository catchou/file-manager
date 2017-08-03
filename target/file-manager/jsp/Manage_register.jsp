<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DSZ文档管理系统</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
</head>
<style>
    table {
    }
    table .td1{
        font-size: 30px;
        color: black;
    }
    table .td1 .input1{
        width: 220px;
        height: 30px;
    }
</style>
<script>
        function compare(){
        var a=document.getElementById('textfield2').value;
        var b=document.getElementById('textfield3').value;
        if(a==b){
        document.getElementById('ts').innerHTML="密码一致!";
    }else{
        document.getElementById('ts').innerHTML="两次密码不一致!";
    }
    }
</script>
<body style="background-color: #e9ebef">
<div class="headiv">
    <div class="logotag">
        <a class="logo"><img src="../img/newlogo.png" width="440" height="65"></a>
        <b class="line"></b>
    </div>
    <a class="username">欢迎注册</a>
    <div class="clear" style="height:20px; background:#5b7ec3"></div>
</div>
<h1 style="color:black;position: absolute;top:200px;left:600px;">用户注册</h1>
<div style="position: absolute; top:250px; left:500px;">
    <form action="user.do" style="color: black">
        <table>
            <tr>
                <td class="td1">用戶名：</td>
                <td class="td1"><input class="input1" type="text"/></td>
            </tr>
            <tr>
                <td class="td1">密码：</td>
                <td class="td1"><input type="password" class="input1" name="textfield2" id="textfield2" onkeyup="compare();"/></td>
            </tr>
            <tr>
                <td class="td1">确认密码：</td>
                <td class="td1"><input type="password" class="input1" name="textfield3" id="textfield3" onkeyup="compare();" /></td>
                <td><div id="ts"></div></td>
            </tr>
            <tr>
                <td class="td1">姓名：</td>
                <td class="td1"><input class="input1" type="text"/></td>
            </tr>
            <tr>
                <td class="td1">年龄：</td>
                <td class="td1"><input class="input1" type="text"/></td>
            </tr>
            <tr>
                <td class="td1">性别：</td>
                <td><label style="font-size: 30px;">女<input name="sex" type="radio"></label>&nbsp;&nbsp;
                    <label style="font-size: 30px;">男<input name="sex" type="radio"></label></td>
                <td><p class="wrrong">*此处不能为空</p></td>
            </tr>
            <tr>
                <td></td>
                <td><a href="login.jsp"><input type="button" style="background-color: white; width:100px;height: 30px;" value="确定" /></a><td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
<script>
	$(".Fstage>li").click(function(){
		if($(this).children("ul").hasClass("Tstage"))
		$(this).siblings("li").children("ul").hide();
		$(this).children("ul").slideDown();
	});
</script>
