<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
  	<title><tiles:getAsString name="title" /></title>
  	<meta charset="utf-8">
	<title>Bootstrap E-commerce Templates</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstraphome/css/bootstrap.min.css">   
	<link href="${pageContext.request.contextPath}/resources/bootstraphome/css/bootstrap-responsive.min.css" rel="stylesheet">
	
	<link href="${pageContext.request.contextPath}/resources/themes/css/bootstrappage.css" rel="stylesheet"/>
	
	<!-- global styles -->
	<link href="${pageContext.request.contextPath}/resources/themes/css/main.css" rel="stylesheet"/>
	
	<!-- scripts -->
	<script src="${pageContext.request.contextPath}/resources/themes/js/jquery-1.7.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap/dist/js/bootstrap.min.js"></script>		
	<script src="${pageContext.request.contextPath}/resources/themes/js/superfish.js"></script>
</head>
<body>
  <tiles:insertAttribute name="header" />
  <div id="wrapper" class="container">
  	<tiles:insertAttribute name="body" />
  	<tiles:insertAttribute name="footer" />
  </div>
  
  <script src="${pageContext.request.contextPath}/resources/themes/js/common.js"></script>
		<script src="${pageContext.request.contextPath}/resources/themes/js/jquery.flexslider-min.js"></script>
		<script type="text/javascript">
			$(function() {
				$(document).ready(function() {
					$('.flexslider').flexslider({
						animation: "fade",
						slideshowSpeed: 4000,
						animationSpeed: 600,
						controlNav: false,
						directionNav: true,
						controlsContainer: ".flex-container" // the container that holds the flexslider
					});
				});
			});
		</script>
</body>
</html>