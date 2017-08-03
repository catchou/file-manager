<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>DSZ文档管理系统</title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css" />
    <script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
    <script src="../../js/city-picker.data.js"></script>
    <script src="../../js/city-picker.js"></script>

</head>

<body style="background:#5b7ec3">
<div class="headiv">
    <div class="logotag">
        <a class="logo"><img src="../../img/newlogo.png" width="440" height="65"></a>
        <b class="line"></b>
    </div>
    <a class="username">欢迎登录：<i>admin</i></a>
    <div class="clear" style="height:20px; background:#5b7ec3"></div>
</div>
<a href="../../login.jsp" style="position: absolute;left: 730px;top:50px;"><button class="logout">注销</button></a>
<div class="messagebox">
    <div class="messageleft">
        <ul class="Fstage">
            <li><a href="#"><em class="e1"></em>我的文档
                <div class="clear"></div>
            </a>
                <ul class="Tstage">
                    <li>
                        <form action="/show-files" method="post">
                            <input type="hidden" name="docLabel" value="note">
                            <input type="submit" value="心得体会">
                        </form>
                    </li>
                    <li>
                        <form action="/show-files" method="post">
                            <input type="hidden" name="docLabel" value="report">
                            <input type="submit" value="实验报告">
                        </form>
                    </li>
                    <li>
                        <form action="/show-files" method="post">
                            <input type="hidden" name="docLabel" value="jotting">
                            <input type="submit" value="生活随笔">
                        </form>
                    </li>
                </ul>
            </li>
            <li><a href="#"><em class="e2"></em>账号管理<div class="clear"></div></a>
                <ul class="Tstage">
                    <li><a href="../../Manage_userinfo.jsp">个人信息</a></li>
                    <li><a href="#">#小组</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="messageright">
            <div class="picbig">
                <img src="../../img/welcome.png">
            </div>
        <div class="clearh" style="height:0"></div>
</div>
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