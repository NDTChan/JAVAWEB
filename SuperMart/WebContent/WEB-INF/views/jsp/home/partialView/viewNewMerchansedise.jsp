<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="carousel-inner">
	<div class="active item">
		<ul class="thumbnails">
			<c:forEach var="m" items="${lstVatTu}" varStatus="stt">
				<li class="span3">
					<div class="product-box">
						<span class="sale_tag"></span>
						<p>
							<a href="product_detail.html"><img
								src="${pageContext.request.contextPath}/resources/themes/images/ladies/1.jpg"
								alt="" /></a>
						</p>
						<a href="product_detail.html" class="title">Ut wisi enim ad</a><br />
						<a href="products.html" class="category">Commodo consequat</a>
						<p class="price">$17.25</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>