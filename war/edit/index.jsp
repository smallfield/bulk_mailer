<%@page import="java.util.ArrayList"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>送信先メールアドレスの編集 | メール一括送信システム</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
	<div id="header">
		<div id="menu">
			<ul>
				<li class="first"><a href="/editsender">送信者の編集</a></li>
				<li class=" current_page_item"><a href="/edit">送信先メールアドレスの編集</a>
				</li>
				<li><a href="/send">メール送信</a></li>
				<li><a href="/log">送信ログ</a></li>
			</ul>
		</div>
		<!-- end #menu -->
	</div>
	<!-- end #header -->
	<div id="logo">
		<h1>
			<a href="/">Bulk Mailer</a>
		</h1>
		<p>
			<em>メール一括送信システム</em>
		</p>
	</div>
	<hr />
	<!-- end #logo -->
	<div id="page">
		<div id="content">
			<div id="content-bgtop">
				<div id="content-bgbtm">
					<div class="post">
						<h2 class="title">送信先メールアドレスの編集</h2>
						<div class="entry">
							<%
								ArrayList list = (ArrayList) request.getAttribute("sender_list");
								if (list.size() > 0) {
							%>

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
										<td><select name="sender" id="">
												<c:forEach var="e" items="${sender_list}">
													<option value="${f:h(e.key)}">${f:h(e.name)}
														${f:h(e.email)}</option>
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
							<%
								} else {
							%>
							<p>予め送信者を登録する必要があります。</p>
							<%
								}
							%>

						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<div id="sidebar">
			<ul>
				<li>
					<h2>メニュー</h2>
					<ul>
						<li><a href="/editsender">送信者の編集</a></li>
						<li class="first"><a href="/edit">送信先メールアドレスの編集</a></li>
						<li><a href="/send">メール送信</a></li>
						<li><a href="/log">送信ログ</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
		<!-- end #page -->
		<div id="footer">
			<p>Copyright (c) 2011 Small Field All rights reserved.</p>
		</div>
		<!-- end #footer -->
	</div>
</body>
</html>

