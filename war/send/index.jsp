<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>send Index</title>
</head>
<body>
<h1>
	メール送信
</h1>
<form action="send" method="post">
	<table>
		<tr>
			<td>
				件名
			</td>
			<td><input type="text" name="subject" size="80" /></td>
		</tr>
		<tr>
			<td>本文</td>
			<td><textarea name="body" id="body" cols="80" rows="30">%NAME% さま</textarea></td>
		</tr>
	</table>
	<p><input type="submit" value="送信する" /></p>
</form>
<ul>
	<li>本文中に「<strong>%NAME%</strong>」を含めると、送信先の人の名前に自動的に置換されます。</li>
</ul>
</body>
</html>
