<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="box">
	<div class="box-header">
		<h3 class="box-title">
			<button type="button" class="btn btn-block btn-primary"
				onclick="window.location='${pageContext.request.contextPath}/admin/nhacungcap/add';">
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
					<th>Mã Nhà Cung Cấp</th>
					<th>Tên Nhà Cung Cấp</th>
					<th>Điện Thoại</th>
					<th>Địa Chỉ</th>
					<th>Email</th>
					<th>Trạng thái</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${list}" varStatus="stt">
					<tr>
						<td>${stt.index+1 }</td>
						<td>${m.getMaNhaCungCap()}</td>
						<td>${m.getTenNhaCungCap()}</td>
						<td>${m.getDiaChi()}</td>
						<td>${m.getDienThoai()}</td>
						<td>${m.getEmail()}</td>
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
								<a class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/admin/nhacungcap/detail?id=${m.getId()}"><i class="fa fa-fw fa-info"></i></a>
								<a class="btn btn-warning btn-xs" href="${pageContext.request.contextPath}/admin/nhacungcap/edit?id=${m.getId()}"><i class="fa fa-fw fa-edit"></i></a> 
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
		$.get("${pageContext.request.contextPath}/admin/nhacungcap/deleteItem?id="+id, function(data, status){
	        if(data==='true'){
	        	alert('Xóa thành công');
	        	window.location='${pageContext.request.contextPath}/admin/nhacungcap';
	        }
	    });
	}
</script>



