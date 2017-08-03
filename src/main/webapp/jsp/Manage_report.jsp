<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/1 0001
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>report</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script src="js/city-picker.data.js"></script>
    <script src="js/city-picker.js"></script>
    <script src="js/date.js"></script>
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
        <h2>实验报告</h2>
        <div class="clear" style="height:30px"></div>
        <input type="text" id="search" name="search" class="textbox searchtext" size="40"
               placeholder="在此输入搜索内容">
        &nbsp;&nbsp;&nbsp;&nbsp;<button id="searchbutton" onclick="findIt();"><img src="img/search_icon.png">
    </button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" class="file">文档导入
            <input type="file" name=""></a>
        &nbsp;&nbsp;&nbsp;&nbsp;
            <label class="delete">文档删除</label><br><br>
        <div align="center" style="align-content: center; font-size: 13px">
            <form style="width: 100%">
                <table border="0px">
                    <tr style="width:100%; background-color: #b5b5b5; color: #ffffff">
                        <td width=20px align="center"><input type="checkbox"></td>
                        <td class="unit"><nobr>文档名称</nobr></td>
                        <td class="unit"><nobr>创建时间</nobr></td>
                        <td class="unit"><nobr>修改时间</nobr></td>
                        <td class="unit"><nobr>文档操作</nobr></td>
                    </tr>
                    <c:forEach items="${requestScope.wordinfo}" var="wordinfo" varStatus="status">
                        <tr style="width:100%; background-color: #ededed; color: #666666">
                            <td width=20px  align="center"><input type="checkbox"></td>
                            <td class="unit" height="20px">${wordinfo.name}</td>
                            <td class="unit">${wordinfo.createT}</td>
                            <td class="unit">${wordinfo.modifyT}</td>
                            <td class="unit">
                                <a href="#">查看</a>
                                <a href="#">编辑</a>
                                <a href="#">导出</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
            <div class="clear"></div>
            <div class="clear" style="height:50px"></div>
        </div>
        </div>
        <div class="clearh" style="height:0"></div>
    </div>
</body>
</html>
