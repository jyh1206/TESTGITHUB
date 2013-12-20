<%@ page import="goodtest.NoHasMany" %>



<div class="fieldcontain ${hasErrors(bean: noHasManyInstance, field: 'testGe', 'error')} required">
	<label for="testGe">
		<g:message code="noHasMany.testGe.label" default="Test Ge" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="testGe" required="" value="${noHasManyInstance?.testGe}"/>
</div>

