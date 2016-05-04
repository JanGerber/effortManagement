angular.module('wettEditor').controller(
            'vorlesungCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'alertService' , '$uibModal', 'semesterDataService' , 'vorlesungDataService',
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , alertService , $uibModal, semesterDataService, vorlesungDataService) {
            	
            	$scope.aktuelleSemesterId = null;
            	$scope.vorlesungList = [];
            	console.log(($scope.vorlesungList.length !== 0) );
            	console.log(($scope.vorlesungList) );
            	$scope.aktuelleSemesterId = $routeParams.semesterId;
            	
            	
            	//Modal oeffnen neues Vorlesung
            	$scope.newVorlesung = function() {

					var modalInstance = $uibModal.open({
						animation : $scope.animationsEnabled,
						templateUrl : 'pages/vorlesungCreate.html',
						controller : 'vorlesungCreateCtrl',
						size : 'lg',
						resolve : {
							semesterId : function() {
								return $scope.aktuelleSemesterId;
							}
						}
					});
					
					modalInstance.result.then(function (selectedItem) {
				    }, function () {
				    	$scope.loadVorlesungListData($scope.aktuelleSemesterId);	
				    });
				};
				
				//Modal oeffnen Vorlesung Aufwand buchen
				$scope.aufwandBuchen = function(vorlesungId) {

					var modalInstance = $uibModal.open({
						animation : $scope.animationsEnabled,
						templateUrl : 'pages/vorlesungBucheAufwand.html',
						controller : 'vorlesungBucheAufwandCtrl',
						size : 'lg',
						resolve : {
							vorlesungId : function() {
								return vorlesungId;
							}
						}
					})
					
					modalInstance.result.then(function (selectedItem) {
					    }, function () {
					    	$scope.loadVorlesungListData($scope.aktuelleSemesterId);	
					    });
				};
				//Vorlesung loeschen
				$scope.deleteVorlesung = function(vorlesungId){
					
				}
            	//Modal oeffnen neues Semester
            	$scope.newSemester = function() {

					var modalInstance = $uibModal.open({
						animation : $scope.animationsEnabled,
						templateUrl : 'pages/semesterCreate.html',
						controller : 'semesterCreateCtrl',
						size : 'lg',
						
					});
					
					modalInstance.result.then(function (selectedItem) {
				    }, function () {
				    	$scope.loadSemesterListData();	
				    });
				};
				
				//Semester List laden
            	$scope.loadSemesterListData = function() {

            		semesterDataService.getSemesterList().then(
							function(response) {
								$scope.semesterList = response.data;
								$scope.loadVorlesungListData($scope.aktuelleSemesterId);
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				
				$scope.loadSemesterListData();
				
				
				//Vorlesung List laden
            	$scope.loadVorlesungListData = function(semesterId) {
            		
            		vorlesungDataService.getVorlesungList(semesterId).then(
							function(response) {
								$scope.vorlesungList = response.data;
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				
				
				//Aktuelles Semester bestimmen
				$scope.changeSemester = function() {
					$scope.vorlesungList = [];
					$scope.loadVorlesungListData($scope.aktuelleSemesterId);
				};
} ]);



