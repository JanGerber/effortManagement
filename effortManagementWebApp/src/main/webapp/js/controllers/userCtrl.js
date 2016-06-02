angular.module('wettEditor').controller(
		'userCtrl',
		['$rootScope','$scope','$location','$routeParams','$http','$timeout','$filter','userDataService', '$uibModal','alertService',
				function($rootScope, $scope, $location, $routeParams, $http,
						$timeout, $filter, userDataService, $uibModal, alertService) {
					
			        $scope.items = ['item1', 'item2', 'item3'];
			        
			        
			        
			        $scope.loadUserData = function() {
						userDataService.getUser($rootScope.userGlobal.userId, $rootScope.userGlobal.userId).then(
								function(response) {
									$scope.user = response.data;
								}, function(response) {
									alertService.add("warning", "This is a warning.");
								});
					};
					
			        $scope.loadUserData();
			        
					$scope.profilAnpassen = function() {

						var modalInstance = $uibModal.open({
							animation : $scope.animationsEnabled,
							templateUrl : 'pages/userEdit.html',
							controller : 'userEditCtrl',
							size : 'lg',
							resolve : {
								items : function() {
									return $scope.items;
								}
							}
						});
						
						modalInstance.result.then(function (selectedItem) {
					    }, function () {
					    	$scope.loadUserData();	
					    });
					};

					$scope.passwortAendern = function() {

						var modalInstance = $uibModal.open({
							animation : $scope.animationsEnabled,
							templateUrl : 'pages/userPasswordEdit.html',
							controller : 'passwortEditCtrl',
							size : 'lg',
							resolve : {
								items : function() {
									return $scope.items;
								}
							}
						});
						
						modalInstance.result.then(function (selectedItem) {
					    }, function () {
					    	$scope.loadUserData();	
					    });

					};

				} ]);
