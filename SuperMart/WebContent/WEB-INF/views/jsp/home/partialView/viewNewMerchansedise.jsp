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
							<a href="${pageContext.request.contextPath}/sanpham/${m.getVatTu().getMaVatTu()}"><img
								src="${pageContext.request.contextPath}/${m.getVatTu().getAnh()}"
								style="width:200px;height:300px"></a>
						</p>
						<a href="${pageContext.request.contextPath}/sanpham/${m.getVatTu().getMaVatTu()}" class="title">${m.getVatTu().getTenVatTu()}</a><br />
						<a href="products.html" class="category">${m.getLoaiVatTu().getTenLoaiVatTu()}</a>
						<p class="price">${m.getVatTu().getGiaBan()}</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>