<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-striped">
	<tr>
		<th>MaDonVi</th>
		<th>TenDonVi</th>
		<th>TrangThai</th>
	</tr>
	<c:forEach var="m" items="${list}" varStatus="stt">
		<tr>
			<td>${m.getMaDonViTinh()}</td>
			<td>${m.getTenDonViTinh()}</td>
			<td>${m.getTrangThai()}</td>
		</tr>
	</c:forEach>
</table>