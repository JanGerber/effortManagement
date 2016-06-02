angular.module('wettEditor').controller(
            'semesterCreateCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'alertService' , '$uibModalInstance', 'semesterDataService' ,
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , alertService , $uibModalInstance, semesterDataService) {
            	
            	$scope.semester ={
            			semesterName : '',
            			startDatum : '',
            			endDatum : '',
            			user_Id	: 0
            	};
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
            	
            	$scope.closeModal = function(){
					$uibModalInstance.dismiss('');
				};
				
            	$rootScope.closeAlert = alertService.closeAlert; 
            	
            	$scope.newSemester = function() {
            		$scope.semester.startDatum = $filter('date')($scope.datepickerStart.datum, 'yyyy-MM-dd');
            		$scope.semester.endDatum = $filter('date')($scope.datepickerEnd.datum, 'yyyy-MM-dd');
            		semesterDataService.newSemester($rootScope.userGlobal.userId, $scope.semester).then(
							function(response) {
								$rootScope.loadSemesterListData();
								$uibModalInstance.dismiss('created');
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				
				
				$scope.openDateStart = function() {
					$scope.dateOptionsStart.maxDate = $scope.datepickerEnd.datum;
				    $scope.datepickerStart.opend = true;
				};
				$scope.openDateEnd = function() {
					$scope.dateOptionsEnd.minDate = $scope.datepickerStart.datum;
				    $scope.datepickerEnd.opend = true;
				};
						
                    } ]);



