angular.module('wettEditor').controller(
            'semesterCtrl',
            [ '$rootScope', '$scope',  '$http', '$routeParams', 'semesterDataService','alertService', '$location', '$filter', '$uibModal',
                    function($rootScope, $scope,  $http, $routeParams, semesterDataService,alertService, $location , $filter, $uibModal) {
						
            	//Semester List laden
            	$scope.loadSemesterListData = function() {

            		semesterDataService.getSemesterList($rootScope.userGlobal.userId).then(
							function(response) {
								$scope.semesterList = response.data;
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				
		        $scope.loadSemesterListData();	
		        
		      //Semester loeschen
            	$scope.deleteSemester = function(semesterId) {
            		semesterDataService.deleteSemester($rootScope.userGlobal.userId, semesterId).then(
							function(response) {
								$scope.loadSemesterListData();	
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
            		
				};
            	
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
				//Modal oeffnen Semester editieren
				$scope.editSemester = function(semesterId) {

					var modalInstance = $uibModal.open({
						animation : $scope.animationsEnabled,
						templateUrl : 'pages/semesterEdit.html',
						controller : 'semesterEditCtrl',
						size : 'lg',
						resolve : {
							semesterId : function() {
								return semesterId;
							}
						}
					})
					
					modalInstance.result.then(function (selectedItem) {
					    }, function () {
					    	$scope.loadSemesterListData();	
					    });
					

				};
            	
            	
            	
                    } ]);

