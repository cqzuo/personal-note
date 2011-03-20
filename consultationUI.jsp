<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'bankList.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<script type="text/javascript" src="${pageContext.request.contextPath}/script/NewTime.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/script/htlib.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.min.js"></script>
		<script type="text/javascript">
		 function getAbsPosition(obj) {
		    var r = {
		        left: obj.offsetLeft,
		        top : obj.offsetTop
		    };
		    r.left = obj.offsetLeft;
		    r.top  = obj.offsetTop;
		    if(obj.offsetParent) {
		        var tmp = getAbsPosition(obj.offsetParent);
		        r.left += tmp.left;
		        r.top  += tmp.top;
		    }
		    return r;
		  }
		  //设置元素的样式
		  function gettable(obj) {
		    var pos = getAbsPosition(obj);
		    pos.top += obj.offsetHeight;
		    document.getElementById('abstractname').style.top = pos.top + "px";
		    document.getElementById('abstractname').style.left = pos.left + "px";
		    document.getElementById('abstractname').style.width = obj.offsetWidth + "px";
		  }
				
			function showbankChildren(obj, selectNode) {
				ht.ajax(
					function(value) {
						var childbank = ht.$(selectNode.id+'Children');
						childbank.innerHTML = value;
					},
					'${pageContext.request.contextPath }/control/consultation/ConsultationAction_findchildrenBanks.action?consulation.bankId='
							+ obj.value + '&consulation.nameFlag=' + selectNode.name + "&" + new Date());
			}

			function showloanTypeChildren(obj) {
				ht.ajax(
					function(value) {
						var childloanType = ht.$('childloanType');
						childloanType.innerHTML = value;
					},
					'${pageContext.request.contextPath }/control/consultation/ConsultationAction_findchildrenLoanType.action?consulation.loanTypeId='
							+ obj.value + "&" + new Date());

			}

			function validate() {
				var isNull = /^[\s'　']*$/;
				if (isNull.test(document.getElementById('enterprisename').value)) {
					alert('企业全称不能为空');
					return false;
				} else if (isNull
						.test(document.getElementById('contacterName').value)) {
					alert('联系人不能为空');
					return false;
				} else if (isNull.test(document.getElementById('source').value)) {
					alert('项目来源不能为空');
					return false;
				} else {
					return true;
				}
			
			}

			function showabstarctName(obj) {
				document.getElementById("abstractname").style.cssText = "position: absolute; width: 200px; height: 100px; z-index: 1; left: 85px; top: 90px;border:1px solid #666666; border: 1;visibility:visible;";
				var wordInput = document.getElementById('enterprisename');
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
					'${pageContext.request.contextPath }/control/consultation/ConsultationAction_findabstractName.action?consulation.likename='
							+ encodeURI(encodeURI(obj.value))
							+ "&"
							+ new Date()
				);
			}

			function loop(value, elementObj) {
				for ( var i = 0; i < elementObj.options.length; i++) {
					if (elementObj.options[i].value != null
							&& elementObj.options[i].value != "") {
						if (value.indexOf(elementObj.options[i].value) != -1) {
							elementObj.options[i].selected = "selected";
						}
					}
				}
			}

			function quzhi() {
				
				var autoNode = document.getElementById('abstractname');
				var wordInput = document.getElementById('enterprisename');
				wordInput.focus(); 
				autoNode.style.visibility = "hidden";
				gettable(wordInput);
				wordInput.onclick = function() {
					autoNode.style.visibility = "visible";
					event.cancelBubble=true;
				}
				document.getElementById('enterprisename').value = trim(ename);
				ht.ajax(
					function(values) {
						var enobject = new Array();
						enobject = values.split(",");
						var typeName = document.getElementById('typeName');
						loop(enobject[0], typeName);
						document.getElementById('registAddress').value = enobject[1];
						document.getElementById('registTime').value = enobject[2];
						var registType = document.getElementById('registType');
						loop(enobject[3], registType);
						document.getElementById('legalPersonName').value = enobject[4];
						document.getElementById('contacterName').value = enobject[5];
						document.getElementById('contactPhone').value = enobject[6];
						if (enobject[7].indexOf('null') == -1) {
							document.getElementById('registrationCapital').value = enobject[7];
						}
					},
					'${pageContext.request.contextPath }/control/consultation/ConsultationAction_findEnterprise.action?consulation.enterprisename='
							+ encodeURI(encodeURI(ht.$('enterprise.name').value))
							+ "&" + new Date()
				);
			}

			window.onload = function() {
				for ( var i = 0; i < document.forms[0].elements.length; i++) {
					var oField = document.forms[0].elements[i];
					oField.disabled = true;
				}
				ht.$('enterprisename').disabled = false;
				ht.$("back").disabled = false;
			}
			
			
			function undolock() {
				 hidden();
				
				var wordInputValue = trim(document.getElementById('enterprisename').value);
				if (wordInputValue != "") {
					for ( var i = 0; i < document.forms[0].elements.length; i++) {
						var oField = document.forms[0].elements[i];
						oField.disabled = false;
					}
				}
				if (wordInputValue == "") {
					for ( var i = 0; i < document.forms[0].elements.length; i++) {
						var oField = document.forms[0].elements[i];
						oField.disabled = true;
					}
					ht.$('enterprise.name').disabled = false;
					ht.$("back").disabled = false;
				}
				
			}
			function hidden(){
				var autoNode = document.getElementById('abstractname');
				var kongjian = document.activeElement.id;
				if(kongjian != "sel") {
					autoNode.style.visibility = "hidden";
				}
			}
			
			function goBack(){
				window.location.href='${pageContext.request.contextPath }/control/consultation/ConsultationAction.action';
			}
			
			$(document).ready(function() {
				//下拉列表框的块标记
				var autoNode = $("#abstractname");
				var wordInput = $("#enterprisename");
				//表示当前高亮的节点
				var highlightindex = -1;
				var timeoutId;
				//获取匹配元素在当前视口的相对偏移。
				//返回的对象包含两个整形属性：top 和 left。此方法只对可见元素有效。
				var wordInputOffset = wordInput.offset();
				autoNode.css("left",wordInputOffset.left);
				autoNode.css("top",wordInputOffset.top+25);
				//自动补全框开始应该隐藏起来
				autoNode.css("width","200px").css("z-index","1").css("border","1px").css("position", "absolute").css("solid","#666666").css("background","#FFFFFF");
				autoNode.hide();
				//给文本框添加键盘按下并弹起的事件
				wordInput.keyup(abstractname);
			});
			
			function quzhi(event){
				alert("cao");
				var name = $("#abstractname").value();
				alert(name);
				var params = {
					"consulation.enterprisename":name
					};
				$.ajax({
					type: "POST",
					url: "${pageContext.request.contextPath }/control/consultation/ConsultationAction_findEnterprise.action",
					data: params,
					success: function(data){
						var enobject = new Array();
						enobject = values.split(",");
						var typeName = $("#typeName");
						loop(enobject[0], typeName);
						$("#registAddress").value = enobject[1];
						$("#registTime").value = enobject[2];
						var registType = $("#registType");
						loop(enobject[3], registType);
						$("#legalPersonName").value = enobject[4];
						$("#contacterName").value = enobject[5];
						$("#contactPhone").value = enobject[6];
						if (enobject[7].indexOf('null') == -1) {
							$("#registrationCapital").value = enobject[7];
						}
					}
				});
			}
			
			function abstractname(event) {
				
					var autoNode = $("#abstractname");
					var wordInput = $("#enterprisename");
					//处理文本框中的键盘事件
					//如果输入的是字母，应该将文本框中最新的信息发送给服务器
					var myEvent = event || window.event;
					var keyCode = myEvent.keyCode;
					//如果输入的是字母，应该将文本框中最新的信息发送给服务器
					//如果输入的是退格键或删除键，也应该将文本框中的最新信息发送给服务器
					if (keyCode >= 65 && keyCode <= 90 || keyCode == 8 || keyCode == 48){
						//1.首先获取文本框中的内容
						var wordText = wordInput.val();
						var params = {
							"consulation.likename":wordText
						}
						//如果内容不为空
						if (wordText != "") {
								$.ajax({
									type: "POST",
									url: "${pageContext.request.contextPath}/control/consultation/ConsultationAction_findabstractName.action",
									data: params,
									success: function(data){
									var nodes = data.split(",");
									//需要清空auto的内容
									autoNode.html("");
									//如果服务器没有数据返回，则显示弹出框
									if(nodes.length>0){
											//遍历所有的word节点，取出单词内容，然后将单词内容添加到弹出框中
											for(i=0;i<nodes.length;i++){
											//获取单词内容
											var wordNode = nodes[i];
											//新建div节点，将单词内容加入到新建的节点中
											//将新建的节点加入到弹出框的节点中
											var newDivNode = $("<div>");
											newDivNode.html(wordNode).appendTo(autoNode);
											//鼠标进入事件，高亮节点
											newDivNode.mouseover(function() {
												// 将原来的结果取消高亮
												if (highlightindex != -1) {
													autoNode.children("div").eq(highlightindex)
														.css("background-color", "CEE8F1");
												}
												//记录新的高亮索引
												highlightindex = i;
												//鼠标进入的节点高亮
												$(this).css("background-color", "#CEE8F1");
												wordInput.val($(this).text());
												quzhi();
											});
											//增加鼠标移出事件，取消当前节点的高亮
											newDivNode.mouseout(function() {
												//取消鼠标移出节点的高亮
												$(this).css("background-color", "white");
											});
											
									};
										autoNode.show();
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
								wordInput.val(autoNodes.eq(highlightindex).text());
								quzhi();
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
								wordInput.val(autoNodes.eq(highlightindex).text());
								quzhi();
							}
						
						} 
					}
		</script>

	</head>
	<body>
	<div class="title4">企业咨询一览</div>
	<div style="margin: 25px">
	<hr width="95%"/>
		<form action="${pageContext.request.contextPath}/control/consultation/ConsultationAction_save.action" method="post">
			<input type="hidden" name="task.step.stepNo">
			<div class="title3">
			咨询日期:<input id="startTime" type="text" name="project.consultationDate" Width="200px" value='${nowDate}' onclick="setday(this)" readonly="readonly">
			受理人:  <select name="consulation.accepterId">
						<option></option>
						<c:forEach items="${pmuserlist }" var="pm">
							<c:if test="${user.id == pm.id}">
								<option value="${pm.id}" selected="selected">
									${pm.realName}
								</option>
							</c:if>
							<c:if test="${user.id != pm.id}">
								<option value="${pm.id}">
									${pm.realName}
								</option>
							</c:if>
						</c:forEach>
					</select>
					</div>
					<br>
					<div class="title2">企业基本情况</div>
					<div id="abstractname"></div>
			<table align="center" width="100%" border="0" cellspacing="0" cellpadding="0" class="title3">
				<tr>
							<td>
								<table class="title3">
									<tr>
										<td width="20%">企业全称:</td>
										<td width="80%"><input type="text" name="enterprise.name" onblur="undolock()" id="enterprisename" style="width: 200px; height: 25px;" autocomplete="off"></td>
									</tr>
								</table>
							</td>
							<td>
								<table class="title3">
									<tr>
										<td width="25%">所属行业:</td>
										<td>
										<select name="consulation.enterpriseTypeId" id="typeName" style="width: 75%">
									<option value=""></option>
									<c:if test="${!empty enterpriseTypeList}">
										<c:forEach items="${enterpriseTypeList}" var="et">
											<option value="${et.id}">${et.name}</option>
										</c:forEach>
									</c:if>
									<c:if test="${empty enterpriseTypeList}">
										<option>无</option>
									</c:if>
								</select></td>
									</tr>
								</table>
							</td>
							<td>
								<table class="title3">
									<tr>
										<td width="25%">注册类型:</td>
										<td width="75%"><select name="consulation.registTypeId" id="registType" style="width: 75%">
									<option value=""></option>
									<c:if test="${!empty registTypeList}">
										<c:forEach items="${registTypeList}" var="rt">
											<option value="${rt.id}">${rt.name}</option>
										</c:forEach>
									</c:if>
									<c:if test="${empty enterpriseTypeList}">
										<option>无</option>
									</c:if>
								</select></td>
									</tr>
								</table>
							</td>
				</tr>
				<tr>
					<td>
						注册地址: <input type="text" name="enterprise.registAddress" id="registAddress">
					</td>
					<td>
						注册时间: <input type="text" name="enterprise.registTime" id="registTime">
					</td>
					<td>
						法人姓名: <input type="text" name="enterprise.legalPersonName" id="legalPersonName">
					</td>
				</tr>
				<tr>
					<td>
						联系人: <input type="text" name="enterprise.contacterName" id="contacterName">
					</td>
					<td>
						联系电话: <input type="text" name="enterprise.contactPhone" id="contactPhone">
					</td>
					<td>
						注册资本: <input type="text" name="enterprise.registrationCapital" id="registrationCapital">万元
					</td>
				</tr>
				<tr>
					<td>
						项目来源: <select name="consulation.sourceId" id="source" style="width: 45%">
									<option value=""></option>
									<c:if test="${!empty sourceList}">
										<c:forEach items="${sourceList}" var="s">
											<option value="${s.id}">${s.name}</option>
										</c:forEach>
									</c:if>
									<c:if test="${empty enterpriseTypeList}">
										<option>无</option>
									</c:if>
								 </select>
					</td>
				</tr>
			</table>
			<br>
			<div  class="title2">申请担保情况</div>
			<table align="center" width="100%" border="0" cellspacing="0" cellpadding="0" class="title3">
				<tr>
					<td>
					<table class="title3">
						<tr>
							<td width="25%">担保种类:</td>
							<td><select name="consulation.loanTypeId" onchange="showloanTypeChildren(this.options[this.selectedIndex])" style="width: 75%">
										<option value=""></option>
										<c:forEach items="${loanTypelist}" var="loanType">
											<option value="${loanType.id}">${loanType.name}</option>
										</c:forEach>
								 </select>
							</td>
						</tr>
					</table>
					</td>
					<td>
						<div id="childloanType"></div>
					</td>
					<td>
						担保金额:<input type="text" name="project.loanAmount">万元
					</td>
					<td>
						担保期限:<input type="text" name="project.loanExpires">个月
					</td>
				</tr>
				<tr>
					<td>
						<table class="title3">
						<tr>
							<td width="25%">贷款银行1:</td>
							<td><select name="consulation.bank1Id" id="bank1" onchange="showbankChildren(this.options[this.selectedIndex], this)" style="width: 75%">
										<option value=""></option>
										<c:forEach items="${banklist}" var="bank">
											<option value="${bank.id}">${bank.name}</option>
										</c:forEach>
									</select>
							</td>
						</tr>
					</table>
					</td>
					<td>
						<div id="bank1Children"></div>
					</td>
					<td>
						保函收益人1:<input type="text" name="project.lgName1">
					</td>
				</tr>
				<tr>
					<td>
					<table class="title3">
						<tr>
							<td width="25%">贷款银行2:</td>
							<td><select name="consulation.bank2Id" id="bank2" onchange="showbankChildren(this.options[this.selectedIndex], this)" style="width: 75%">
										<option value=""></option>
										<c:forEach items="${banklist}" var="bank">
											<option value="${bank.id}">${bank.name}</option>
										</c:forEach>
								  </select>
							</td>
						</tr>
					</table>
						 
					</td>
					<td>
						<div id="bank2Children"></div>
					</td>
					<td>
						保函收益人2 <input type="text" name="project.lgName2">
					</td>
				</tr>
				</table>
				<br>
				<table class="title3">
				<tr>
					<td>申请担保用途</td>
				</tr>
				<tr>
					<td>
						<textarea name="project.loanUseage" cols="40%" rows="3"></textarea>
					</td>
				</tr>
				<tr>
				   <td> 
				                   处理意见<input type="radio" name="suggestion.projectManagerState" value="立项 ">立项 &nbsp;
				               <input type="radio" name="suggestion.projectManagerState" value="否决">否决&nbsp;
				               <input type="radio" name="suggestion.projectManagerState" value="暂停">暂停
				   </td>
				</tr>
				<tr><td><br></td></tr>
				<tr>
				   <td>
				                   具体意见说明
				   </td>
				</tr>
				<tr>
				   <td>
				       <textarea name="suggestion.projectManagerSuggestion" cols="40%" rows="3"></textarea>
				   </td>
				</tr>
			</table>
			<input type="button" value="返回" onclick="goBack()" id="back">
			<input type="submit" value="确认提交" onclick="return validate();">
		</form>
		</div>
	</body>
</html>
