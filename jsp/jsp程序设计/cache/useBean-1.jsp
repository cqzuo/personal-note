<jsp:useBean name="testBean" id="testBean" class="com.test.TestBean" scope="request">
	<jsp:setProperty name="testBean" property="topic" value="news"/>
	<jsp:getProperty name="testBean" property="value"/>
</jsp:useBean>
