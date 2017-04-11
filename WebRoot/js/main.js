//转盘动画
var dialAnimate = {
    wrap:$("#dial-main"),
    item:$(".dial-item",this.wrap),
    animateTime:null,
    minTime:5,
    currTime:0,
    currTimer:null,
    selectId:null,
    getAnimateTimer:null,
    isShow:false,
    p1:0,
    p2:0,
    p3:0,
    n1:null,
    n2:null,
    n3:null,
    c1:null,
    c2:null,
    c3:null,
    pid1:null,
    pid2:null,
    pid3:null,
    pid:null,
	c:null,
    last:0,
    animateOpt :{
        len : $(".dial-item",this.wrap).length,
        random:null,
        newSrc:null,
        oldSrc:null,
        sel:null,
        animateDelay:500
    },
    getAnimateTime:function(){
        dialAnimate.getAnimateTimer = setInterval(function(){
            if(dialAnimate.minTime > 0){
                dialAnimate.minTime-=0.5;
            }else if(dialAnimate.getAnimateTimer){
                clearInterval(dialAnimate.getAnimateTimer);
				
            }
        },500);
    },
    animate:function(){
    	
        var oldTime = dialAnimate.animateOpt.animateDelay;
        //2 6 9 
        if(dialAnimate.minTime > 0.5)
        	dialAnimate.animateOpt.random = Math.floor(Math.random()*dialAnimate.animateOpt.len);
        else
            dialAnimate.animateOpt.random = Myrandom(dialAnimate.p1,dialAnimate.p2,dialAnimate.p3);
           
        dialAnimate.animateOpt.sel = $("> img",dialAnimate.item.eq( dialAnimate.animateOpt.random - 1));
            dialAnimate.animateOpt.oldSrc = dialAnimate.animateOpt.sel.attr("src");
            dialAnimate.animateOpt.newSrc = dialAnimate.animateOpt.oldSrc.replace("normal","active");
            dialAnimate.item.each(function(){
                var _img = $("> img",this);
                if(_img.hasClass("active")){
                    $(_img.removeClass("active").attr("src",_img.attr("src").replace("active","normal")));
                }
            });
            dialAnimate.animateOpt.sel.addClass("active").attr("src",dialAnimate.animateOpt.newSrc);
        if(dialAnimate.minTime >= 1.5){
            if(Math.round(dialAnimate.animateOpt.animateDelay) > 100){
                dialAnimate.animateOpt.animateDelay = Math.floor(dialAnimate.animateOpt.animateDelay - (oldTime * 0.2));
            }
        }else{
            if(Math.round(dialAnimate.animateOpt.animateDelay) <= 500){
                dialAnimate.animateOpt.animateDelay = Math.floor(dialAnimate.animateOpt.animateDelay + (oldTime * 0.2));
            }
        }

	   if(dialAnimate.minTime > 0){
			dialAnimate.animateTime = setTimeout(dialAnimate.animate,Math.round(dialAnimate.animateOpt.animateDelay));
	   }else{
		   clearInterval(dialAnimate.animateTime);
		   dialAnimate.wrap.removeClass("dial-animate");
		   $("#chance-num").text(parseFloat($("#chance-num").text())-1);
		   dialAnimate.last = dialAnimate.animateOpt.random;
		   dialAnimate.prizeData();
		   insertPrize();
		   $.prizeShow();
		   
		   
	   }
    },
    
    
    prizeData:function(){

		if(dialAnimate.last == 2){
			dialAnimate.pid = dialAnimate.pid1;
			dialAnimate.c = dialAnimate.c1;
		}
		if(dialAnimate.last == 6){
			dialAnimate.pid = dialAnimate.pid2;
			dialAnimate.c = dialAnimate.c2;
		}
		
		if(dialAnimate.last == 9){
			dialAnimate.pid = dialAnimate.pid3;
			dialAnimate.c = dialAnimate.c3;
		}
    },
    
    show:function(speed,p1,p2,p3,n1,n2,n3,c1,c2,c3,pid1,pid2,pid3){
		if(dialAnimate.wrap.hasClass("dial-animate")) return;
		dialAnimate.n1 = n1;
		dialAnimate.n2 = n2;
		dialAnimate.n3 = n3;
		dialAnimate.p1 = p1;
		dialAnimate.p2 = p2;
		dialAnimate.p3 = p3;
		dialAnimate.c1 = c1;
		dialAnimate.c2 = c2;
		dialAnimate.c3 = c3;
		dialAnimate.pid1 = pid1;
		dialAnimate.pid2 = pid2;
		dialAnimate.pid3 = pid3;
        dialAnimate.wrap.addClass("dial-animate");
        dialAnimate.animateOpt.animateDelay = speed;
		dialAnimate.minTime = 5;
        dialAnimate.animate(p1,p2,p3,n1,n2,n3);
        dialAnimate.getAnimateTime();
        dialAnimate.isShow = true;
    },
    clear:function(){
        if(!dialAnimate.isShow) return;
        $("img.active",dialAnimate.wrap).attr("src",$("img.active",dialAnimate.wrap).attr("src").replace("active","normal"));
        dialAnimate.wrap.removeClass("dial-animate");
        if(dialAnimate.animateTime){
            clearTimeout(dialAnimate.animateTime);
        }
        dialAnimate.isShow = false;
    },
    select:function(opt,callback,callbackDelay){
        if(opt.id && dialAnimate.isShow){
            function selectDelay(){
                var chanceNum,
                    selectDelayTimer,
                    _callbackDelay = callbackDelay;
                dialAnimate.selectId = $("*[data-dial-id="+ opt.id+"]");
                if(dialAnimate.animateTime){
                    clearTimeout(dialAnimate.animateTime);
                }
                dialAnimate.wrap.removeClass("dial-animate");
                if($(opt.chanceNum).length){
                    chanceNum = parseFloat($(opt.chanceNum).text());
                    if(chanceNum > 1){
                        $(opt.chanceNum).text(chanceNum - 1);
                    }else{
                        $("#dial-inner").addClass("share-qrcode-show");
                        $("#dial-main").addClass("dial-animate");
                    }
                }
                setTimeout(function(){
                    if($("img.active",dialAnimate.wrap).length){
                        $("img.active",dialAnimate.wrap).attr("src",$("img.active",dialAnimate.wrap).attr("src").replace("active","normal"));
                    }
                    $("> img",dialAnimate.selectId).addClass("active").attr("src",$("> img",dialAnimate.selectId).attr("src").replace("normal","active"));
                    if(callback){
                        if(_callbackDelay == undefined){
                            _callbackDelay = 1200;
                        }
                        if(selectDelayTimer){
                            clearTimeout(selectDelayTimer);
                        }
                        selectDelayTimer = setTimeout(callback,_callbackDelay);
                    }
                },400);
                dialAnimate.isShow = false;
            }
            if(dialAnimate.minTime <= 5){
                if(dialAnimate.getAnimateTimer){
                    var minTimeTmp = dialAnimate.minTime;
                    setTimeout(function(){
                        selectDelay();
                        clearInterval(dialAnimate.getAnimateTimer);
                    },minTimeTmp*1000);
                }
            }else{
                selectDelay();
            }
        }
    }
};
function showDesc(e,obj,fixed){
    if(arguments.length < 2){
        console.log("showDesc parameter error!");
        return;
    }
    var $obj = $(obj),
        btn = $(e);
    if($obj.length > 0 && !$obj.is(":animated")){
        $obj.slideToggle(200,function(){
            if(fixed){
                heightFixed('#flow-list');
            }
            $("body").animate({scrollTop:document.body.clientHeight - (document.body.clientHeight - $(".bottom-link").offset().top - $(".bottom-link").outerHeight())},200);
        });
        if(btn.length){
            btn.toggleClass("open-status");
        }
    }
}
function screenFixed(obj) {
    var $obj = $(obj);
    if ($obj.length > 0) {
        var sH = document.body.clientHeight,
            pH = $obj.outerHeight(true),
            pSize,
            overH;
        if (pH > sH) {
            overH = pH - sH;
            if (overH < 80) {
                pSize = 3;
                do {
                    $obj.css("padding", "0 " + (parseFloat($obj.css("padding-left")) + pSize) + "px");
                    $(".notify-wrap").css("margin","0 " + (-parseFloat($obj.css("padding-left"))) +"px 0.6rem");
                }
                while (($obj.outerHeight(true) - sH > 0));
            }

        }
    }
}
function loadImage(url, callback) {
    var img = new Image();
    img.src = url;
    if(img.complete) {
        callback.call(img);
        return;
    }
    $(img).load(function (a) {
        callback.call(img);
    });
}

