<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>edit Index</title>
</head>
<body>
<h1>メールアドレス編集</h1>
<form action="commit" method="post">
<table>
	<tr>
		<td>名前</td>
		<td><input type="text" name="name" id="" /></td>
	</tr>
	<tr>
		<td>
			メールアドレス
		</td>
		<td><input type="text" name="email" id="" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="登録する" /></td>
	</tr>
</table>
</form>

<table>
		<tr>
			<th>名前</th>
			<th>メールアドレス</th>
			<th></th>
		</tr>
		<c:forEach var="e" items="${list}">
		<tr>
			<td>${f:h(e.name)}</td><td>${f:h(e.mailaddress)}</td>
			<td><a href="delete?id=${f:h(e.key)}">
				削除
			</a></td>
		</tr>
		</c:forEach>
</table>

</body>
</html>
