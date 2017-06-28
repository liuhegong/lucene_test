<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <title>home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="ouym" />
    <script type="text/javascript">
        function joke(){
            alert("joke,这是假的百度首页!");
        }
    </script>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css">

</head>
<body>
<div class="content">
    <div id ="ul">
        <a class="mnav" href="http://www.nuomi.com/?cid=002540">糯米</a>
        <a class="mnav" href="http://news.baidu.com/">新闻</a>
        <a class="mnav" href="http://www.hao123.com">hao123</a>
        <a class="mnav" href="http://map.baidu.com">地图</a>
        <a class="mnav" href="http://v.baidu.com">视频</a>
        <a class="mnav" href="http://tieba.baidu.com">贴吧</a>
        <a class="mnav" href="">登录</a>
        <a class="mnav" href="">设置</a>
        <a class="mnav" id ="more" href="" style="background: #38f;color:#fff">更多产品</a>
    </div>
    <div class="logo">
        <img hidefocus="true" src="/resources/images/bd_logo1.png" height="129" width="270">
    </div>
    <div class="serch">
        <form action="/user/index" method="post">
            <input id="kw" name="wd" class="s_ipt" value="" maxlength="255" autocomplete="off"/>
            <input id="mysubmit" type="submit" value="百度一下"/>
        </form>
    </div>
    <div class = "footer">
        <a class="" href="javascript:;"  onclick="joke()">把百度设为主页</a>
        <a class="" href="http://home.baidu.com">关于百度</a>
        <a class="" href="http://ir.baidu.com">About Baidu</a>
        <a class="" href="http://e.baidu.com/?refer=888">百度推广</a>
        <p>@2016 Baidu
            <a href="http://www.oymit.top">使用百度前必读</a>
            <a href="http://www.oymit.top">意见反馈</a>
            京ICP证030173号
        </p>
    </div>

</div>
</body>

</html>