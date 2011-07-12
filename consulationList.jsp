<table style='font: 12px;' border='0' cellpadding='0' cellspacing='0'><TR>
<TD>押物名称 <INPUT name=mortgagename value2="2" value1="17"></TD>
<TD>备 注 <INPUT name=demo1 value2="2" value1="17"></TD>
<TD>评估价值 <INPUT onblur=autoValue(this); value=7 name=assessmentqt value2="2" value1="17"></TD></TR>
<TR>
<TD>位置 <INPUT name=location value2="2" value1="17"></TD>
<TD>登记机关 <SELECT name=regoffice> <OPTION selected></OPTION></SELECT> </TD>
<TD>权利证号<INPUT name=rightnumber value2="2" value1="17"></TD></TR>
<TR>
<TD>担保方式<SELECT name=mortgatype> <OPTION selected></OPTION></SELECT> </TD>
<TD>监 管<SELECT name=supervision> <OPTION selected></OPTION></SELECT> </TD>
<TD>担保人 <INPUT name=mortgagenames value2="2" value1="17"></TD></TR>
<TR>
<TD>是否保险 <SELECT name=issure> <OPTION selected></OPTION></SELECT> </TD></TR>
<tr></tr><tr><td colspan='3'><input type='button' value='追加' onclick='addEle(this);'><input type='button' value='删除' onclick='delEle(this);'></td></tr></table>