var app = angular.module('nhapMuaApp', ['ngAnimate', 'ngSanitize', 'ui.bootstrap', 'dynamicNumber', 'ui.select']);

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

app.controller('nhapMuaAddCtrl', function ($scope, $http, $uibModal) {
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
        url: "/SuperMart/admin/nhapmua/BuildCode",
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
        url: "/SuperMart/admin/nhacungcap/GetAllData",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        headers : {
           'Accept': 'application/json, */*'
         },
    }).then(function success(response) {
        if (response && response.status === 200 && response.data) {
            $scope.lstNCC = response.data;
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
            console.log('$scope.target', $scope.target);
            var form_data = new FormData();

            for ( var key in $scope.target ) {
                form_data.append(key, item[key]);
            }

            $.ajax({
                url         : '/SuperMart/api/test',
                data        : form_data,
                processData : false,
                contentType : false,
                type: 'POST'
            }).done(function(data){
            	console.log('data', data);
                // do stuff
            })
            /*$http.post("/SuperMart/api/test", JSON.stringify($scope.target)).then(function success(response) {
            	console.log('response', response);
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
            });*/
        } else {
            alert("Yêu cầu nhập các mặt hàng Xuất bán!");
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