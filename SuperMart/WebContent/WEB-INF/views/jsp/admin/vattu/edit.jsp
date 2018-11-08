<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Sửa đơn vị tính</h2>
<div class="box">
	<c:if test="${error =='true'}" >
		<span style="color:red"> Xảy ra lỗi khi sửa. Vui lòng kiểm tra lại !</span>
		<div class="row">  </div>
	</c:if> 
	<form id="addForm" method="get" action="${pageContext.request.contextPath}/admin/vattu/form" >
		<input type="hidden" class="form-control" value="${operation }" name="Operation" maxlength="255">
		<input type="hidden" class="form-control" value="${instance.getId() }" name="Id" maxlength="255">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Mã vật tư</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="MaVatTu" value="${instance.getMaVatTu() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Tên vật tư</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="TenVatTu" value="${instance.getTenVatTu() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Mã loại vật tư</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="MaLoaiVatTu" value="${instance.getMaLoaiVatTu() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Mã nhà cung cấp</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="MaNhaCungCap" value="${instance.getMaNhaCungCap() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Mã đơn vị tính</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="MaDonViTinh" value="${instance.getMaDonViTinh() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Giá mua</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="GiaMua" value="${instance.getGiaMua() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Giá bán</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="GiaBan" value="${instance.getGiaBan() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Số lượng</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="SoLuong" value="${instance.getSoLuong() }"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Ảnh</label><span style="color: red"> (*)</span>
						<input id="imageUpload" type="file" class="form-control" onChange="loadImage()"/>
						<form:input path="Anh" id="Anh" type="hidden" name="Anh" 
 							class="form-control" maxlength="255" /> 
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
					
						<label>Trạng thái</label> <select class="form-control"
							name="TrangThai">
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
				<button class="btn btn-primary" type="submit"
					form="addForm" value="Submit">Lưu lại</button>
				<button type="button" class="btn btn-default"
					onclick="window.location='${pageContext.request.contextPath}/admin/vattu';">
					Hủy
				</button>
			</div>
		</div>

	</form>
</div>