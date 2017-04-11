<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	import="entity.MyPrize"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="yes" name="apple-touch-fullscreen">
    <meta content="telephone=no,email=no" name="format-detection">
    <meta name="App-Config" content="fullscreen=yes,useHistoryState=yes,transition=yes">
    <title>优惠券</title>
    <link rel="stylesheet" href="./css/myprize.css"/>
        <link rel="stylesheet" href="./css/normalize.css"/>
</head>
<body class="prize-detail-body">
	<div class="page-title">
			<span class="exit" onclick="login()"> < </span>
			<span class="title"> 优惠券 </span>
	</div>
	<div class ="prize-content">
		<c:if test="${not  empty myprize }">
			<c:forEach items="${myprize }" var="prize" >	
				<c:if test="${!prize.vali }">
					<div class="prize" onclick="pay(${prize.productid },${prize.couponid })">
						<div class="prize-text">
							<p class="p-name">${prize.couponDesc }</p>
							<p class="p-date">有效日期:${prize.valitime}</p>
						</div>				
						<div class="prize-peice">
							<p class="p-price">${prize.price }元</p>	
						</div>
					</div>
				</c:if>
				
				<c:if test="${prize.vali}">
					<div class="prize2" >
						<div class="prize-text">
							<p class="p-name2">${prize.couponDesc }</p>
							<p class="p-date2">有效日期:已过期</p>
						</div>				
						<div class="prize-peice">
							<p class="p-price">${prize.price }元</p>	
						</div>
					</div>
				</c:if>
				
				
				
			</c:forEach>
		</c:if>
		<c:if test="${empty myprize }">
			<div class="no-prize"><span class="words">还没有优惠券<br><br>赶紧抽奖吧！</span></div>
		</c:if>
	</div>
	
</body>

  <script type="text/javascript">
  	function login(){
  		var x = <%= session.getAttribute("login") %>;
			if(x==1 && window.location.href.indexOf("login.do", 0) == "-1"){
				window.location.href = "http://" +window.location.host+"/turntable/login.do";
		}
  	}
  function pay(productid,couponid){
 	 window.location.href="http://" + window.location.host +"/turntable/detail-page.do?productid="+ productid +"&couponid="+couponid;
  }
  </script>
</html>
