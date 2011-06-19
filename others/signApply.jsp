<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!-- 签约审批单 -->
<br>
<div class="title5">
	  	<div>
	  		<span>项目编号<input type="text" name="" readonly></span>
	  		<span>项目人<input type="text" name="" style="width: 50px" readonly="readonly"></span>
	  		<span>企业名称<input type="text" name="" style="width: 300px" readonly="readonly"></span>
	  	</div>
	  	<div>
	  		合作银行 <c:forEach items="${banks}" var="bank">${bank.bankName}</c:forEach>
	  	</div>
	  	<div>保险受益人</div>
	  	<div>
	  		<span>授信基本情况</span>
	  		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	  		<span><input type="button" value="查看执行单明细" onClick=""></span>
	  		<span><input type="button" value="查看签约履历" onClick=""></span>
	  	</div>
	  	<table align="center" width="95%" border="0" cellspacing="0" cellpadding="0" style="border-collapse:collapse;font: 12px" class="datagrid">
	  		<tr class="th">
	  			<td>授信品种</td>
	  			<td>授信金额(万元)</td>
	  			<td>发放时间</td>
	  			<td>每笔期限(月)</td>
	  			<td>收回时间</td>
	  			<td>保费收取方式</td>
	  			<td>保费标准</td>
	  		</tr>
	  		<c:choose>
	  			<c:when test="${! empty loanTypeList}">
	  				<c:forEach items="loanTypeList" var="loanType">
	  					<tr>
	  						<td></td>
	  						<td></td>
	  						<td></td>
	  						<td></td>
	  						<td></td>
	  						<td></td>
	  						<td></td>
	  					</tr>
	  				</c:forEach>
	  			</c:when>
	  			<c:otherwise>
	  				<tr>
	  					<td>暂无数据!</td>
	  				</tr>
	  			</c:otherwise>
	  		</c:choose>
	  		<tr>
              <td bgcolor="#99BBE9" height="4" colspan="11"></td>
            </tr>
	  	</table>
	  	<div class="title2">授信方案其他要求</div>
	  	<div>
	  		<textarea style="width:600px;height:50px;overflow-x:visible;overflow-y:visible;" readonly name=""></textarea>
	  	</div>
	  	<div>
	  		<span>是否涵盖在保        </span>
	  		<span>关联项目编号     </span>
	  		<span>是否逐笔确认:  </span>
	  	</div>
	  	<table align="center" width="95%" border="0" cellspacing="0" cellpadding="0" style="border-collapse:collapse;font: 12px" class="datagrid">
	  		<tr class="th">
	  			<td>发放方式</td>
	  			<td>还款方式</td>
	  			<td>具体归还计划</td>
	  		</tr>
	  		<tr>
	  			<td></td>
	  			<td></td>
	  			<td></td>
	  		</tr>
	  	</table>
	  	<hr>
	  	<div>
	  		<span>授信品种<input type="text" name=""></span>
	  		<span>合作银行<input type="text" name=""></span>
	  		<span>保函受益人<input type="text" name=""></span>
	  		<span>签约日期<input type="text" name="" onClick="WdatePicker()"></span>
	  	</div>
	  	<br>
	  	<div class="title2">需要提交的文件(金额单位:万元)</div>
	  	<hr>
	  		<table id="tabsubmit" align="center" width="95%" border="0" cellspacing="0" cellpadding="0" style="border-collapse:collapse;font: 12px" class="datagrid">
	  		<tr class="th">
	  			<td>文件名称</td>
	  			<td>文件编号</td>
	  			<td>份数</td>
	  			<td>币种</td>
	  			<td>贷款金额</td>
	  			<td>折合人民币</td>
	  			<td>起始时间</td>
	  			<td>到期时间</td>
	  			<td>补充约定</td>
	  		</tr>
			<tr>
				<td><input type="text" name="" id="name"></td>
				<td><input type="text" name=""></td>
				<td><input type="text" name=""></td>
				<td>
					<select name="">
						<option>请选择币种</option>
					</select>
				</td>
				<td></td>
				<td></td>
				<td><input type="text" name="" onClick="WdatePicker()"></td>
				<td><input type="text" name="" onClick="WdatePicker()"></td>
				<td></td>
			</tr>
	  		<tr id="submit">
 				<td colspan="9">
 					<input type="button" value="追加文件" onclick="addTr('submit');">
 					<input type="button" value="撤销追加" onclick="delTr('submit');">
 				</td>
 			</tr>
	  		<tr>
              <td bgcolor="#99BBE9" height="4" colspan="11"></td>
            </tr>
	  	</table>
	  	<br>
	  	<div class="title2">需要签署的文件(金额单位:万元)</div>
	  	<hr>
	  	<table id="tabsign" align="center" width="95%" border="0" cellspacing="0" cellpadding="0" style="border-collapse:collapse;font: 12px" class="datagrid">
	  		<tr class="th">
	  			<td>文件名称</td>
	  			<td>文件编号</td>
	  			<td>份数</td>
	  			<td>币种</td>
	  			<td>贷款金额</td>
	  			<td>折合人民币</td>
	  			<td>起始时间</td>
	  			<td>到期时间</td>
	  			<td>补充约定</td>
	  		</tr>
			<tr>
	 			<td><input type="text" name=""></td>
	 			<td><input type="text" name=""></td>
	 			<td><input type="text" name=""></td>
	 			<td>
	 				<select name="">
	 					<option>请选择币种</option>
	 				</select>
	 			</td>
	 			<td></td>
	 			<td></td>
	 			<td><input type="text" name="" onClick="WdatePicker()"></td>
	 			<td><input type="text" name="" onClick="WdatePicker()"></td>
	 			<td></td>
 			</tr>
	  		<tr id="sign">
 				<td colspan="9">
 					<input type="button" value="追加文件" onclick="addTr('sign');">
 					<input type="button" value="撤销追加" onclick="delTr('sign');">
 				</td>
 			</tr>
	  		<tr>
              <td bgcolor="#99BBE9" height="4" colspan="11"></td>
            </tr>
	  	</table>
	  	<div id="abstractname" class="title5" onmousedown="hidden()"></div>