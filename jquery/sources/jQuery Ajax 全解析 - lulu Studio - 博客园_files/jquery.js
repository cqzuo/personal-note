jQuery.fn.slideLeft = function(speed,callback){
	return this.animate({width: "hide"}, speed, callback);
}
jQuery.fn.slideRight = function(speed,callback){
	return this.animate({width: "show"}, speed, callback);
}

//博客园增加导航菜单
jQuery.fn.navExtend = function(SideBar){
	$(this).prepend('<a style="color:red;" id="hideSideBarButton" class="menu" href="javascript:HideSideBar();">[ - 隐藏侧边栏]&nbsp;&nbsp;</a>');
	HideSideBar = function(){
		$(SideBar).slideLeft("slow");
		$("#hideSideBarButton").attr("href","javascript:ShowSideBar();").html("<div class=\"luluTip\">点此显示侧边栏<div class=\"triangle\"></div></div>[ + 显示侧边栏]&nbsp;&nbsp;");
    $('#mytopmenu').css({ "margin-left": "20px" });
    $('#centercontent').css({ "padding-left": "20px" });
	}
	ShowSideBar = function(){
			$('#mytopmenu').css({ "margin-left": "260px" });
    	$('#centercontent').css({ "padding-left": "260px" });
			$(SideBar).slideRight("slow",function(){
			$("#hideSideBarButton").attr("href","javascript:HideSideBar();").html("[ - 隐藏侧边栏]&nbsp;&nbsp;");			
		});
	}
	//HideSideBar ();
}

//滚动新闻
jQuery.fn.extend({
        Scroll:function(opt,callback){
                //参数初始化
                if(!opt) var opt={};
                var _btnUp = $("#"+ opt.up);//Shawphy:向上按钮
                var _btnDown = $("#"+ opt.down);//Shawphy:向下按钮
                var timerID;
                var _this=this.eq(0).find("div:first");
                var lineH=_this.find("div:first").height(), //获取行高
                    line=opt.line?parseInt(opt.line,10):parseInt(this.height()/lineH,10), //每次滚动的行数，默认为一屏，即父容器高度
                    speed=opt.speed?parseInt(opt.speed,10):500, //卷动速度，数值越大，速度越慢（毫秒）
                    timer=opt.timer?parseInt(opt.timer,10):3000; //滚动的时间间隔（毫秒）
                if(line==0) line=1;
                var upHeight=0-line*lineH;
                //滚动函数
                var scrollUp=function(){
                        _btnUp.unbind("click",scrollUp); //Shawphy:取消向上按钮的函数绑定
                        _this.animate({
                                marginTop:upHeight
                        },speed,function(){
                                for(i=1;i<=line;i++){
                                        _this.find("div:first").appendTo(_this);
                                }
                                _this.css({marginTop:0});
                                _btnUp.bind("click",scrollUp); //Shawphy:绑定向上按钮的点击事件
                        });

                }
                //Shawphy:向下翻页函数
                var scrollDown=function(){
                        _btnDown.unbind("click",scrollDown);
                        for(i=1;i<=line;i++){
                                _this.find("div:last").show().prependTo(_this);
                        }
                        _this.css({marginTop:upHeight});
                        _this.animate({
                                marginTop:0
                        },speed,function(){
                                _btnDown.bind("click",scrollDown);
                        });
                }
               //Shawphy:自动播放
                var autoPlay = function(){
                        if(timer)timerID = window.setInterval(scrollUp,timer);
                };
                var autoStop = function(){
                        if(timer)window.clearInterval(timerID);
                };
                 //鼠标事件绑定
                _this.hover(autoStop,autoPlay).mouseout();
                _btnUp.css("cursor","pointer").click( scrollUp ).hover(autoStop,autoPlay);//Shawphy:向上向下鼠标事件绑定
                _btnDown.css("cursor","pointer").click( scrollDown ).hover(autoStop,autoPlay);

        }       
});