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
    <title>奖品详情页</title>
    <link rel="stylesheet" href="./css/normalize.css"/>
    <link rel="stylesheet" href="./css/main.css"/>
</head>
<body class="mb-body prize-detail-body">
<div class="page-main">
    <div class="top-bar">和商汇微店</div>
    <!--<div class="coupon-title">您领取了381元碧水源净水器（U408或D526）代金券一张</div>-->
    <div class="main-bar">
    <div class="coupon-title">${product.productDescription}</div>
    <div class="bottom-ad">
    
       <img onclick="weidian()"  class="prize-detail-src" src=${product.productImg} alt=""  />
    </div>
    </div>
<!--
	<div class="buttons-wrap">
        <a href="javascript:;" onclick="window.history.go(-1);return false;" class="button-item">继续抽奖</a>
        <a href="http://mp.weixin.qq.com/s?__biz=MjM5MDE4NjI2NQ==&mid=511739218&idx=1&sn=eda24b01732477fc6bc30c0f7739a146#rd" class="button-item">了解商品</a>
    </div>
    -->
	<!--添加输入框-->
      <form name="pform" action="payway.do" onsubmit="return validate_phoneNumber(this);"  method="get" class='form-action'>
          <div class="form-container">
              <input type="text" name="fname"  float= "center"  placeholder="请输入办理该业务的号码"  value="<%=session.getAttribute("phonenumber") %>" class="detail-input" />
             <div class="lname-container">
              <input type="text" name="lname" placeholder="输入短信验证码" class="detail-input" id="varcode"  />
              <input type="text" name="productid" value="${product.productId}" style="display:none;"/>
                <input type="text" name="couponid" value="${couponid}"style="display:none;"/>
              <button class="detail-input" >获取</button>
             </div>         
            <input type="submit" value="立即领取" name="submit" class="detail-input"  >
          </div>
     </form>
</div>

 <script type="text/javascript">
 function validate_phoneNumber(pform)  
                     {  
	                    var phoneValue = pform.fname.value;
                        if(phoneValue==""||!is_phoneNumber(phoneValue))  
                        {  
                            alert("仅中国移动用户才能领取此优惠！");  
                            return false;  
                       }
           
                     }; 
 function is_phoneNumber(str){
	 var reg= /^1(3[4-9]|5[012789]|8[78])\d{8}$/;
	 return reg.test(str);
 }
   
  function weidian(){
  	window.location.href = "http://" + window.location.host +"/turntable/shopdetail.do";
  }                  
                       
 </script> 
 
</body>
</html>
