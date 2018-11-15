<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.supermart.models.NhomVatTu" %>
<%@page import="com.supermart.service.PagingVm" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="box">
	<div class="box-header">
		<h3 class="box-title">
			<button type="button" class="btn btn-block btn-primary"
				onclick="window.location='${pageContext.request.contextPath}/admin/nhomvattu/add';">
				<i class="fa fa-plus"></i> Thêm mới
			</button>
		</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 300px;">
				<input type="text" name="table_search" class="form-control pull-right" placeholder="Search" id="searchKey" >
				<div class="input-group-btn">
					<button type="submit" onclick="search()" class="btn btn-default">
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
					<th>Mã nhóm vật tư</th>
					<th>Tên nhóm vật tư</th>
					<th>Mã loại vật tư</th>
					<th>Trạng thái</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${result.getData()}" varStatus="stt">
					<tr>
						<td>${stt.index+1 }</td>
						<td>${m.getMaNhomVatTu()}</td>
						<td>${m.getTenNhomVatTu()}</td>
						<td>${m.getMaLoaiVatTu()}</td>
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
								<a class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/admin/nhomvattu/detail?id=${m.getId()}"><i class="fa fa-fw fa-info"></i></a>
								<a class="btn btn-warning btn-xs" href="${pageContext.request.contextPath}/admin/nhomvattu/edit?id=${m.getId()}"><i class="fa fa-fw fa-edit"></i></a> 
								<a class="btn btn-danger btn-xs" onclick="deleteItem(${m.getId()})"><i class="fa fa-fw fa-trash-o"></i></a>
							</p>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
				<% PagingVm<NhomVatTu> result = null;
					result = (PagingVm<NhomVatTu>)request.getAttribute("result");
					for(int i = 0; i < result.getTotal(); i++) { 
						if(i == result.getCurrentPage()){%>
							<li><a href="nhomvattu?currentpage=<%= i%>"  style="background-color: #ddd" id="currentPage"><%= i+1 %></a></li>
						<%}else{ %>
							<li><a href="nhomvattu?currentpage=<%= i%>"><%= i+1 %></a></li>
					<%}} %>
			</ul>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var urlParams = new URLSearchParams(window.location.search);
		if(urlParams.has('searchKey') == true){
			$('#searchKey').val(urlParams.get('searchKey'));
		}
	});
	
	function deleteItem(id){
		$.get("${pageContext.request.contextPath}/admin/nhomvattu/deleteItem?id="+id, function(data, status){
	        if(data==='true'){
	        	alert('Xóa thành công');
	        	window.location='${pageContext.request.contextPath}/admin/nhomvattu';
	        }
	    });
	}
	
	function search(){
		var searchKey = $('#searchKey').val();
 		var url = "${pageContext.request.contextPath}/admin/nhomvattu?currentpage=0&searchKey="+searchKey;
 		window.location = url;
	}
</script>



