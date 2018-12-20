<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="~/Scripts/angular.min.js"></script>
<script src="~/Scripts/angular-animate.min.js"></script>
<script src="~/Scripts/angular-sanitize.min.js"></script>
<script src="~/Scripts/ui-bootstrap-tpls-2.5.0.min.js"></script>
<script src="~/Scripts/dynamic-number.min.js"></script>
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
<div class="row" ng-app="salesPromotionApp" ng-controller="salesPromotionAddCtrl">
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
                            <td class="text-left">{{item.MAVATTU}}</td>
                            <td class="text-left">{{item.TENVATTU}}</td>
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
                <h4>Thêm mới chương trình khuyễn mãi</h4>
            </div>
            <div class="panel-body">
                <div class="modal-body" ng-form name="_form">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="form-group">
                                <div class="md-style-label-input" style="padding-bottom: 10px;">
                                    Mã chương trình
                                    <span style="color: red">(*)</span>
                                </div>
                                <div class="md-4-style-input">
                                    <input class="form-control" type="text" ng-model="target.SalesPromotionCode" maxlength="50" name="SalesPromotionCode" required disabled style="text-align:center" />
                                    <span style="color: red" ng-show="_form.SalesPromotionCode.$dirty && _form.SalesPromotionCode.$invalid">
                                        <span ng-show="_form.SalesPromotionCode.$error.required">Không được để trống</span>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-9">
                            <div class="form-group">
                                <div class="md-style-label-input" style="padding-bottom: 10px;">
                                    Tên chương trình
                                    <span style="color: red">(*)</span>
                                </div>
                                <div class="md-4-style-input">
                                    <input class="form-control" type="text" ng-model="target.SalesPromotionName" maxlength="255" name="SalesPromotionName" required style="text-align:center" />
                                    <span style="color: red" ng-show="_form.SalesPromotionName.$dirty && _form.SalesPromotionName.$invalid">
                                        <span ng-show="_form.SalesPromotionName.$error.required">Không được để trống</span>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <div class="md-style-label-input" style="padding-bottom: 10px;">
                                                Ngày bắt đầu chương trình<span style="color: red">(*)</span>
                                            </div>
                                            <div class="md-4-style-input">
                                                <p class="input-group">
                                                    <input type="text" class="form-control" uib-datepicker-popup="dd/MM/yyyy" ng-model="target.SalesPromotionStartTime" name="SalesPromotionStartTime" placeholder="dd/MM/yyyy" is-open="SalesPromotionStartTime.opened" close-text="Close" required />
                                                    <span class="input-group-btn">
                                                        <button type="button" class="btn btn-default" ng-click="SalesPromotionStartTime.opened = true"><i class="glyphicon glyphicon-calendar"></i></button>
                                                    </span>
                                                </p>
                                                <span style="color: red" ng-show="_form.SalesPromotionStartTime.$dirty && _form.SalesPromotionStartTime.$invalid">
                                                    <span ng-show="_form.SalesPromotionStartTime.$error.required">Không được để trống</span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <div class="md-style-label-input" style="padding-bottom: 10px;">
                                                Giờ bắt đầu chương trình<span style="color: red">(*)</span>
                                            </div>
                                            <div class="md-4-style-input">
                                                <div uib-timepicker ng-model="salesPromotionStartTime" name="salesPromotionStartTime" ng-change="changedSalesPromotionStartTime()" show-spinners="false" show-meridian="false" required></div>
                                                <span style="color: red" ng-show="_form.salesPromotionStartTime.$dirty && _form.salesPromotionStartTime.$invalid">
                                                    <span ng-show="_form.salesPromotionStartTime.$error.required">Không được để trống</span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <div class="md-style-label-input" style="padding-bottom: 10px;">
                                                Ngày kết thúc chương trình<span style="color: red">(*)</span>
                                            </div>
                                            <div class="md-4-style-input">
                                                <p class="input-group">
                                                    <input type="text" class="form-control" uib-datepicker-popup="dd/MM/yyyy" ng-model="target.SalesPromotionEndTime" name="SalesPromotionEndTime" placeholder="dd/MM/yyyy" is-open="SalesPromotionEndTime.opened" close-text="Close" required />
                                                    <span class="input-group-btn">
                                                        <button type="button" class="btn btn-default" ng-click="SalesPromotionEndTime.opened = true"><i class="glyphicon glyphicon-calendar"></i></button>
                                                    </span>
                                                </p>
                                                <span style="color: red" ng-show="_form.SalesPromotionEndTime.$dirty && _form.SalesPromotionEndTime.$invalid">
                                                    <span ng-show="_form.SalesPromotionEndTime.$error.required">Không được để trống</span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <div class="md-style-label-input" style="padding-bottom: 10px;">
                                                Giờ kết thúc chương trình<span style="color: red">(*)</span>
                                            </div>
                                            <div class="md-4-style-input">
                                                <div uib-timepicker ng-model="salesPromotionEndTime" name="salesPromotionEndTime" ng-change="changedSalesPromotionEndTime()" show-spinners="false" show-meridian="false" required></div>
                                                <span style="color: red" ng-show="_form.salesPromotionEndTime.$dirty && _form.salesPromotionEndTime.$invalid">
                                                    <span ng-show="_form.salesPromotionEndTime.$error.required">Không được để trống</span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="md-style-label-input">
                                    Nội dung
                                </div>
                                <div class="md-6-style-input">
                                    <textarea class="form-control" rows="3" id="Content" ng-model="target.Content" maxlength="500"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <table class="table table-bordered table-hover table-condensed" arrow-selector data-item-target="dataDetails">
                        <thead>
                            <tr style="font-weight: bold">
                                <th style="width:3%;font-size: 12px;" class="text-center">STT</th>
                                <th style="width:15%;font-size: 12px;" class="text-center">Mã hàng</th>
                                <th style="width:25%;font-size: 12px;" class="text-center">Tên hàng</th>
                                <th style="width:15%;font-size: 12px;" class="text-center">Đơn giá</th>
                                <th style="width:10%;font-size: 12px;" class="text-center">Tỷ lệ KM (%)</th>
                                <th style="width:10%;font-size: 12px;" class="text-center">Tiền KM</th>
                                <th style="width:15%;font-size: 12px;" class="text-center">Đơn giá sau KM</th>
                                <th style="width:auto"></th>
                            </tr>
                        </thead>
                        <tbody ng-form name="_formAddDetail">
                            <tr style="background:rgba(119, 119, 119, 0.48)" ng-enter="addRow()">
                                <td style="text-align:center;"></td>
                                <td>
                                    <input id="MerchandiseCode" class="form-control" type="text" ng-blur="blurMerchandiseCode(newItem.MerchandiseCode);" style="width:100%;text-align:center;font-size:18px;" name="MerchandiseCode" ng-model="newItem.MerchandiseCode" maxlength="50" />
                                </td>
                                <td style="font-size:16px;">
                                    <input id="MerchandiseName" class="form-control" type="text" style="width:100%;text-align:center;font-size:18px;" name="MerchandiseName" ng-model="newItem.MerchandiseName" readonly />
                                </td>
                                <td>
                                    <input class="form-control" type="text" style="text-align:right; width:100%;font-size:16px;" ng-model="newItem.UnitPrice" awnum="number" readonly />
                                </td>
                                <td style="font-size:16px;">
                                    <input id="DiscountPercentage" class="form-control" type="number" ng-change="changeDiscountPercentage(newItem)" style="width:100%; text-align:center; font-size:18px;" name="DiscountPercentage" ng-model="newItem.DiscountPercentage" />
                                </td>
                                <td>
                                    <input id="DiscountMoney" class="form-control" type="text" style="text-align:right; width:100%; font-size:16px;" ng-model="newItem.DiscountMoney" awnum="number" readonly>
                                </td>
                                <td>
                                    <input id="UnitPriceAfterDiscount" class="form-control" type="text" style="text-align:right; width:100%; font-size:16px;" ng-model="newItem.UnitPriceAfterDiscount" awnum="number" readonly>
                                </td>
                                <td style="text-align: center;">
                                    <a class="btn btn-info btn-xs" title="Thêm" ng-click="addRow()"> <i class="fa fa-plus"></i></a>
                                </td>
                            </tr>
                        </tbody>
                        <tbody ng-form name="_formDetail">
                            <tr ng-repeat="item in target.Details track by $index" style="font-size:16px;">
                                <td class="text-center">{{$index + 1}}</td>
                                <td style="text-align:center;font-size:18px;">
                                    <input id="MerchandiseCode" class="form-control" type="text" style="width:100%;text-align:center;font-size:18px;" name="MerchandiseCode" ng-model="item.MerchandiseCode" maxlength="50" required />
                                    <span style="color: red" ng-show="_formDetail.MerchandiseCode.$dirty && _formDetail.MerchandiseCode.$invalid">
                                        <span ng-show="_formDetail.MerchandiseCode.$error.required">Không được để trống</span>
                                    </span>
                                </td>
                                <td style="font-size:16px;">
                                    <input id="MerchandiseName" class="form-control" type="text" style="width:100%;text-align:center;font-size:18px;" name="MerchandiseName" ng-model="item.MerchandiseName" readonly />
                                </td>
                                <td>
                                    <input class="form-control" type="text" style="text-align:right; width:100%;font-size:16px;" ng-model="item.UnitPrice" awnum="number" readonly />
                                </td>
                                <td style="font-size:16px;">
                                    <input id="DiscountPercentage" class="form-control" type="number" ng-change="changeDiscountPercentage(item)" style="width:100%; text-align:center; font-size:18px;" name="DiscountPercentage" ng-model="item.DiscountPercentage" required />
                                    <span style="color: red" ng-show="_formDetail.DiscountPercentage.$dirty && _formDetail.DiscountPercentage.$invalid">
                                        <span ng-show="_formDetail.DiscountPercentage.$error.required">Không được để trống</span>
                                    </span>
                                </td>
                                <td>
                                    <input id="DiscountMoney" class="form-control" type="text" style="text-align:right; width:100%; font-size:16px;" ng-model="item.DiscountMoney" awnum="number" readonly>
                                </td>
                                <td>
                                    <input id="UnitPriceAfterDiscount" class="form-control" type="text" style="text-align:right; width:100%; font-size:16px;" ng-model="item.UnitPriceAfterDiscount" awnum="number" readonly>
                                </td>
                                <td style="text-align: center;">
                                    <a class="btn btn-info btn-xs" title="Xóa" ng-click="removeItem($index)"> <i class="fa fa-minus"></i></a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button prevent-default type="submit" class="btn btn-primary" ng-disabled="_form.$invalid || _formDetail.$invalid" ng-click="save()">
                        <i class="fa fa-save"></i>&nbsp;&nbsp;Lưu lại
                    </button>
                    <button prevent-default class="btn btn-default" onclick="history.go(-1); return false;"><i class="fa fa-arrow-left"></i>&nbsp;&nbsp;Quay lại</button>
                </div>
            </div>
        </div>
    </div>
    <script src="~/Scripts/controller/salesPromotionController.js"></script>
</div>