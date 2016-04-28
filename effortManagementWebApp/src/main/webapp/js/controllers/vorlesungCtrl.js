angular.module('wettEditor').controller(
            'vorlesungCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'alertService' , '$uibModal', 'semesterDataService' , 'vorlesungDataService',
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , alertService , $uibModal, semesterDataService, vorlesungDataService) {
            	
            	
            	$scope.vorlesungList = {};
            	
            	$aktuelleSemesterId = $routeParams.semesterId;
            	
            	//Modal oeffnen neues Vorlesung
            	$scope.newVorlesung = function() {

					var modalInstance = $uibModal.open({
						animation : $scope.animationsEnabled,
						templateUrl : 'pages/vorlesungCreate.html',
						controller : 'vorlesungCreateCtrl',
						size : 'lg',
						resolve : {
							semesterId : function() {
								return $aktuelleSemesterId;
							}
						}
					});
					
					modalInstance.result.then(function (selectedItem) {
				    }, function () {
				    	$scope.loadVorlesungListData($aktuelleSemesterId);	
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
					    	$scope.loadVorlesungListData($aktuelleSemesterId);	
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
								$scope.loadAktuellesSemester();
								console.log($scope.semesterList);
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
								$aktuelleSemesterId = semesterId;
								$scope.loadAktuellesSemester();
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				$scope.aktuellesSemester = "kein Semester";
				
				
				//Aktuelles Semester bestimmen
				$scope.loadAktuellesSemester = function() {
					if($aktuelleSemesterId != undefined){
						vorlesungDataService.getVorlesungList($aktuelleSemesterId).then(
								function(response) {
									$scope.vorlesungList = response.data;
									angular.forEach($scope.semesterList, function(value, key) {
										  if(value.semesterId == $aktuelleSemesterId){
											  $scope.aktuellesSemester = value.semesterName;
										  }
										});
								}, function(response) {
									alertService.add("warning", response.data.errorMessage);
								});
					}else{
						var anzElement = true;
						angular.forEach($scope.semesterList, function(value, key) {
							  if(value  != undefined && anzElement == true){
								  anzElement = false;
								  $scope.aktuellesSemester = value.semesterName;
								  $aktuelleSemesterId = value.semesterId;
								  $scope.loadVorlesungListData(value.semesterId);
							  }
							});
				}
				};
} ]);



