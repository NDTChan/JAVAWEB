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
	<form:form method="POST"
	action="${pageContext.request.contextPath}/admin/vattu/form" modelAttribute="vattu">
		<input type="hidden" class="form-control" value="${operation }"
			name="Operation" maxlength="255"> <input type="hidden"
			class="form-control" value="0" name="Id" maxlength="255">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Mã vật tư</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="MaVatTu"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Tên vật tư</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="TenVatTu"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Bar Code</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="TenVatTu"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Loại Vật tư</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="TenVatTu"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Nhà Cung cấp</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="TenVatTu"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label>Đơn vị tính</label><span style="color: red"> (*)</span>
						<input type="text" class="form-control" name="TenVatTu"
							maxlength="255" required>
					</div>
				</div>
			</div>
			<div class="row">
				<button class="btn btn-primary" type="submit" form="addForm"
					value="Submit">Lưu lại</button>
				<button type="button" class="btn btn-default"
					onclick="window.location='${pageContext.request.contextPath}/admin/donvitinh';">
					Hủy</button>
			</div>
		</div>
	</form:form>
</div>