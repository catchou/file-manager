<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/1 0001
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>security</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script src="js/city-picker.data.js"></script>
    <script src="js/city-picker.js"></script>
</head>
<body style="background:#5b7ec3">
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
        <h2>安全配置</h2>
        <div class="clear" style="height:30px"></div>
            <span class="information">
        <div align="center">
            <form style="font-size: 16px">
                <table>
                    <tr>
                        <td align="right">允许错误次数</td>
                        <td><input name="errortime" size="40"></td>
                        <td>请输入数字1~100</td>
                    </tr>
                    <tr>
                        <td align="right">帐户锁定时间(分钟)</td>
                        <td><input name="locktime" size="40"></td>
                        <td>请输入数字1~60</td>
                    </tr>
                    <tr>
                        <td align="right">错误间隔时间</td>
                        <td><input name="intervaltime" size="40"></td>
                        <td>请输入数字1~60</td>
                    </tr>
                    <tr>
                        <td align="right">系统最大在线用户数</td>
                        <td><input name="maxonline" size="40"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td align="right">前N个口令不重复次数</td>
                        <td><select name="maxN">
                            <option value="15">15</option>
                            <option value="12" selected>12</option>
                            <option value="9">9</option>
                            <option value="6">6</option>
                        </select></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td align="right">普通用户口令有效期(天)</td>
                        <td><input name="validday" size="40" value="90"></td>
                        <td>最大90天，范围1~90，默认值90</td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;口令到期提前通知天数(天)</td>
                        <td><input name="noticeday" size="40" value="7"></td>
                        <td>最大7天，范围1~7天，默认值7</td>
                    </tr>
                    <tr>
                        <td colspan="3" align="center">
                            <button class="wordopration">确定</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
            <div class="clear"></div>
            </span>
            <div class="clear" style="height:50px"></div>
        </div>
        </div>
        <div class="clear" style="height:0"></div>
    </div>
</body>
</html>