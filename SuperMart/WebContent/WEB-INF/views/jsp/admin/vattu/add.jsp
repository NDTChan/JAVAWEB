<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Thêm mới vật tư</h2>
<div class="box">
	<c:if test="${error =='true'}">
		<span style="color: red"> Xảy ra lỗi khi thêm. Vui lòng kiểm
			tra lại !</span>
		<div class="row"></div>
	</c:if>
	<form:form method="POST" name="form" id="upload-form"
		action="${pageContext.request.contextPath}/admin/vattu/addAction"
		enctype="multipart/form-data" modelAttribute="vattu">
		<input type="hidden" class="form-control" value="${operation }"
			name="Operation" maxlength="255">
		<input type="hidden" class="form-control" value="0" name="Id"
			maxlength="255">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Mã vật tư</label><span style="color: red"> (*)</span>
						<form:input path="MaVatTu" class="form-control" maxlength="255" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Tên vật tư</label><span style="color: red"> (*)</span>
						<form:input path="TenVatTu" type="text" class="form-control"
							name="TenVatTu" maxlength="255" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Bar Code</label><span style="color: red"> (*)</span>
						<form:input path="BarCode" type="text" class="form-control"
							name="BarCode" maxlength="255" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Loại Vật tư</label><span style="color: red"> (*)</span>
						<form:input path="MaLoaiVatTu" type="text" class="form-control"
							name="MaLoaiVatTu" maxlength="255" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Nhà Cung cấp</label><span style="color: red"> (*)</span>
						<form:input path="MaNhaCungCap" type="text" class="form-control"
							name="MaNhaCungCap" maxlength="255" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5">
					<div class="form-group">
						<label>Đơn vị tính</label><span style="color: red"> (*)</span>
						<form:input path="MaDonViTinh" type="text" class="form-control"
							name="MaDonViTinh" maxlength="255" />
					</div>
				</div>
				<div class="col-md-5">
					<div class="form-group">
						<label>Số lượng</label><span style="color: red"> (*)</span>
						<form:input path="SoLuong" type="text" class="form-control"
							name="SoLuong" maxlength="255" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5">
					<div class="form-group">
						<label>Giá Mua</label><span style="color: red"> (*)</span>
						<form:input path="GiaMua" type="text" class="form-control"
							name="GiaMua" maxlength="255" />
					</div>
				</div>
				<div class="col-md-5">
					<div class="form-group">
						<label>Giá Bán</label><span style="color: red"> (*)</span>
						<form:input path="GiaBan" type="text" class="form-control"
							name="GiaBan" maxlength="255" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Ảnh</label><span style="color: red"> (*)</span>
						<input id="imageUpload" type="file" class="form-control" onChange="loadImage()"/>
						<form:input path="Anh" id="Anh" type="text" name="Anh" 
 							class="form-control" maxlength="255" /> 
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
				<button class="btn btn-primary" type="submit" value="Submit">Lưu
					lại</button>
				<button type="button" class="btn btn-default"
					onclick="window.location='${pageContext.request.contextPath}/admin/vattu';">
					Hủy</button>
			</div>
		</div>
	</form:form>
</div>

<script>
	function loadImage() {
		var imageFiles = document.getElementById("imageUpload");
		var maNhaCC = document.getElementsByName("MaNhaCungCap");
		var fullPath = document.getElementById('imageUpload').value;
		if (fullPath) {
			var data = new FormData();
			data.append("image", imageFiles.files[0]);
			var d = new Date();
		    var n = d.getTime();
		    var ext = fullPath.substr(fullPath.lastIndexOf('.') + 1);
			data.append("name", n+'.'+ext);
			jQuery
					.ajax({
						url : '${pageContext.request.contextPath}/admin/vattu/uploadFile',
						data : data,
						cache : false,
						contentType : false,
						processData : false,
						method : 'POST',
						success : function(response) {
							if(response){
								$('#Anh').val(response);
							}
							
						}
					});
		}

	}
</script>