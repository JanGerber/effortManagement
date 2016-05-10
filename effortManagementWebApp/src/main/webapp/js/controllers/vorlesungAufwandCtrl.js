angular.module('wettEditor').controller(
            'vorlesungAufwandCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'alertService' , '$uibModal', 'semesterDataService' , 'vorlesungDataService',
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , alertService , $uibModal, semesterDataService, vorlesungDataService) {
            	
            	$scope.aktuelleSemesterId = null;
            	$scope.aktuelleVorlesungId = null;
            	$scope.aufwand = null;
            	
            	$scope.changeSemester = function(){
            		console.log("Change Semester: " + $scope.aktuelleSemesterId);
            		vorlesungDataService.getVorlesungList($scope.aktuelleSemesterId).then(
							function(response) {
								$scope.vorlesungList = response.data;
								console.log($scope.vorlesungList);
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
            	};
            	$scope.showAufwand = function(){
            		vorlesungDataService.getAufwandById($scope.aktuelleVorlesungId).then(
							function(response) {
								$scope.aufwand = response.data;
								console.log($scope.aufwand);
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
            	};
            	
            	
								
						
} ]);



