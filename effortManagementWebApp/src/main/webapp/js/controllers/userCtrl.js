angular.module('wettEditor').controller(
		'userCtrl',
		['$rootScope','$scope','$location','$routeParams','$http','$timeout','$filter','userDataService', '$uibModal',
				function($rootScope, $scope, $location, $routeParams, $http,
						$timeout, $filter, userDataService, $uibModal) {
					
			        $scope.items = ['item1', 'item2', 'item3'];
			        
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

					};

				} ]);
