<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>送信先メールアドレスの編集</title>
</head>
<body>
<h1>送信先メールアドレスの編集</h1>
<c:forEach var="e" items="${f:errors()}">
<li>${f:h(e)}</li>
</c:forEach>
<form action="commit" method="post">
<table>
	<tr>
		<td>名前</td>
		<td><input type="text" name="name" id="" /></td>
	</tr>
	<tr>
		<td>メールアドレス</td>
		<td><input type="text" name="email" id="" /></td>
	</tr>
	<tr>
		<td>送信者</td>
		<td>
		<select name="sender" id="">
		<c:forEach var="e" items="${sender_list}">
		<option value="${f:h(e.key)}">${f:h(e.name)} ${f:h(e.email)}</option>
		</c:forEach>
		</select>
		</td>
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
		<th>送信者</th>
		<th></th>
	</tr>
	<c:forEach var="e" items="${list}">
		<tr>
			<td>${f:h(e.name)}</td>
			<td>${f:h(e.email)}</td>
			<td>${f:h(e.senderName)}</td>
			<td><a href="delete?id=${f:h(e.key)}"> 削除 </a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
