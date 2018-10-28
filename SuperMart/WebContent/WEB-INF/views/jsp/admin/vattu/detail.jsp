<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Đơn vị tính</h2>
<div class="box">
	<form id="detailForm">
		<input type="hidden" class="form-control" value="${operation }"
			name="Operation" maxlength="255"> <input type="hidden"
			class="form-control" value="0" name="Id" maxlength="255">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Mã đơn vị tính</label>
						<input type="text" class="form-control" name="MaDonViTinh" value="${instance.getMaDonViTinh() }"
							maxlength="255">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Tên đơn vị tính</label>
						<input type="text" class="form-control" name="TenDonViTinh" value="${instance.getTenDonViTinh() }"
							maxlength="255">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Trạng thái</label> 
						<select class="form-control"
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
				<button type="button" class="btn btn-default"
					onclick="window.location='${pageContext.request.contextPath}/admin/donvitinh';">
					Quay lại</button>
			</div>
		</div>

	</form>
</div>