<%@ page import="goodtest.TestGood" %>



<div class="fieldcontain ${hasErrors(bean: testGoodInstance, field: 'book', 'error')} required">
	<label for="book">
		<g:message code="testGood.book.label" default="Book" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="book" required="" value="${testGoodInstance?.book}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: testGoodInstance, field: 'count_book', 'error')} required">
	<label for="count_book">
		<g:message code="testGood.count_book.label" default="Countbook" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="count_book" type="number" value="${testGoodInstance.count_book}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: testGoodInstance, field: 'book_name', 'error')} ">
	<label for="book_name">
		<g:message code="testGood.book_name.label" default="Bookname" />
		
	</label>
	<g:select name="book_name" from="${goodtest.GoodTest.list()}" multiple="multiple" optionKey="id" size="5" value="${testGoodInstance?.book_name*.id}" class="many-to-many"/>
</div>

