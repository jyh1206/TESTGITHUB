
<%@ page import="goodtest.TestGood" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'testGood.label', default: 'TestGood')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-testGood" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-testGood" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list testGood">
			
				<g:if test="${testGoodInstance?.book}">
				<li class="fieldcontain">
					<span id="book-label" class="property-label"><g:message code="testGood.book.label" default="Book" /></span>
					
						<span class="property-value" aria-labelledby="book-label"><g:fieldValue bean="${testGoodInstance}" field="book"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${testGoodInstance?.count_book}">
				<li class="fieldcontain">
					<span id="count_book-label" class="property-label"><g:message code="testGood.count_book.label" default="Countbook" /></span>
					
						<span class="property-value" aria-labelledby="count_book-label"><g:fieldValue bean="${testGoodInstance}" field="count_book"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${testGoodInstance?.book_name}">
				<li class="fieldcontain">
					<span id="book_name-label" class="property-label"><g:message code="testGood.book_name.label" default="Bookname" /></span>
					
						<g:each in="${testGoodInstance.book_name}" var="b">
						<span class="property-value" aria-labelledby="book_name-label"><g:link controller="goodTest" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:testGoodInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${testGoodInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
