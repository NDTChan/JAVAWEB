<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Thêm mới loại vật tư</h2>
<div class="box">
	<c:if test="${error =='true'}">
		<span style="color: red"> Xảy ra lỗi khi thêm. Vui lòng kiểm
			tra lại !</span>
		<div class="row"></div>
	</c:if>
	<form id="addForm" method="get"
		action="${pageContext.request.contextPath}/admin/nhacungcap/form">
		<input type="hidden" class="form-control" value="${operation }"
			name="Operation" maxlength="255"> <input type="hidden"
			class="form-control" value="0" name="Id" maxlength="255">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label>Mã Nhà Cung Cấp:</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="MaNhaCungCap"
							maxlength="255" required>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Tên Nhà Cung Cấp:</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="TenNhaCungCap"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label>Điện Thoại:</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="DienThoai"
							maxlength="255" required>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Địa Chỉ:</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="DiaChi"
							maxlength="255" required>
					</div>
				</div>				
			</div>
			<div class="row">
			<div class="col-md-6">
					<div class="form-group">
						<label>Email:</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="Email"
							maxlength="255" required>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Trạng thái</label> <select class="form-control"
							name="TrangThai">
							<option value="10">Sử dụng</option>
							<option value="0">Không sử dụng</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<button class="btn btn-primary" type="submit" form="addForm"
					value="Submit">Lưu lại</button>
				<button type="button" class="btn btn-default"
					onclick="window.location='${pageContext.request.contextPath}/admin/nhacungcap';">
					Hủy</button>
			</div>
		</div>

	</form>
</div>