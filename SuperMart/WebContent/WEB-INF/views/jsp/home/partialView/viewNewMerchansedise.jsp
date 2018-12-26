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
								src="${pageContext.request.contextPath}/${m.getVatTu().getAnh()}"
								alt="" /></a>
						</p>
						<a href="product_detail.html" class="title">${m.getVatTu().getTenVatTu()}</a><br />
						<a href="products.html" class="category">${m.getLoaiVatTu().getTenLoaiVatTu()}</a>
						<p class="price">${m.getVatTu().getGiaBan()}</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>