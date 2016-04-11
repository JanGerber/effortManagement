angular.module('wettEditor')
		.controller(
				'passwortEditCtrl',
				[
						'$rootScope',
						'$scope',
						'$http',
						'$routeParams',
						'userDataService',
						'$location',
						'$filter',
						'$uibModalInstance',
						'alertService',
						function($rootScope, $scope, $http, $routeParams,
								userDataService, $location, $filter,
								$uibModalInstance, alertService) {
							$scope.passwort = {
								oldPasswort : "",
								newPasswort : ""
							};

							$scope.closeModal = function() {
								$uibModalInstance.dismiss('');
							};
							
							$rootScope.closeAlert = alertService.closeAlert; 

							$scope.passwortAendern = function() {
								userDataService.changePasswort($scope.passwort)
										.then(function(response) {
											$uibModalInstance.dismiss('');
										}, function(response) {
											alertService.add("warning", response.data.errorMessage);
										});
							};
						} ]);
