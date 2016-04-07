angular.module('wettEditor').controller(
		'passwortEditCtrl',
		[
				'$rootScope',
				'$scope',
				'$http',
				'$routeParams',
				'userDataService',
				'$location',
				'$filter',
				function($rootScope, $scope, $http, $routeParams,
						userDataService, $location, $filter) {

					$scope.closeModal = function() {
						$uibModalInstance.dismiss('');
					}
				} ]);
