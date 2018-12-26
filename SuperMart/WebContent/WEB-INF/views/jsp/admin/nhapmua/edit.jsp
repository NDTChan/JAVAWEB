<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>
#myWorkContent {
	overflow-x: scroll;
	overflow-y: hidden;
	white-space: nowrap;
}

.merchandiseSelected {
	background-color: salmon;
}

.md-style-label-input {
	font-size: 14px;
}

.input-border-form {
	font-size: 16px;
}
</style>

<div class="row" ng-app="nhapMuaApp" ng-controller="nhapMuaEditCtrl">
	<script type="text/ng-template" id="SearchMerchandise.html">
        <div class="modal-header">
            <h2 class="modal-title">Danh sách hàng hóa</h2>
        </div>
        <div class="modal-body">
            <div>
                <table class="table table-striped table-hover no-margin-vertical">
                    <thead>
                        <tr class="headings">
                            <th style="width:10%" class="column-title">STT</th>
                            <th style="width:30%" class="text-left">
                                <a class="title" href="#" ng-click="sortType = 'maHang'; sortReverse = !sortReverse">
                                    Mã hàng
                                    <span ng-show="sortType == 'maHang' && !sortReverse" class="fa fa-caret-down"></span>
                                    <span ng-show="sortType == 'maHang' && sortReverse" class="fa fa-caret-up"></span>
                                </a>
                            </th>
                            <th style="width:50%" class="text-left">
                                <a class="title" href="#" ng-click="sortType = 'tenHang'; sortReverse = !sortReverse">
                                    Tên hàng
                                    <span ng-show="sortType == 'tenHang' && !sortReverse" class="fa fa-caret-down"></span>
                                    <span ng-show="sortType == 'tenHang' && sortReverse" class="fa fa-caret-up"></span>
                                </a>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="even pointer" ng-repeat="item in data" ng-dblclick="selecteItem(item)">
                            <td>{{$index + 1}}</td>
                            <td class="text-left">{{item.MaVatTu}}</td>
                            <td class="text-left">{{item.TenVatTu}}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="modal-footer">
            <button class="btn btn-default" type="button" ng-click="cancel()">cancel</button>
        </div>
    </script>
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4>Sửa phiếu nhập mua</h4>
			</div>
			<div class="panel-body">
				<input id="id" value="${id }" ng-model="target.id" type="hidden"/>
				<div class="modal-body" ng-form="_form">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<div class="md-style-label-input" style="padding-bottom: 10px;">
									Mã chứng từ <span style="color: red">(*)</span>
								</div>
								<div class="md-4-style-input">
									<input class="form-control" type="text"
										ng-model="target.MaChungTu" readonly />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<div class="md-style-label-input" style="padding-bottom: 10px;">
									Nhà cung cấp <span style="color: red">(*)</span>
								</div>
								<div class="md-4-style-input">
									<div class="input-group">
										<ui-select allow-clear theme="bootstrap" name="MaNhaCungCap"
											ng-required="true" ng-model="target.MaNhaCungCap"
											on-select="target.MaNhaCungCap = $model"> <ui-select-match
											placeholder="-Chọn nhà cung cấp">{{$select.selected.MaNhaCungCap}}
										- {{$select.selected.TenNhaCungCap}}</ui-select-match> <ui-select-choices
											repeat="item.MaNhaCungCap as item in lstNCC | filter: $select.search">
										<span
											ng-bind-html="(item.MaNhaCungCap + ' - ' + item.TenNhaCungCap) | highlight: $select.search"></span>
										</ui-select-choices> </ui-select>
										<span class="input-group-btn">
											<button type="button" ng-click="target.MaNhaCungCap = null"
												class="btn btn-default">
												<span class="glyphicon glyphicon-trash"></span>
											</button>
										</span>
									</div>
									<span style="color: red"
										ng-show="_form.MaNhaCungCap.$dirty && _form.MaNhaCungCap.$invalid">
										<span ng-show="_form.MaNhaCungCap.$error.required">Không
											được để trống</span>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<div class="col-md-12">
								<div class="md-style-label-input">Nội dung</div>
								<div class="md-6-style-input">
									<textarea class="form-control" rows="3" id="Content"
										ng-model="target.NoiDung" maxlength="500"></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<table class="table table-bordered table-hover table-condensed"
						arrow-selector data-item-target="dataDetails">
						<thead>
							<tr style="font-weight: bold">
								<th style="width: 3%; font-size: 12px;" class="text-center">STT</th>
								<th style="width: 15%; font-size: 12px;" class="text-center">Mã
									hàng</th>
								<th style="width: 25%; font-size: 12px;" class="text-center">Tên
									hàng</th>
								<th style="width: 20%; font-size: 12px;" class="text-center">Đơn
									giá</th>
								<th style="width: 15%; font-size: 12px;" class="text-center">Số
									lượng</th>
								<th style="width: 20%; font-size: 12px;" class="text-center">Thành
									tiền</th>
								<th style="width: auto"></th>
							</tr>
						</thead>
						<tbody ng-form="_formAddDetail">
							<tr style="background: rgba(119, 119, 119, 0.48)"
								ng-enter="addRow()">
								<td style="text-align: center;"></td>
								<td><input id="MaVatTu" class="form-control" type="text"
									ng-blur="blurMerchandiseCode(newItem.MaVatTu);"
									style="width: 100%; text-align: center; font-size: 18px;"
									name="MaVatTu" ng-model="newItem.MaVatTu" maxlength="50" /></td>
								<td style="font-size: 16px;"><input id="TenVatTu"
									class="form-control" type="text"
									style="width: 100%; text-align: center; font-size: 18px;"
									name="TenVatTu" ng-model="newItem.TenVatTu" readonly /></td>
								<td><input class="form-control" type="text"
									style="text-align: right; width: 100%; font-size: 16px;"
									ng-model="newItem.DonGia" awnum="number" readonly /></td>
								<td style="font-size: 16px;"><input id="SoLuong"
									class="form-control" type="number"
									ng-change="changeSoLuong(newItem)"
									style="width: 100%; text-align: center; font-size: 18px;"
									name="SoLuong" ng-model="newItem.SoLuong" /></td>
								<td><input id="ThanhTien" class="form-control" type="text"
									style="text-align: right; width: 100%; font-size: 16px;"
									ng-model="newItem.ThanhTien" awnum="number" readonly></td>
								<td style="text-align: center;"><a
									class="btn btn-info btn-xs" title="Thêm" ng-click="addRow()">
										<i class="fa fa-plus"></i>
								</a></td>
							</tr>
						</tbody>
						<tbody ng-form="_formDetail">
							<tr ng-repeat="item in target.Details track by $index"
								style="font-size: 16px;">
								<td class="text-center">{{$index + 1}}</td>
								<td style="text-align: center; font-size: 18px;"><input
									id="MaVatTu" class="form-control" type="text"
									style="width: 100%; text-align: center; font-size: 18px;"
									name="MaVatTu" ng-model="item.MaVatTu" maxlength="50" required />
									<span style="color: red"
									ng-show="_formDetail.MaVatTu.$dirty && _formDetail.MaVatTu.$invalid">
										<span ng-show="_formDetail.MaVatTu.$error.required">Không
											được để trống</span>
								</span></td>
								<td style="font-size: 16px;"><input id="TenVatTu"
									class="form-control" type="text"
									style="width: 100%; text-align: center; font-size: 18px;"
									name="TenVatTu" ng-model="item.TenVatTu" readonly /></td>
								<td><input class="form-control" type="text"
									style="text-align: right; width: 100%; font-size: 16px;"
									ng-model="item.DonGia" awnum="number" readonly /></td>
								<td style="font-size: 16px;"><input id="SoLuong"
									class="form-control" type="number"
									ng-change="changeSoLuong(item)"
									style="width: 100%; text-align: center; font-size: 18px;"
									name="SoLuong" ng-model="item.SoLuong" required /> <span
									style="color: red"
									ng-show="_formDetail.SoLuong.$dirty && _formDetail.SoLuong.$invalid">
										<span ng-show="_formDetail.SoLuong.$error.required">Không
											được để trống</span>
								</span></td>
								<td><input id="ThanhTien" class="form-control" type="text"
									style="text-align: right; width: 100%; font-size: 16px;"
									ng-model="item.ThanhTien" awnum="number" readonly></td>
								<td style="text-align: center;"><a
									class="btn btn-info btn-xs" title="Xóa"
									ng-click="removeItem($index)"> <i class="fa fa-minus"></i></a>
								</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" class="text-center">Tổng cộng</td>
								<td style="font-size: 16px;"><input class="form-control" type="text"
									style="text-align: center; width: 100%; font-size: 18px;"
									ng-model="TongSoLuong" awnum="number" readonly></td>
								<td><input class="form-control" type="text"
									style="text-align: right; width: 100%; font-size: 16px;"
									ng-model="TongTien" awnum="number" readonly></td>
							</tr>
						</tfoot>
					</table>
				</div>
				<div class="modal-footer">
					<button prevent-default type="submit" class="btn btn-primary"
						ng-disabled="_form.$invalid || _formDetail.$invalid"
						ng-click="save()">
						<i class="fa fa-save"></i>&nbsp;&nbsp;Lưu lại
					</button>
					<button prevent-default class="btn btn-default"
						onclick="history.go(-1); return false;">
						<i class="fa fa-arrow-left"></i>&nbsp;&nbsp;Quay lại
					</button>
				</div>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/Script/nhapMuaController.js"></script>
</div>