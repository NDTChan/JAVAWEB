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
		action="${pageContext.request.contextPath}/admin/loaivattu/form">
		<input type="hidden" class="form-control" value="${operation }"
			name="Operation" maxlength="255"> <input type="hidden"
			class="form-control" value="0" name="Id" maxlength="255">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Mã loại vật tư:</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="MaLoaiVatTu"
							value="${MaLoaiVatTu}" maxlength="255" required readonly>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Tên loại vật tư</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="TenLoaiVatTu"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
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
					onclick="window.location='${pageContext.request.contextPath}/admin/loaivattu';">
					Hủy</button>
			</div>
		</div>

	</form>
</div>