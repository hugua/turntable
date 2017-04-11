<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <title>大转盘-首页</title>
    <link rel="stylesheet" href="./css/normalize.css"/>
    <link rel="stylesheet" href="./css/main.css"/>
</head>
<body class="mb-body index-body" onload="redirect()">

<br>
<div class="page-main" id="page-main">
    <div class="phone-number" id="phoneTxT">
    <% 
    String login =(String)session.getAttribute("login");
     if(login!=null&&login.equals("1")) 
     	out.print(session.getAttribute("phonenumber"));
   	else{
   		out.print("");
   		} 
   	%>
   	</div>
    <div class="header-btn-wrap">
        <a href="javascript:myPrize()" class="mine-prize-btn"><!--我的奖品-->
            <img src="./image/btn-mine-prize.png" alt=""/>
        </a>
        <a onclick="clearlogin()" class="flow-coin-btn"><!--流量币-->
            <img src="./image/btn-flow-coin.png" alt=""/>
        </a>
    </div>
    <!-- 大转盘 开始-->
    <div class="dial-wrap">
        <div class="dial-main" id="dial-main">
            <img class="dial-main-img" src="./image/dial-bg.png" alt=""/>
            <div class="dial-inner" id="dial-inner">
                <!--分享增加机会 开始-->
                <div class="share-qrcode">
                    <div class="plus-times">
                        <img src="./image/qrcode-tip-top.gif" alt="">
                    </div>
                    <div class="qrcode-wrap" id="qrcode-wrap">
                        <img src="./image/tmp-qrcode.jpg" alt="">
                    </div>
                    <div class="share-tips">
                        <img src="./image/qrcode-tip-bottom.gif" alt="">
                    </div>
                </div>
                <!--分享增加机会 结束-->
                <div class="dial-table">
                    <table cellpadding="0" cellspacing="0">
                        <tr>
                            <td class="dial-item" data-dial-id="1">
                                <img src="./image/square-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <p class="red-num">1G</p>
                                    <p class="color-purple">7天有效</p>
                                </div>
                            </td>
                            <td class="dial-item" data-dial-id="2"  data-obj="{title:'${product0.productName}',imgSrc:'${product0.productImg}',imgUrl:'#',linkText:'等不及了，立即抽奖',linkCallback:'function(){ modal.remove();}'}">
                                <img src="./image/square-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <img class="card" src=
	                                  <c:if test="${empty product0.customerImg}">
	                                     ./image/prize-img-2-160630.png
	                                  </c:if>
	                                  <c:if test="${!empty product0.customerImg}">
	                                     ${product0.customerImg}
	                                  </c:if>
                                    
                                    alt=""/>
                                </div>
                            </td>
                            <td class="dial-item" data-dial-id="3">
                                <img src="./image/square-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <p class="red-num">1G</p>
                                    <p class="color-purple">30天有效</p>
                                </div>
                            </td>
                            <td class="dial-item" data-dial-id="4">
                                <img src="./image/square-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <p class="color-purple only-text">还差<br>一点</p>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="dial-item" data-dial-id="5">
                                <img src="./image/rectangle-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <p class="red-num">福袋</p>
                                </div>
                            </td>
                            <td rowspan="2" colspan="2" style="vertical-align: bottom">
                                <!--Go 开始-->
                                <div class="has-draw-chance" id="has-draw-chance">
                                    <div class="go-tips">天天大转盘</div>
                                    <div class="img-wrap" id="btn-go">
                                        <img src="./image/btn-go.png" alt=""/>
                                        <p>今天有<i id="chance-num">
						 					<c:choose>
												<c:when test='${login == "1"}'>
													<% 
														if(session.getAttribute("time") != null){
															String x = (String)session.getAttribute("time") ;
															int n = Integer.parseInt(x);
															if(n > 0)
																out.print(n);
															else
																out.print("0");
														}else{
															out.print("0");
														}
													
													%>
												</c:when>
												<c:otherwise>
													5
												</c:otherwise>
											</c:choose>
                                        </i>次机会</p>
                                    </div>
                                </div>
                                <!--Go 结束-->
                            </td>
                            <td class="dial-item" data-dial-id="6" data-obj="{title:'${product1.productName}',imgSrc:'${product1.productImg}',imgUrl:'#',linkText:'等不及了，立即抽奖',linkCallback:'function(){ modal.remove();}'}">
                                <img src="./image/rectangle-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <img class="card" src=
	                                    <c:if test="${empty product1.customerImg}">
		                                     ./image/prize-img-2-160630.png
		                                  </c:if>
		                                  <c:if test="${!empty product1.customerImg}">
		                                     ${product1.customerImg}
		                                  </c:if>                                    
                                    alt=""/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="dial-item" data-dial-id="7">
                                <img src="./image/rectangle-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <p class="red-num">100M</p>
                                    <p class="color-purple">叠加包</p>
                                </div>
                            </td>
                            <td class="dial-item" data-dial-id="8">
                                <img src="./image/rectangle-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <p class="red-num">流量币</p>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="dial-item" data-dial-id="9"  data-obj="{title:'${product2.productName}',imgSrc:'${product2.productImg}',imgUrl:'#',linkText:'等不及了，立即抽奖',linkCallback:'function(){ modal.remove();}'}">
                                <img src="./image/square-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <img class="card" src=                        
                                         <c:if test="${empty product2.customerImg}">
		                                     ./image/prize-img-2-160630.png
		                                  </c:if>
		                                  <c:if test="${!empty product2.customerImg}">
		                                     ${product2.customerImg}
		                                  </c:if>   
                                    alt=""/>
                                </div>
                            </td>
                            <td class="dial-item" data-dial-id="10">
                                <img src="./image/square-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <p class="red-num">100M</p>
                                    <p class="color-purple">1小时有效</p>
                                </div>
                            </td>
                            <td class="dial-item" data-dial-id="11">
                                <img src="./image/square-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <p class="red-num">话费</p>
                                    <p class="color-purple">1元-100元</p>
                                </div>
                            </td>
                            <td class="dial-item" data-dial-id="12">
                                <img src="./image/square-normal.png" alt=""/>
                                <div class="prize-desc">
                                    <p class="red-num">300M</p>
                                    <p class="color-purple">叠加包</p>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- 大转盘 结束-->

    <!--公告栏 开始-->
    <div class="notify-wrap">
        <div class="role-tb">
            <div class="notify-title role-td width-fixed"></div>
            <div class="notify-desc role-td width-auto">
                <ul id="notify-ul">
                    <li>139xxxxxxxx获得100M 1小时有效</li>
                </ul>
            </div>
        </div>
    </div>
    <!--公告栏 结束-->

    <!--广告栏 开始-->
    <div class="ad-3-col">
        <div class="img-wrap">
            <a href="#">
                <img src="./image/index-ad7.png" alt=""/>
            </a>
        </div>
        <div class="img-wrap">
            <a href="#">
                <img src="./image/index-ad8.png" alt=""/>
            </a>
        </div>
        <div class="img-wrap">
            <a href="#">
                <img src="./image/index-ad9.png" alt=""/>
            </a>
        </div>
    </div>
    <!--广告栏 结束-->

    <!--底部按钮 开始-->
    <div class="bottom-link">
        <div class="link-left" onclick="showDesc(this,'#desc-content')">活动规则</div>
    </div>
    <!--底部按钮 结束-->
