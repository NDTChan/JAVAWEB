<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Nhà Cung Cấp</h2>
<div class="box">
	<form id="detailForm">
		<input type="hidden" class="form-control" value="${operation }"
			name="Operation" maxlength="255"> <input type="hidden"
			class="form-control" value="0" name="Id" maxlength="255">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label>Mã Nhà Cung Cấp</label>
						<input type="text" class="form-control" name="MaNhaCungCap" value="${instance.getMaNhaCungCap() }"
							maxlength="255" disable>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Tên nhà Cung Cấp</label>
						<input type="text" class="form-control" name="TenNhaCungCap" value="${instance.getTenNhaCungCap() }"
							maxlength="255" disable>
					</div>
				</div>
			</div>			
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label>Địa Chỉ</label>
						<input type="text" class="form-control" name="DiaChi" value="${instance.getDiaChi() }"
							maxlength="255" disable>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Điện Thoại</label>
						<input type="text" class="form-control" name="DienThoai" value="${instance.getDienThoai() }"
							maxlength="255" disable>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label>Email</label>
						<input type="text" class="form-control" name="Email" value="${instance.getEmail() }"
							maxlength="255" disable>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Trạng thái</label> 
						<select class="form-control"
							name="TrangThai" disable>
							<c:if test="${instance.getTrangThai() =='10'}" >
								<option value="10" selected>Sử dụng</option>
								<option value="0">Không sử dụng</option>
							</c:if> 
							<c:if test="${instance.getTrangThai() =='0'}" >
								<option value="10">Sử dụng</option>
								<option value="0" selected>Không sử dụng</option>
							</c:if> 
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<button type="button" class="btn btn-default"
					onclick="window.location='${pageContext.request.contextPath}/admin/nhacungcap';">
					Quay lại</button>
			</div>
		</div>

	</form>
</div>