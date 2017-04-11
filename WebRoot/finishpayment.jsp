<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
 	import="java.util.*"   
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<title>交易详情</title>
		<link rel="stylesheet" href="./css/paycss.css"/>

		<script src="./js/prefixfree.min.js"></script>
	</head>
	
	
	<body>
		<div id="page-body">
			<div id="shop-name">交易详情</div>
			<div>
				<img id="success" src="./image/weixinsuccess.jpg"/>
			</div>
			<div class="final-bill">
				<label type="text" class="provider"><%=request.getParameter("compay") %></label><br>
				<label type="text" class="final-payment"> ￥<%=request.getParameter("payment") %>元</label>
			</div>
			<div>
				<div class="content-seesion">
					<label class="content-key"> 商品  </label><label class="content-value" id="price"><%=request.getParameter("conduct") %></label><br><br>
					<label class="content-key"> 交易单号</label><label class="content-value" id="tip-price">624198121202608049802</label><br><br>
					<label class="content-key"> 成交时间</label><label class="content-value" id="payment"><%=(new Date()).toLocaleString() %></label><br><br>
				    <label class="content-key"> 当前状态</label><label class="content-value" id="payment">支付成功</label><br><br>
				</div>
			</div>
			<br><br><br><br>
			<input type="button" class="submit-button"  onclick="gotoTurntable()"value="完成"/>
		</div>
	
		  <script src='./js/jquery.js'></script>
		  <script src="./js/index.js"></script>
		  
	    <script>
	       function gotoTurntable(){
	    	   window.location.href="http://"+window.location.host+"/turntable/login.do";
	    	   
		   }
	    </script>
	</body>
</html>