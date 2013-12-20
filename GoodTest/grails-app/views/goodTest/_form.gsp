<%@ page import="goodtest.GoodTest" %>



<div class="fieldcontain ${hasErrors(bean: goodTestInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="goodTest.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${goodTestInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: goodTestInstance, field: 'books', 'error')} ">
	<label for="books">
		<g:message code="goodTest.books.label" default="Books" />
		
	</label>
	
</div>

