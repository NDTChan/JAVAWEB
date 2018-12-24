var app = angular.module('xuatBanApp', ['ngAnimate', 'ngSanitize', 'ui.bootstrap', 'dynamicNumber', 'ui.select']);

app.config(function (dynamicNumberStrategyProvider) {
    dynamicNumberStrategyProvider.addStrategy('number', {
        numInt: 18,
        numFract: 3,
        numSep: '.',
        numPos: true,
        numNeg: true,
        numRound: 'round',
        numThousand: true,
        numThousandSep: ','
    });
});

app.directive('ngEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if (event.which === 13) {
                scope.$apply(function () {
                    scope.$eval(attrs.ngEnter);
                });
                event.preventDefault();
            }
        });
    };
});

app.controller('xuatBanAddCtrl', function ($scope, $http, $uibModal) {
    $scope.target = {
        Details: []
    };
    $scope.TongSoLuong = 0;
    $scope.TongTien = 0;
    
    $scope.addRow = function () {
        if (!$scope.newItem) {
            document.getElementById('MaVatTu').focus();
        } else if (!$scope.newItem.MaVatTu) {
            document.getElementById('MaVatTu').focus();
        } else if (!$scope.newItem.SoLuong) {
            document.getElementById('SoLuong').focus();
        } else {
            $scope.target.Details.push($scope.newItem);
            $scope.newItem = {};
            $scope.TongSoLuong = 0;
            $scope.TongTien = 0;
            $scope.target.Details.forEach(function (v){
            	$scope.TongSoLuong += v.SoLuong;
            	$scope.TongTien += v.ThanhTien;
            });
            document.getElementById('MaVatTu').focus();
        }
    }

    //tạo mã code
    $http({
        method: "GET",
        url: "/SuperMart/admin/xuatban/BuildCode",
        contentType: 'application/json',
        dataType: 'json'
    }).then(function success(response) {
        if (response && response.status === 200 && response.data) {
            $scope.target.MaChungTu = response.data;
        }
    }, function error(response) {
        console.log(response);
    });
    
    $http({
        method: "GET",
        url: "/SuperMart/admin/khachhang/GetAllData",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        headers : {
           'Accept': 'application/json, */*'
         },
    }).then(function success(response) {
        if (response && response.status === 200 && response.data) {
            $scope.lstKhachHang = response.data;
        }
    }, function error(response) {
        console.log(response);
    });

    //change Mã vật tư
    $scope.blurMerchandiseCode = function (maVatTu) {
        if (maVatTu) {
            $http({
                method: "GET",
                url: "/SuperMart/admin/vattu/BlurMaVatTu/" + maVatTu,
                contentType: 'application/json',
                dataType: 'json'
            }).then(function success(response) {
                if (response && response.status === 200 && response.data) {
                    $scope.newItem.MaVatTu = response.data.MaVatTu;
                    $scope.newItem.TenVatTu = response.data.TenVatTu;
                    $scope.newItem.DonGia = response.data.GiaBan;
                    $scope.newItem.SoLuong = $scope.newItem.SoLuong ? $scope.newItem.SoLuong : 1;
                    $scope.newItem.ThanhTien = $scope.newItem.DonGia * $scope.newItem.SoLuong;
                    document.getElementById('SoLuong').focus();
                } else {
                    var modalInstance = $uibModal.open({
                        backdrop: 'static',
                        animation: true,
                        templateUrl: 'SearchMerchandise.html',
                        controller: 'SearchMerchandiseController',
                        resolve: {
                            items: function () {
                                return maVatTu;
                            }
                        }
                    });
                    modalInstance.result.then(function (updatedData) {
                        if (updatedData && updatedData.MaVatTu) {
                            $scope.newItem = {};
                            $scope.newItem.MaVatTu = updatedData.MaVatTu;
                            $scope.newItem.TenVatTu = updatedData.TenVatTu;
                            $scope.newItem.DonGia = updatedData.GiaBan;
                            $scope.newItem.SoLuong = $scope.newItem.SoLuong ? $scope.newItem.SoLuong : 1;
                            $scope.newItem.ThanhTien = $scope.newItem.DonGia * $scope.newItem.SoLuong;
                            document.getElementById('SoLuong').focus();
                        }
                    }, function () { });
                }
            }, function error(response) {
                console.log(response);
            });
        }
    };

    $scope.changeSoLuong = function (item) {
        item.ThanhTien = item.DonGia * item.SoLuong;
        $scope.TongSoLuong = 0;
        $scope.TongTien = 0;
        $scope.target.Details.forEach(function (v){
        	$scope.TongSoLuong += v.SoLuong;
        	$scope.TongTien += v.ThanhTien;
        });
    };

    $scope.removeItem = function (index) {
        $scope.target.Details.splice(index, 1);
        $scope.TongSoLuong = 0;
        $scope.TongTien = 0;
        $scope.target.Details.forEach(function (v){
        	$scope.TongSoLuong += v.SoLuong;
        	$scope.TongTien += v.ThanhTien;
        });
    };

    $scope.save = function () {
        if ($scope.target.Details.length > 0) {
            angular.forEach($scope.target.Details, function (value) {
                value.MaChungTu = $scope.target.MaChungTu;
            });
            $scope.target.NgayChungTu = new Date();
            $http.post("/SuperMart/admin/xuatban/Post", $scope.target).then(function success(response) {
            	if (response.data) {
                    $.toast({
                        heading: 'Success',
                        text: 'Thành công !',
                        showHideTransition: 'slide',
                        icon: 'success',
                        afterHidden: function () {
                            window.location.href = window.location.origin + "SuperMart/admin/xuatban";
                        }
                    });
            	} else {
            		$.toast({
                        heading: 'Error',
                        text: 'Thất bại !',
                        showHideTransition: 'slide',
                        icon: 'error'
                    });
            	}
            }, function error(response) {
                console.log(response);
            });
        } else {
            alert("Yêu cầu nhập các mặt hàng Xuất bán!");
        }
    };
});