function heightFixed(obj,scrollBottom){
    var screenH = document.body.clientHeight,
        fixedTotal = 0,
        fixedItem = $(".height-fixed");
    if(fixedItem.length > 0){
        fixedItem.each(function(i,e){
            if($(e).is(":visible")){
                fixedTotal += $(e).outerHeight(true);
            }
        });
        if($(obj).length){
            $(obj).addClass("overflow-auto").css("height",screenH - fixedTotal);
        }
    }
    if(scrollBottom && ($(obj).height() < $(".scroll-content",$(obj)).outerHeight(true))){
        $(obj).animate({scrollTop:$(".scroll-content",$(obj)).outerHeight(true) - $(obj).height()},200)
    }
}
function getCode(e){
    var _this = $(e),
        txt = _this.html(),
        timer,
        t = 60;
    if(!_this.hasClass("disabled")){
        _this.addClass("disabled");
        _this.html("60秒后获取");
        timer = setInterval(function(){
            if(!_this.hasClass("disabled")){
                _this.html(txt);
                clearInterval(timer);
                return;
            }
            t--;
            if(t > 0){
                if(t < 10){
                    _this.html("0"+ t + "秒后获取");
                }else{
                    _this.html(t + "秒后获取");
                }
            }else{
                _this.html(txt).removeClass("disabled");
                clearInterval(timer);
            }
        },1000)
    }
}

