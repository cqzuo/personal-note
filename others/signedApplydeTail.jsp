<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<html>
  <head>
  	<!-- 
  		1.页面路径:/page/signed/signedApplyList.jsp
  		2.页面作用:签约管理明细
  		3.Action来源:signedApplyAction
  		4.提交按钮路径:
  		5.保存按钮路径:
  		6.返回按钮路径:
  		7.其他:
  	 -->
    <title>签约管理明细</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/decg.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/htlib.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/script/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		 function submits(url){
		    form.action = url;
		    form.submit();
		 };
		 function addTr(obj){
			 var addTr = $("#"+obj);
			 addTr.before("<tr><td><input type='text' name=''></td><td><input type='text' name=''></td><td><input type='text' name=''></td><td><select name=''><option>请选择币种</option></select></td><td></td><td></td><td><input type='text' name='' onClick='WdatePicker()'></td><td><input type='text' name='' onClick='WdatePicker()'></td><td></td></tr>");
		 }
		 function delTr(obj){
			var lastTr = $("#tab"+obj+" tr:last-child").prev().prev();
			var length = $("#tab"+obj+" tr").length;
			if(5>length){
				alert("不能删除最后一个元素!");
				return false;
			}else{
				lastTr.remove();
			}
		 };
		 
		 $(document).ready(function() {
				//下拉列表框的块标记
				var autoNode = $("#abstractname");
				var wordInput = $("#name");
				//表示当前高亮的节点
				var highlightindex = -1;
				var timeoutId;
				//获取匹配元素在当前视口的相对偏移。
				//返回的对象包含两个整形属性：top 和 left。此方法只对可见元素有效。
				var wordInputOffset = wordInput.offset();
				autoNode.css("left",wordInputOffset.left);
				autoNode.css("top",wordInputOffset.top+25);
				autoNode.css("border-color","red");
				//自动补全框开始应该隐藏起来
				autoNode.css("width","200px").css("z-index","9").css("border","1px #5170A7 solid").css("position", "absolute").css("solid","#666666").css("background","#FFFFFF");
				autoNode.hide();
                                                                        wordInput.ondblclick(abstractname)
			});
		 function showabstarctName(obj) {
				document.getElementById("abstractname").style.cssText = "position: absolute; width: 200px; height: 100px; z-index: 1; left: 85px; top: 90px;border:1px solid #666666; border: 1;visibility:visible;";
				var wordInput = document.getElementById('name');
				var autoNode = document.getElementById('abstractname');
				gettable(wordInput);
				ht.ajax(
					function(value) {
						var div = ht.$('abstractname');
						div.innerHTML = value;
						if (trim(div.innerHTML) == "") {
							document.getElementById('abstractname').style.visibility = "hidden";
						}
					},
					'${pageContext.request.contextPath }/control/consulation/ConsulationAction_findabstractName.action'
							+ "&"
							+ new Date()
				);
			};
		 function abstractname(event) {
					var autoNode = $("#abstractname");
					var wordInput = $("#name");
					//autoNode.style.visibility = "visible";
					//处理文本框中的键盘事件
					//如果输入的是字母，应该将文本框中最新的信息发送给服务器
					var myEvent = event || window.event;
					var keyCode = myEvent.keyCode;
					//如果输入的是字母，应该将文本框中最新的信息发送给服务器
					//如果输入的是退格键或删除键，也应该将文本框中的最新信息发送给服务器a
					if ((keyCode >= 65 && keyCode <= 90) || keyCode == 8 || keyCode == 48 || keyCode ==13|| keyCode ==32){
						//1.首先获取文本框中的内容
						var wordText = wordInput.val().replace(/(^\s*)|(\s*$)/g, "");
						var params = {
							"projectView.likename":wordText
						};
						//如果内容不为空
						if (wordText != "") {
								$.ajax({
									type: "POST",
									url: "${pageContext.request.contextPath}/control/consulation/ConsulationAction_findabstractName.action",
									data: params,
									success: function(data){
									var nodes = data.split(",");
									//需要清空auto的内容
									autoNode.html("");
									//如果服务器有数据返回，则显示弹出框
									if(nodes.length>0){
											//遍历所有的word节点，取出单词内容，然后将单词内容添加到弹出框中
											for(i=0;i<nodes.length;i++){
											//获取单词内容
											var wordNode = nodes[i];
											//新建div节点，将单词内容加入到新建的节点中
											//将新建的节点加入到弹出框的节点中
											var newDivNode = $("<div>");
											newDivNode.html(wordNode).appendTo(autoNode);
											autoNode.show();
											//鼠标进入事件，高亮节点
											newDivNode.mouseover(function() {
												//记录新的高亮索引
												highlightindex = i;
												//鼠标进入的节点高亮
												$(this).css("background-color", "#CEE8F1");
												wordInput.val($(this).text().replace(/(^\s*)|(\s*$)/g, ""));
												autoValues();
											});
											//增加鼠标移出事件，取消当前节点的高亮
											newDivNode.mouseout(function() {
												//取消鼠标移出节点的高亮
												$(this).css("background-color", "white");
											});
										};
									} else {
										autoNode.hide();
									}
								}});
						} else {
							//autoNode.hide();
							//弹出框隐藏的同时，高亮节点索引值也置为-1
							highlightindex = -1;
						}
						} else if (keyCode == 38 || keyCode == 40) {
							// 如果输入的是向上38向下40按键
							if (keyCode == 38) {
								//向上
								var autoNodes = autoNode.children("div");
								if (highlightindex != -1) {
									//如果原来存在高亮节点，则将背景色改成白色
									autoNodes.eq(highlightindex).css("background-color", "white");
									highlightindex --;
								}
								if (highlightindex == -1) {
									//如果修改索引值以后index变成-1,则将索引值指向最后一个元素
									highlightindex = autoNodes.length -1;
								}
								//让现在高亮的内容变成红色
								autoNodes.eq(highlightindex).css("background-color", "#CEE8F1");
								wordInput.val(autoNodes.eq(highlightindex).text().replace(/(^\s*)|(\s*$)/g, ""));
									autoValues();
							} else {
								//向下
								var autoNodes = autoNode.children("div");
								if (highlightindex != -1) {
									//如果原来存在高亮节点，则将背景色改成白色
									autoNodes.eq(highlightindex).css("background-color", "white");
								}
								highlightindex ++;
								if (highlightindex == autoNodes.length) {
									//如果修改索引值以后index变成节点的长度,则将索引值指向第一个元素
									highlightindex = 0;
								}
								//让现在高亮的内容变成红色
								autoNodes.eq(highlightindex).css("background-color", "#CEE8F1");
								wordInput.val(autoNodes.eq(highlightindex).text().replace(/(^\s*)|(\s*$)/g, ""));
									autoValues();
							}
						} 
					}
                                        function hidden(){
				var autoNode = $('#abstractname');
				var kongjian = document.activeElement.id;
				if((kongjian != "enterprise.name")&&(kongjian != "abstractname") ) {
					autoNode.hide();
				}
			}
                                        
	</script> 
  </head>
  <body>
  	<div class="title1">签约管理明细</div>
  	<div>
  		<span><input type="button" value="返回" onClick=""></span>
  		<span><input type="button" value="确认" onClick=""></span>
  		<br>
  		<hr>
  	</div>
  	<!-- 签约审批单 -->
  	<jsp:include page="signApply.jsp"></jsp:include>
  	<div>
  		<span><input type="button" value="返回" onClick=""></span>
  		<span><input type="button" value="确认" onClick=""></span>
 	</div>
  </body>
</html> 