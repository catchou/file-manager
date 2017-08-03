<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>登录界面</title>
<link href="img/all.css" type="text/css" rel="stylesheet" media="all" />
<!--[if ie]>
    <link rel="stylesheet" type="text/css" href="../css/index_ie.css" media="all"/><![endif]-->
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
    <!--滑动功能实现失败，被图片覆盖-->
    <script>
        $(document).ready(function () {
            $("#register").click(function ( ){
                $("#registerpart").toggle("slow");
            })
        })
    </script>
</head>
<body>
<header>
<div class="head">
    <div class="wrapper">
        <div class="logo"><!--这里插入Img标签大小188*60px--></div>
        <div class="menu">
            <a href="WEB-INF/jsp/Manager_user.jsp" id="menu1">DSZ文档管理系统</a>
            <span>|</span>
        </div>
    </div>
</div>
</header>

<!--登录窗口-->
<div class="banner_area" id="banner_list">
  	<div class="main_box">
    	<div class="main_cont">
        	<div class="wrapper">
                <form action="/user/login" method="post">
            <dl class="xl_info clearfix">
                <dt class="hide" style="color: green">登录</dt>
                <dd><input type="text" class="srh" id="username" name="username"></dd>
                <dd><input type="password" class="srh" id="password" name="password"></dd>
                <dd><input class="button blue radius4 shenqing" type="submit" value="登录" />
                    <a href="/jsp/Manage_register.jsp"><input id="register" class="button blue radius4 lj" type="button" value="注册" /></a></dd>
            </dl>
                </form>
    		</div>
            <div class="bg"></div>
		</div>
    </div>
    <!--滑动注册窗口-->
    <div id="registerpart" style="display:none;z-index: 9999;position:absolute;top:400px;left: 700px;">
        <form action="user.do">
            <table border="1">
                <tr>
                    <td>用戶名</td>
                    <td><input type="text"/></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="text"/></td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td><input type="text"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><a href="login.jsp"><input type="button" style="background-color: white; width:100px;height: 30px;" value="确定" /></a><td>
                </tr>
            </table>
        </form>
    </div>
    <!--图片轮转-->
  	<div class="banner_box banner_ui on on_delay">
    	<div class="banner_cont">
        	<div class="area">
                <p class="ban1_anim_txt">精心打造，简而未减</p>
                <div class="ban1_anim_bg"></div>
            </div>
        </div>
    </div>
    <div class="banner_box banner_logo">
    	<div class="banner_cont">
        	<div class="area">
                <p class="ban2_anim_txt">动态皮肤，随心随身</p>
                <div class="ban2_anim_bg_logo"></div>
                <div class="ban2_anim_bg_line"></div>
                <div class="ban2_icon_1"><span></span></div>
                <div class="ban2_icon_2"><span class="s1"></span><span class="s2"></span></div>
                <div class="ban2_icon_3"><span></span></div>
            </div>
        </div>
    </div>
    <div class="banner_box banner_lighting">
    	<div class="banner_cont">
        	<div class="area">
            	<div class="ban3_act_bg"></div>
                <div class="ban3_mask"></div>
                <p class="ban3_anim_txt png">极速体验，快如闪电</p>
                <div class="ban3_anim_bg_lightning"></div>
                <div class="ban3_anim_bg_boom"></div>
                <div class="ban3_anim_bg_boom_icon_l"></div>
                <div class="ban3_anim_bg_boom_icon_r"></div>
            </div>
        </div>
    </div>
  </div>
 <div class="status" id="status">
  	<span class="on"></span>
    <span></span>
    <span></span>
  </div>
	<!--------------------------------------分割线-------------------------------------->
  </div>
<script src="js/all.js"  type="text/javascript"></script>
</body>
</html>