!function($){
    $.fn.extend({
        notifyAnimate:function(opts){
            var _this = $(this),
                defaultOpt = {
                    items:"li",
                    speed:3500,
                    url:""
                },
                option,
                i = 1;
            option = $.extend(defaultOpt,opts);
            if(option.url != ""){
                $.ajax({
                    url:option.url,
                    async:false,
                    success:function(result){
                        var items = result.toString().split("\n");
                        _this.empty();
                        $.each(items,function(i,e){
                            if(e.length > 1){
                                _this.append("<li>"+e.trim()+"</li>");
                            }
                        });
                    }
                });
            }
            if(!$(option.items,_this).length) return;
            $(option.items,_this).eq(0).clone().appendTo(_this);
            var _animate = function(){
                var _items = $(option.items,_this),
                    itemH = _items.eq(0).outerHeight(true);
                    if(i < _items.length){
                        _this.stop(true).animate({top:parseFloat(_this.css("top"))-itemH},200);
                        i++;
                    }else{
                        _this.css("top",0);
                        i=2;
                        _this.stop(true).animate({top:-itemH},200);
                    }

            };
            setInterval(_animate,option.speed);
        }
    });
    $.jqAlert = function(opts){
        var _this = $.jqAlert,
            option,
            modal = $("<div class='alert-modal'></div>"),
            wrap,
            header,
            closeBtn,
            bottomBtn,
            center,
            footer,
            ad;
        _this.defaults = {
            title:"提示",
            content:"暂无内容~",
            buttons:[],
            appendTo:"body",
            animateTime:180
        };
        option = $.extend($.jqAlert.defaults,opts);
        _this._create = function(){
            wrap = $("<div class='alert-wrap'></div>");
            closeBtn = $("<span class='close-btn'></span>");
            header = $("<div class='header'><span class='title'>"+ option.title +"</span></div>");
            center = $("<div class='center'>"+ option.content +"</div>");
            footer = $("<div class='footer'></div>");
            closeBtn.on("click",function(){
                _this.close();
            }).appendTo(header);
            modal.empty().append(wrap.append(header).append(center));
            if(option.buttons.length){
                var btns = option.buttons,
                    arrThis;
                $.each(btns,function(i,e){
                    arrThis = e;
                    $.each(arrThis,function(j){
                        bottomBtn = $("<div class='footer-button default-btn'>"+ j +"</div>");
                        bottomBtn.on("click",arrThis[j]);
                        footer.append(bottomBtn);
                    });
                });
                wrap.append(footer);
            }
            if(option.adSrc && option.adSrc!=""){
                ad = $("<div class='ad-wrap'><div class='dot-line'><span class='dot'></span></div><a href='"+ option.adUrl +"'><img src='"+ option.adSrc +"'/></a></div>");
                wrap.append(ad);
            }
        };
        _this._isShow = function(){
            return $("body").find(".alert-modal").length > 0;
        };
        _this.show = function(){
            if(_this._isShow()){
                $(".alert-modal").remove();
            }
            _this._create();
            var _wrap = $(".alert-wrap",modal);
            _wrap.hide();
            modal.hide().appendTo($(option.appendTo)).stop(true).fadeIn(option.animateTime,function(){
                _wrap.stop(true).show(option.animateTime);
            });

        };
        _this.close = function(){
            if(_this._isShow()){
                var _modal = $(".alert-modal"),
                    _wrap = $(".alert-wrap",_modal);
                _wrap.stop(true).hide(option.animateTime,function(){
                    _modal.stop(true).fadeOut(option.animateTime,function(){
                        _modal.remove()
                    });
                });
            }
        };
        _this.show();
    };
    $.loading = function(){
        if($(".loading-modal").is(":visible")) return;
        var _this = $.loading,
            modal = $("<div class='loading-modal'></div>"),
            wrap = $("<div class='loading-wrap'></div>"),
            src = "../images/loading-img",
            tip = "加载中",
            text = $("<p>"+ tip +"</p>"),
            n = 1,
            j = 1,
            timer,
            speed = 350;
        _this.show = function(){
            if(n>2){
                n=1;
            }
            if(j>3){
                j=1;
                text.empty().text(tip);
            }
            j++;
            var img = $("<img src="+ src + (n++) +".gif />");
            $("body").append(modal.append(wrap.empty().append(img).append(text.append("."))));
        };
        _this.hide = function(){
            if(timer || modal){
                clearInterval(timer);
                modal.remove();
            }
        };
        _this.show();
        timer = setInterval(_this.show,speed);
    };





    $.login = function(){
        if($(".login").is(":visible")) return;
        var _this = $.login,
            modal = $("<div class='login'></div>"),
            wrap = $("<div class='prize-wrap'></div>"),
			desc = $("<span id='exit'>X </span><form  action ='login.do' method='post' class='login-action'> <div class='form-container'> <span id='login-title'>请先登录</span><br><input type='text' name='fname'  float= 'center'  placeholder='请输入办理该业务的号码' class='detail-input' /><div class='lname-container'><input type='text' name='lname' placeholder='输入短信验证码' class='detail-input' id='varcode' /> <button class='detail-input' >获取</button> </div><input type='submit' value='立即登录' name='submit' id='submit' class='detail-input'  ></div> </form>");
        modal.append(wrap.hide().append(desc)).appendTo($("body"));
        wrap.show(300);
		$("#exit").click(function(){
			modal.remove();
        });

        _this.hide = function(){
            modal.remove();
        }
    };	
	
    function getName(){
    	if(dialAnimate.last == 2){
    		return dialAnimate.n1;
    	}
    	if(dialAnimate.last == 6){
    		return dialAnimate.n2;
    	}
    	if(dialAnimate.last == 9){
    		return dialAnimate.n3;
    	} 	 
    }
	
    $.prizeShow = function(){
        if($(".prize-modal").is(":visible")) return;
        var _this = $.prizeShow,
            modal = $("<div class='prize-modal'></div>"),
            wrap = $("<div class='prize-wrap'></div>"),
			title = $("<div class='prize-title' >恭喜您获得"+getName()+"</div>"),
			desc = $("<div class='prize-detail' >1、购买商品时，购物券可抵购物券券面显示的现金价值</br>2、原则上每张购物券只能在指定商品使用，且不得与其他优惠方式同时使用</br>3、本券不得兑换现金不设找零</br>4、退货时，本券价值不予退还现金</div>"),
            btn = $("<div class='btn-out'><div class='prize-btn'>立即领奖</div></div>"),
			btn2 = $("<div class='btn2-out'><div class='prize-btn2'>继续抽奖</div></div>");
        modal.append(wrap.hide().append(title).append(desc).append(btn).append(btn2)).appendTo($("body"));
        wrap.show(300);
		$(".prize-btn").click(function(){
			
             window.location.href="http://"+window.location.host+"/turntable/detail-page.do?productid="+dialAnimate.pid+"&couponid="+dialAnimate.c;
        });

		$(".prize-btn2").click(function(){
			modal.remove();
        });
        _this.hide = function(){
            modal.remove();
        }
    };
	
	

    
    $.prizeDetailShow = function(obj){
        if($(".prize-detail-modal").is(":visible")) return;
        var _this = $.prizeDetailShow,
            modal = $("<div class='prize-detail-modal'></div>"),
            wrap = $("<div class='prize-main'></div>"),
            header ="<div class='prize-header'>"+ obj.title +"</div>",
            prizeImg = $("<a href='javascript:;'><img src='"+ obj.imgSrc +"' class='prize-img'/></a>"),
            btn = $("<div class='close-btn'></div>"),
            footer;
        prizeImg.on("click",function(){
            console.log("统计");
            window.location.href = obj.imgUrl;
        });
        modal.append(wrap.hide().append(btn).append(header).append(prizeImg)).appendTo($("body"));
        if(obj.linkText && obj.linkText != ""){
            footer = "<div class='prize-footer'><a href='javascript:;'>"+ obj.linkText +"</a></div>";
            wrap.append(footer);
            $(".prize-img",wrap).css("border-radius",0);
            if(obj.linkCallback){
                $(".prize-footer > a",wrap).off().on("click",eval("("+obj.linkCallback+")"));
            }
        }
        $("img",prizeImg).error(function(){
            console.log("读取奖品明细图片出错！");
            modal.remove();
        });
        loadImage(obj.imgSrc,function(){
            wrap.fadeIn(300);
        });
        btn.off().on("click",function(){
            _this.hide();
        });
        _this.hide = function(){
            modal.remove();
        }
    }
}(jQuery);


