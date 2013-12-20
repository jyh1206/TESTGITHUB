<!DOCTYPE html>
<html>
	<head>
		<title>Test Index</title>
	</head>
	<body>
		<div>
			<h1>Grails Test</h1>
			<div id="controller-list" role="navigation">
				<ul>
					<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.name}</g:link></li>
					</g:each>
				</ul>
			</div>
		</div>
	</body>
</html>
