
<%@ page import="goodtest.TestGood" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'testGood.label', default: 'TestGood')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-testGood" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-testGood" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="book" title="${message(code: 'testGood.book.label', default: 'Book')}" />
					
						<g:sortableColumn property="count_book" title="${message(code: 'testGood.count_book.label', default: 'Countbook')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${testGoodInstanceList}" status="i" var="testGoodInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${testGoodInstance.id}">${fieldValue(bean: testGoodInstance, field: "book")}</g:link></td>
					
						<td>${fieldValue(bean: testGoodInstance, field: "count_book")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${testGoodInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
