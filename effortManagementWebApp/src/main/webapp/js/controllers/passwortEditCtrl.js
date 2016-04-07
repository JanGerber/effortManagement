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
						function($rootScope, $scope, $http, $routeParams,
								userDataService, $location, $filter,
								$uibModalInstance) {
							$scope.passwort = {
								oldPasswort : "",
								newPasswort : ""
							};

							$scope.closeModal = function() {
								$uibModalInstance.dismiss('');
							};

							$scope.passwortAendern = function() {
								userDataService.changePasswort($scope.passwort)
										.then(function(response) {
											$uibModalInstance.dismiss('');
										}, function(response) {
											// error
										});
							};
						} ]);
