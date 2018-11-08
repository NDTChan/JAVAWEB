<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="box">
	<div class="box-header">
		<h3 class="box-title">
			<button type="button" class="btn btn-block btn-primary"
				onclick="window.location='${pageContext.request.contextPath}/admin/vattu/add';">
				<i class="fa fa-plus"></i> Thêm mới
			</button>
		</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 300px;">
				<input type="text" name="table_search"
					class="form-control pull-right" placeholder="Search">
				<div class="input-group-btn">
					<button type="submit" class="btn btn-default">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>STT</th>
					<th>Mã Vật tư</th>
					<th>Tên Vật tư</th>
					<th>Loại vật tư</th>
					<th>Nhà Cung cấp</th>
					<th>Đơn vị tính</th>
					<th>Giá Mua</th>
					<th>Giá Bán</th>
					<th>Số lượng</th>
					<th>Ảnh</th>
					<th>Trạng thái</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${list}" varStatus="stt">
					<tr>
						<td>${stt.index+1 }</td>
						<td>${m.getMaVatTu()}</td>
						<td>${m.getTenVatTu()}</td>
						<td>${m.getMaLoaiVatTu()}</td>
						<td>${m.getMaNhaCungCap()}</td>
						<td>${m.getMaDonViTinh()}</td>
						<td>${m.getGiaMua()}</td>
						<td>${m.getGiaBan()}</td>
						<td>${m.getSoLuong()}</td>
						<td> <img src="${pageContext.request.contextPath}/Upload/${m.getAnh()}" alt="Angry face" width="32" height="32" /></td>
						<td>
							<c:if test="${m.getTrangThai() =='10'}" >
								<span class="label label-success">Sử dụng</span>
							</c:if> 
							<c:if test="${m.getTrangThai() =='0'}" >
								<span class="label label-warning">Không sử dụng</span>
							</c:if> 
						</td>
						<td class="text-center">
							<p>
								<a class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/admin/vattu/detail?id=${m.getId()}"><i class="fa fa-fw fa-info"></i></a>
								<a class="btn btn-warning btn-xs" href="${pageContext.request.contextPath}/admin/vattu/edit?id=${m.getId()}"><i class="fa fa-fw fa-edit"></i></a> 
								<a class="btn btn-danger btn-xs" onclick="deleteItem(${m.getId()})"><i class="fa fa-fw fa-trash-o"></i></a>
							</p>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
				<li><a href="#">&laquo;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul>
		</div>
	</div>
</div>

<script>
	function deleteItem(id){
		$.get("${pageContext.request.contextPath}/admin/vattu/deleteItem?id="+id, function(data, status){
	        if(data==='true'){
	        	alert('Xóa thành công');
	        	window.location='${pageContext.request.contextPath}/admin/vattu';
	        }
	    });
	}
</script>