</div>
<!--活动规则 开始-->
<div class="rule-desc" id="desc-content" style="display: none">客户XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</div>
<!--活动规则 结束-->
<script src="./js/jquery-1.11.1.min.js"></script>
<script src="./js/main.js"></script>
<script>
    $(function(){
    	var login = <%= session.getAttribute("login") %>;
		$("#btn-go").click(function(){
			if(parseFloat($("#chance-num").text()) <= 0){
				$("#dial-inner").addClass("share-qrcode-show");
				$("#dial-main").addClass("dial-animate");
		}else if(login != 1){
				$.login();
				}else{
				//p是产品的概率，n是产品名称，pid是产品id,c是券id
				    var p1 = "${product0.productProblity}";
			    	var p2 = "${product1.productProblity}";
			    	var p3 = "${product2.productProblity}";
			    	var n1 = "${product0.couponDesc}";
			    	var n2 = "${product1.couponDesc}";
			    	var n3 = "${product2.couponDesc}";
			    	var c1 ="${product0.couponId}";
			    	var c2 ="${product1.couponId}";
			    	var c3 ="${product2.couponId}";
			    	var pid1 = "${product0.productId}";
			    	var pid2 = "${product1.productId}";
			    	var pid3 = "${product2.productId}";
			    	valiateTimes();
					dialAnimate.show(500,p1,p2,p3,n1,n2,n3,c1,c2,c3,pid1,pid2,pid3);
				}

        });
        var imgI = 0;
        $("img:visible").each(function(i,e){
            loadImage($(e).attr("src"),function(){
                imgI++;
                if($("img:visible").length == imgI){
                    screenFixed("#page-main");
                }
            });
        });
        setTimeout(function(){
            screenFixed("#page-main");
        },1000);
        
        $("#notify-ul").notifyAnimate({
            speed:2000,
            item:"li",
            url:"./js/notify-list.txt"
        });
        
        $(".dial-item",$("#dial-main")).on("click",function(){
            var _this = $(this);
            if(_this[0].hasAttribute("data-obj") && _this.attr("data-obj")!="" && $("#phoneTxT").html() != ""){
                var obj = eval("(" + _this.attr("data-obj") + ")");
                if(typeof obj == 'object'){
                    $.prizeDetailShow(obj);
                }else{
                    console.log('data-obj的值不是JSON对象');
                }
            }
        });
    });


	function ajaxFunction(){
	   var xmlHttp;
	   try{ // Firefox, Opera 8.0+, Safari
	        xmlHttp=new XMLHttpRequest();
	    }
	    catch (e){
		   try{// Internet Explorer
		         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		      }
		    catch (e){
		      try{
		         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }
		      catch (e){}
		      }
	    }
		return xmlHttp;
	 }
	function valiateTimes(){
		var xhr = ajaxFunction();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200||xhr.status==304){
					var data = xhr.responseText;
					alert(data);
				}
			}
		}
		var phone = $("#phoneTxT").html();
		xhr.open("GET","http://"+window.location.host+"/turntable/time.do?phonenumber="+phone,true);
		xhr.send(null);		
		
	}
	
	function clearlogin(){
		window.location.href = "http://"+window.location.host+"/turntable/login.do?clear=1";
	}
	
	function redirect(){
		var tip = <%= session.getAttribute("tip") %>;
		if(tip=="1")
			alert("账号不存在");
	
		var x = <%= session.getAttribute("login") %>;
		if(x==1 && window.location.href.indexOf("login.do", 0) == "-1"){
			window.location.href = "http://" +window.location.host+"/turntable/login.do";
		}
		
	}
	
	function myPrize(){
		var x = <%= session.getAttribute("login") %>;
		if(x == 1){
			window.location.href="http://" +window.location.host+"/turntable/myPrize.do";
		}
	}
</script>
</body>
</html>
