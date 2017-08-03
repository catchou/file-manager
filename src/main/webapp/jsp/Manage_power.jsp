<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DSZ文档管理系统</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script src="js/city-picker.data.js"></script>
<script src="js/city-picker.js"></script>
<script src="js/date.js"></script>

</head>
<span style="background:#5b7ec3">
<div class="headiv">
	<div class="logotag">
        <a class="logo"><img src="../img/newlogo.png" width="440" height="65"></a>
        <b class="line"></b>
    </div>
    <a class="username">欢迎登录：<i>admin</i></a>
    <div class="clear" style="height:20px; background:#5b7ec3"></div>
</div>
<a href="login.jsp" style="position: absolute;left: 730px;top:50px;"><button class="logout">注销</button></a>
<div class="messagebox">
    <div class="messageleft">
        <ul class="Fstage">
            <li><a href="#"><em class="e1"></em>我的文档
                <div class="clear"></div>
            </a>
                <ul class="Tstage">
                    <li><a href="Manage_note.jsp">心得笔记</a></li>
                    <li><a href="Manage_report.jsp">实验报告</a></li>
                    <li><a href="Manage_jotting.jsp">生活随笔</a></li>
                </ul>
            </li>
            <li><a href="#"><em class="e2"></em>账号管理<div class="clear"></div></a>
                <ul class="Tstage">
                    <li><a href="Manage_account.jsp">个人信息</a></li>
                    <li><a href="Manage_group.jsp">#小组</a></li>
                </ul>
            </li>
            <li><a href="#"><em class="e3"></em>其他<div class="clear"></div></a>
                <ul class="Tstage">
                    <li><a href="Manage_power.jsp">权限管理</a></li>
                    <li><a href="Manage_security.jsp">安全设置</a></li>
                    <li><a href="#">日志浏览</a></li>
                </ul>
            </li>

        </ul>
    </div>
    <div class="messageright">
    	<div class="formpage">
        	<div class="clear" style="height:20px"></div>
        	<h2>权限管理</h2>
            <div class="clear" style="height:30px"></div>
            <span class="information">
            	<div class="clear" style="height:10px"></div>
            	<form action="user.do" style="color: black;">
        <table>
            <tr>
                <td>允许错误次数</td>
                <td><input type="text"/></td>
                <td>请输入数字1-100&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
            </tr>
            <tr>
                <td>用户锁定时间（分钟）</td>
                <td><input type="text"/></td>
                <td>请输入数字1-60&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
            </tr>
            <tr>
                <td>错误间隔时间（分钟）</td>
                <td><input type="text"/></td>
                <td>请输入数字1-60&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
            </tr>
            <tr>
                <td>系统在线最大用户数</td>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <td>前N个口令不重复次数</td>
                <td>
                    <select>
                        <option value ="10">10</option>
                        <option value ="11">11</option>
                        <option value ="12">12</option>
                        <option value ="13">13</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>普通用户口令有效期（天）</td>
                <td><input type="text"/></td>
                <td>最大90天，请输入1-90，默认90天</td>
            </tr>
            <tr>
                <td>口令到期提前通知天数（天）</td>
                <td><input type="text"/></td>
                <td>最大7天，请输入1-7，默认7天</td>
            </tr>
            <tr>
                <td></td>
                <td colspan="2"><a class="greenbtn" href="#">确定</a></td>
            </tr>
        </table>
          </form>
                <div class="clear"></div>
            </span>
<div class="clear" style="height:50px"></div>
</div>
<div class="clearh" style="height:0"></div>
    </div>
</div>
</span>
</body>
</html>
<script>
function callback() {
		$('body').append('<div id="mask"></div>');
		$('#mask').fadeIn();
		$('.popbox').css('display', 'block');
	}
function addclose() {
	$('#mask').fadeOut();
	$('.popbox').css('display', 'none');
}
</script>
