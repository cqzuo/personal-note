<%@taglib prefix="s" uri="/struts-tags"%>
<script>
	function select_on_change()
	{
		document.selectorForm.submit();
	}
</script>
<s:set name="SESSION_LOCAL" value="SESSION_LOCAL['WW_TRANS_I18N_LOCALE']"/>
<s:bean id="locales" name="org.apache.struts2.utils.Locales"/>
<s:form name="selectorForm" action="<s:url includeParam="get">" encode="true">
	<s:select 
		id="locales_selector" name="request_locale"
		list="#locales.locales" listKey="value" listValue="key"
		value="#SESSION_LOCAL==null?Locales:SESSION_LOCAL"
		onchange="select_on_change()"
	/>
</s:form>