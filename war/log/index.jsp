<%@page import="java.util.ArrayList"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>送信ログ | メール一括送信システム</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
	<div id="header">
		<div id="menu">
			<ul>
				<li class="first"><a href="/editsender">送信者の編集</a>
				</li>
				<li><a href="/edit">送信先メールアドレスの編集</a>
				</li>
				<li><a href="/send">メール送信</a>
				</li>
				<li class=" current_page_item"><a href="/log">送信ログ</a>
				</li>
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
						<h2 class="title">送信ログ</h2>
						<div class="entry">
							<%
								ArrayList list = (ArrayList) request.getAttribute("list");
								if (list.size() > 0) {
							%>
							<table>
								<tr>
									<th>日時</th>
									<th>件名</th>
									<th>内容</th>
									<th>人数</th>
								</tr>
								<c:forEach var="e" items="${list}">
									<tr>
										<td>${f:h(e.sendDate)}</td>
										<td>${f:h(e.subject)}</td>
										<td>${f:br(e.text)}</td>
										<td>${f:h(e.count)}</td>
									</tr>
								</c:forEach>
							</table>
							<%
								} else {
							%>
							<p>送信ログはありません。</p>
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
						<li><a href="/editsender">送信者の編集</a>
						</li>
						<li class="first"><a href="/edit">送信先メールアドレスの編集</a>
						</li>
						<li><a href="/send">メール送信</a>
						</li>
						<li><a href="/log">送信ログ</a>
						</li>
					</ul></li>
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

