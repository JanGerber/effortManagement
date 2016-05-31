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
            		semesterDataService.getSemesterById($rootScope.userGlobal.userId, semesterId).then(
							function(response) {
								$scope.semester = response.data;
								$scope.datepickerStart.datum =  new Date($scope.semester.startDatum);
								$scope.datepickerEnd.datum =  new Date($scope.semester.endDatum);
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				
				
		        //
		        $scope.editSemester = function() {
		        	createSemester.semesterName =  $scope.semester.semesterName;
		        	createSemester.startDatum = $filter('date')($scope.datepickerStart.datum, 'yyyy-MM-dd');
		        	createSemester.endDatum = $filter('date')($scope.datepickerEnd.datum, 'yyyy-MM-dd');
		        	
		        	semesterDataService.changeSemester($rootScope.userGlobal.userId,semesterId,createSemester).then(
							function(response) {
								$uibModalInstance.dismiss('');
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				
				//DATE Picker
				$scope.datepickerStart = {
           			 opened: false,
           			 datum : new Date()
	           	};
	           	$scope.datepickerEnd = {
	             			 opened: false,
	             			 datum : new Date()
	              	};
	              	
	           	$scope.dateOptionsEnd ={
	           		minDate : $scope.datepickerStart.datum
	           	};
	           	$scope.dateOptionsStart = {
	           		maxDate : $scope.datepickerEnd.datum
	           	};
	           	
	           	$scope.openDateStart = function() {
					$scope.dateOptionsStart.maxDate = $scope.datepickerEnd.datum;
				    $scope.datepickerStart.opend = true;
				};
				$scope.openDateEnd = function() {
					$scope.dateOptionsEnd.minDate = $scope.datepickerStart.datum;
				    $scope.datepickerEnd.opend = true;
				};
				
				$scope.loadSemesterData();			
						
} ]);



