<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="yes" name="apple-touch-fullscreen">
    <meta content="telephone=no,email=no" name="format-detection">
    <meta name="App-Config" content="fullscreen=yes,useHistoryState=yes,transition=yes">
    <title>欢迎光临和商汇微店</title>
    <link rel="stylesheet" href="./css/normalize.css"/>

    <link rel="stylesheet" href="./css/shopdetail.css"/>
</head>
<body class="mb-body prize-detail-body">
<div class="page-main">
    <div class="top-bar">欢迎光临和商汇</div>
      <img id="shopdetailImg" alt="" src="./image/shopdetail.png"/>
         <div class="button">
         
            <p class="blank-text"> &nbsp; </p>
        	 <p class="back-text" onclick="location.href='javascript:history.go(-1);'">返回</p>
        	 
        	  <p class="blank-text"> &nbsp; </p>
             <p class="focus-text" onclick="showfans()">关注</p>
             <p class="blank-text"> &nbsp; </p>
          </div>
</div>
<script type="text/javascript">
    function showfans(){
    	alert("感谢您的关注。");
    }
</script>
</body>
</html>

