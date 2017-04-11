<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>支付页面</title>
<script src="./js/prefixfree.min.js"></script>
<link rel="stylesheet" href="./css/paycss.css"/>

</head>
<body>
		<div id="page-body">
			<div id="shop-name">${bill.shopName}</div>
			<form action="" method="post">
				<div class="title">支付信息确认</div><br>
				<div class="content-title">商品信息 </div><br>
				<div class="content-seesion">
					<label class="content-key"> 商品名称：</label><label class="content-value" id="conduct-name">${bill.conductName}</label><br><br>
					<label class="content-key"> 所属商家：</label><label class="content-value" id="conduct-provider">${bill.conductProvider}</label><br><br>
				</div>
				<br><br><br>
				
				<div  class="content-title">支付金额 </div ><br>
				<div class="content-seesion">
					<label class="content-key"> 商品原价：  </label><label class="content-value" id="price">${bill.price}元</label><br><br>
					<label class="content-key"> 优惠券减免：</label><label class="content-value" id="tip-price">-${bill.discount}元</label><br><br>
					<label class="content-key"> 需支付金额：</label><label class="content-value" id="payment">${bill.payment}元</label><br><br>
				</div>
				<br><br><br>
				
				
				<div  class="content-title">支付方式</div ><br>				
				  <div class="content-seesion">
						<div class="radio_container">
							<input type="radio" id=${p1.paywayName} value=${p1.paywayName} name="pay-way" checked="checked"/> <label style="cursor:pointer" for=${p1.paywayName}> <img name=${p1.paywayName} src = ${p1.imageUrl} ></img></label><br>
							<input type="radio" id=${p2.paywayName} value=${p2.paywayName} name="pay-way" /> <label style="cursor:pointer" for=${p2.paywayName}> <img name=${p2.paywayName} src = ${p2.imageUrl}></img></label><br>
						</div>
				  </div>
				
				
				<br><br><br><br><br><br>
				<input name="submit" type="button" class="submit-button" onclick=gotoFinish() value="确定订单"/>
				<br><br><br>
				
			</form>
			<label id="final-payment" style="display:none">${bill.payment}</label>
			<label id="company" style="display:none">${bill.conductProvider}</label>
			<label id="conduct" style="display:none">${bill.conductName}</label>
			
		</div>
	
	  <script src='./js/jquery.js'></script>
	  <script src="./js/index.js"></script>
	  
	  <script>

	  </script>
</body>
</html>