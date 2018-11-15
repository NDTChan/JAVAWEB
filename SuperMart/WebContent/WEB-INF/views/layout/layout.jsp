<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Starter</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/dist/css/skins/skin-blue.min.css">

<script
	src="${pageContext.request.contextPath}/resources/html5shiv.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/respond.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script
	src="${pageContext.request.contextPath}/resources/jquery/dist/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/dist/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/dist/js/adminlte.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/typehead/jquery.autocomplete.min.js"></script>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/typehead/styles.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<%
			HttpSession sessionsa = request.getSession(false);
			String user = (String) sessionsa.getAttribute("username");
			if (session.getAttribute("username") == null) {
				response.sendRedirect("/SuperMart/login");
			}
		%>

		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="menu" />
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Page Header <small>Optional description</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
					<li class="active">Here</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content container-fluid">

				<tiles:insertAttribute name="body" />

			</section>
		</div>
		<tiles:insertAttribute name="footer" />
		<div class="control-sidebar-bg"></div>
	</div>

</body>
</html>