function Myrandom(p1,p2,p3){
	var v = "";
	var p1 = 10*p1;
	var p2 = 10*p2;
	var p3 = 10*p3;
	var n =  Math.floor(Math.random()*10);
	if(0<= n &&n < p1)
		 v = 2;
	 if(p1 <= n && n < p1+p2)
		 v = 6;
	 if(p1+p1 <= n &&n < p1 + p2 + p3)
		 v = 9;
	return v;
}

function sleep(d){
	  for(var t = Date.now();Date.now() - t <= d;);
}



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

	function insertPrize(){
		var xhr = ajaxFunction();
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200||xhr.status==304){
					var data = xhr.responseText;
				}
			}
		}
		xhr.open("GET","http://"+window.location.host+"/turntable/insertPrize.do?productid="+dialAnimate.pid+"&couponid="+dialAnimate.c,true);	
		xhr.send(null);
	}
	
//$.jqAlert({
//    title:"请赐下号码，<br>小移好知道奖品要给谁啊~"
//    //输入手机号码
//    //content:"<span class='input-title'>输入手机号:</span><span class='input-text-wrap'><input type='text' class='input-phone' placeholder='只限珠海移动用户哦!'/></span>"
//    //输入手机号码、获取验证码
//    ,content:"<p><span class='input-title'>输入手机号:</span><span class='input-text-wrap'><input type='text' class='input-phone' placeholder='只限珠海移动用户哦!'/></span></p><p><span class='input-title'>输入验证码:</span><span class='input-text-wrap'><input type='text' class='input-code' placeholder='验证码'/><span class='get-code-btn' onclick='getCode(this)'>获取验证码</span></span></p>"
//    //描述、获取验证码
//    //content:"<p>100M叠加包将采用XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</p><p><span class='input-text-wrap'><input type='text' class='input-code' placeholder='验证码'/><span class='get-code-btn' onclick='getCode(this)'>获取验证码</span></span></p>"
//    //大标题、描述
//    //content:"<h1>100M流量免费使用</h1><p>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</p>"
//    ,buttons:[{
//        "确定":function(){
//            $.jqAlert.close();
//        },
//        "取消":function(){
//            $.jqAlert.close();
//        }
//    }]
//});