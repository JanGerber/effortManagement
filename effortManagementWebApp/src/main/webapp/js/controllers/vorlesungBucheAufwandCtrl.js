angular.module('wettEditor').controller(
            'vorlesungBucheAufwandCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'alertService' , '$uibModalInstance', 'vorlesungDataService','vorlesungId',
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , alertService , $uibModalInstance, vorlesungDataService, vorlesungId) {
            	
            	$scope.aufwand = {
            			vorlesungId : vorlesungId,
            			zeit : 0
            	}
								
            	$scope.closeModal = function() {
					$uibModalInstance.dismiss('');
				};
				
				//Vorlesung laden
            	$scope.loadVorlesungData = function() {
            		
            		vorlesungDataService.getVorlesungById(vorlesungId).then(
							function(response) {
								$scope.vorlesung = response.data;
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				$scope.loadVorlesungData();
				
				//Buche Aufwand
				$scope.bucheAufwand= function() {	
            		vorlesungDataService.putAufwand(vorlesungId, $scope.aufwand).then(
							function(response) {
								$scope.closeModal();
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
} ]);