app.controller('salesPromotionEditCtrl', function ($scope, $http, $uibModal) {
    $scope.target = {
        Details: [],
        DeleteList: []
    };

    var url = new URL(window.location.href);
    $http({
        method: "GET",
        url: "/Admin/SalesPromotion/GetDetails/" + parseInt(url.toString().substring(url.toString().lastIndexOf("/") + 1)),
        contentType: 'application/json',
        dataType: 'json'
    }).then(function success(response) {
        if (response && response.status === 200 && response.data && response.data.data) {
            $scope.target = response.data.data;
            $scope.target.SalesPromotionStartTime = new Date(parseInt(response.data.data.SalesPromotionStartTime.substr(6)));
            $scope.target.SalesPromotionEndTime = new Date(parseInt(response.data.data.SalesPromotionEndTime.substr(6)));
            $scope.salesPromotionStartTime = angular.copy($scope.target.SalesPromotionStartTime);
            $scope.salesPromotionEndTime = angular.copy($scope.target.SalesPromotionEndTime);
            console.log($scope.target);
        }
    }, function error(response) {
        console.log(response);
    });

    //addRow
    $scope.changedSalesPromotionStartTime = function () {
        if ($scope.salesPromotionStartTime) {
            $scope.target.SalesPromotionStartTime.setHours($scope.salesPromotionStartTime.getHours());
            $scope.target.SalesPromotionStartTime.setMinutes($scope.salesPromotionStartTime.getMinutes());
            $scope.target.SalesPromotionStartTime.setSeconds(0);
        }
    }

    $scope.changedSalesPromotionEndTime = function () {
        if ($scope.salesPromotionEndTime) {
            $scope.target.SalesPromotionEndTime.setHours($scope.salesPromotionEndTime.getHours());
            $scope.target.SalesPromotionEndTime.setMinutes($scope.salesPromotionEndTime.getMinutes());
            $scope.target.SalesPromotionEndTime.setSeconds(0);
        }
    }

    $scope.addRow = function () {
        if (!$scope.newItem) {
            document.getElementById('MerchandiseCode').focus();
        } else if (!$scope.newItem.MerchandiseCode) {
            document.getElementById('MerchandiseCode').focus();
        } else if (!$scope.newItem.DiscountPercentage) {
            document.getElementById('DiscountPercentage').focus();
        } else {
            $scope.target.Details.push($scope.newItem);
            $scope.newItem = {};
            document.getElementById('MerchandiseCode').focus();
        }
    }

    //change Mã vật tư
    $scope.blurMerchandiseCode = function (maVatTu) {
        if (maVatTu) {
            $scope.parameter = {
                MerchandiseCode: maVatTu
            };
            $http({
                method: "POST",
                url: "/Admin/InputMerchandise/BlurMaVatTu",
                contentType: 'application/json',
                dataType: 'json',
                data: $scope.parameter
            }).then(function success(response) {
                if (response && response.status === 200 && response.data && response.data.data) {
                    $scope.newItem = response.data.data;
                    $scope.newItem.MerchandiseCode = response.data.data.MaVatTu;
                    $scope.newItem.MerchandiseName = response.data.data.TenVatTu;
                    $scope.newItem.UnitPrice = response.data.data.DonGia;
                    $scope.newItem.VALIDATECODE = response.data.data.MaVatTu;
                    document.getElementById('DiscountPercentage').focus();
                } else {
                    var modalInstance = $uibModal.open({
                        backdrop: 'static',
                        animation: true,
                        templateUrl: 'SearchMerchandise.html',
                        controller: 'SearchMerchandiseController',
                        resolve: {
                            items: function () {
                                return maVatTu;
                            }
                        }
                    });
                    modalInstance.result.then(function (updatedData) {
                        if (updatedData && updatedData.MAVATTU) {
                            $scope.newItem = {};
                            $scope.newItem.MerchandiseCode = updatedData.MaVatTu;
                            $scope.newItem.MerchandiseName = updatedData.TenVatTu;
                            $scope.newItem.UnitPrice = updatedData.DonGia;
                            $scope.newItem.VALIDATECODE = updatedData.MaVatTu;
                            document.getElementById('DiscountPercentage').focus();
                        }
                    }, function () { });
                }
            }, function error(response) {
                console.log(response);
            });
        }
    };

    $scope.changeDiscountPercentage = function (item) {
        item.DiscountMoney = parseInt(item.UnitPrice) * parseInt(item.DiscountPercentage) / 100;
        item.UnitPriceAfterDiscount = item.UnitPrice - item.DiscountMoney;
    };

    $scope.removeItem = function (index) {
        if ($scope.target.Details[index].ID) {
            $scope.target.DeleteList.push($scope.target.Details[index]);
        }
        $scope.target.Details.splice(index, 1);
    };


    $scope.save = function () {
        if ($scope.target.Details.length > 0) {
            angular.forEach($scope.target.Details, function (value) {
                value.SalesPromotionCode = $scope.target.SalesPromotionCode;
            });
            console.log($scope.target);
            $http({
                method: "PUT",
                url: "/Admin/SalesPromotion/Put",
                contentType: 'application/json',
                dataType: 'json',
                data: $scope.target
            }).then(function success(response) {
                if (response && response.status === 200 && response.data && response.data.data) {
                    $.toast({
                        heading: 'Success',
                        text: 'Cập nhật thành công !',
                        showHideTransition: 'slide',
                        icon: 'success',
                        afterHidden: function () {
                            window.location.href = window.location.origin + "/Admin/SalesPromotion";
                        }
                    });
                }
            }, function error(response) {
            });
        } else {
            alert("Yêu cầu nhập các mặt hàng khuyến mãi!");
        }
    };
});

app.controller('SearchMerchandiseController', function ($scope, $uibModalInstance, $http, items) {
    if (items) {
        $http({
            method: "GET",
            url: "/SuperMart/admin/vattu/GetInfoMerchandiseByCode/" + items,
            contentType: 'application/json',
            dataType: 'json'
        }).then(function success(response) {
            if (response && response.status === 200 && response.data && response.data && response.data.length > 0) {
                $scope.data = response.data;
            }
        }, function error(response) {
        });
    }
    $scope.selecteItem = function (item) {
        if (item) {
            $uibModalInstance.close(item);
        }
    };
    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
});