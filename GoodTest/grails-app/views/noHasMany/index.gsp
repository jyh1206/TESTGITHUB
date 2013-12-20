<%@ page import="goodtest.NoHasMany" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<title>Test Page</title>
	<g:javascript library="jquery"/>
</head>
<body>
	<g:form name="testNoHasMany" action="testNoHasMany" method="post">
		<g:eachError bean="${testNoHasMany}">
			<div class="errors">
				<li><g:message error="${it}" /></li>
			</div>
		</g:eachError>
		<table>
			<colgroup>
				<col width="200" />
				<col width="*" />
			</colgroup>
				<td colspan="2">
					<g:actionSubmit action="testNoHasMany" value="완료" onclick="return confirm('test')"/>
				</td>
			</tr>
		</table>
	</g:form>
</body>
</html>
