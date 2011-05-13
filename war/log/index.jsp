<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>log Index</title>
</head>
<body>
<h1>送信ログ</h1>
<table>
		<tr>
			<th>
				日時
			</th>
			<th>
				件名
			</th>
			<th>
				内容
			</th>
			<th>人数</th>
		</tr>
		<c:forEach var="e" items="${list}">
		<tr>
			<td>${f:h(e.sendDate)}</td><td>${f:h(e.subject)}</td>
			<td>
				${f:br(e.text)}
			</td>
			<td>${f:h(e.count)}</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>
