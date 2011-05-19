<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>メール送信</title>
<script type="text/javascript">
<!--

function check(){
	if(window.confirm('送信してよろしいですか？\n今一度送信者をご確認ください。\nOKをクリックすると直ちに送信されます。')){ // 確認ダイアログを表示
		return true; // 「OK」時は送信を実行
	}
	else{ // 「キャンセル」時の処理
		return false; // 送信を中止
	}
}
// -->
</script>
</head>
<body>


<h1>メール送信</h1>
<form action="send" method="post" onSubmit="return check()">
<table>
	<tr>
		<td>送信者</td>
		<td><select name="sender" id="">
			<c:forEach var="e" items="${sender_list}">
				<option value="${f:h(e.key)}">${f:h(e.name)}
				${f:h(e.email)}</option>
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>件名</td>
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
	<li><strong>送信者</strong>の選択に応じて、受信者が異なります。</li>
</ul>
</body>
</html>
