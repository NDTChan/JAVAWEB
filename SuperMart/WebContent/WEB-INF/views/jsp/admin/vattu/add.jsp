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
	<form:form method="POST" name="form"
		action="${pageContext.request.contextPath}/admin/vattu/addAction" modelAttribute="vattu">
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
						<input id="imageUpload" type="file" class="form-control"/>
						<form:input path="Anh" id="Anh" type="hidden" name="Anh" 
 							class="form-control" maxlength="255" /> 
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div id="list-image">
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
				<button class="btn btn-primary" type="submit" value="Submit">Lưu lại</button>
				<button type="button" class="btn btn-default" onclick="window.location='${pageContext.request.contextPath}/admin/vattu';">
					Hủy
				</button>
			</div>
		</div>
	</form:form>
</div>

<script>
	$(function(){
		$('#imageUpload').change(function(){
			var imageFiles = document.getElementById("imageUpload");
			var maNhaCC = document.getElementsByName("MaNhaCungCap");
			var mavattu = document.getElementById('MaVatTu').value;
			if (mavattu) {
				var data = new FormData();
				var mavattu =  $('#MaVatTu').val().toString();
				data.append("image", imageFiles.files[0]);
				data.append("mavattu", mavattu);
				jQuery.ajax({
					url : '${pageContext.request.contextPath}/admin/vattu/uploadFile',
					data : data,
					cache : false,
					contentType : false,
					processData : false,
					method : 'POST',
					success : function(response) {
						if(response){
							var link = '/Upload/' +response;
							$('#Anh').val(link);
							var strHtml = "<img src='${pageContext.request.contextPath}/"+link+"' width=200px height=200px>";
							$('#list-image').html(strHtml); 
						}
					}
				});
			}else{
				alert("Nhập mã vật tư");
			}
		});

	});
</script>