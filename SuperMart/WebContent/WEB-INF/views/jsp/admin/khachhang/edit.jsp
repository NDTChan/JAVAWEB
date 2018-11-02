<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Sửa khách hàng</h2>
<div class="box">
	<c:if test="${error =='true'}" >
		<span style="color:red"> Xảy ra lỗi khi sửa. Vui lòng kiểm tra lại !</span>
		<div class="row">  </div>
	</c:if> 
	<form id="addForm" method="get" action="${pageContext.request.contextPath}/admin/khachhang/form" >
		<input type="hidden" class="form-control" value="${operation }" name="Operation" maxlength="255">
		<input type="hidden" class="form-control" value="${instance.getId() }" name="Id" maxlength="255">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Mã khách hàng</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="MaKhachHang" value="${instance.getMaKhachHang() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Tên khách hàng</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="TenKhachHang" value="${instance.getTenKhachHang() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Địa chỉ</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="DiaChi" value="${instance.getDiaChi() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Số điện thoại</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="SoDienThoai" value="${instance.getDienThoai() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Email</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="Email" value="${instance.getEmail() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<button class="btn btn-primary" type="submit"
					form="addForm" value="Submit">Lưu lại</button>
				<button type="button" class="btn btn-default"
					onclick="window.location='${pageContext.request.contextPath}/admin/khachhang';">
					Hủy
				</button>
			</div>
		</div>

	</form>
</div>