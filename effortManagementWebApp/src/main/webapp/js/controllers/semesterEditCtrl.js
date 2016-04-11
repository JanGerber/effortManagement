angular.module('wettEditor').controller(
            'semesterEditCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'semesterDataService' ,'$uibModalInstance' ,'alertService', 'semesterId',
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , semesterDataService,$uibModalInstance,alertService, semesterId) {
            	$rootScope.closeAlert = alertService.closeAlert; 
            	createSemester ={
            			semesterName : '',
            			startDatum : '',
            			endDatum : '',
            			user_Id	: 0
            	};
            	//Modal schließen
            	$scope.closeModal = function(){
						$uibModalInstance.dismiss('');
				}
            	
            	//Semster laden
            	$scope.loadSemesterData = function() {
            		console.log(semesterId);
            		semesterDataService.getSemesterById(semesterId).then(
							function(response) {
								$scope.semester = response.data;
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				
				$scope.loadSemesterData();
		        //
		        $scope.editSemester = function() {
		        	createSemester.semesterName =  $scope.semester.semesterName;
		        	createSemester.startDatum = $scope.semester.startDatum;
		        	createSemester.endDatum = $scope.semester.endDatum;
		        	
		        	semesterDataService.changeSemester(semesterId,createSemester).then(
							function(response) {
								$uibModalInstance.dismiss('');
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
								
						
} ]);



