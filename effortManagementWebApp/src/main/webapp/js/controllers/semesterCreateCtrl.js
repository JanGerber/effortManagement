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
            	
            	$scope.closeModal = function(){
					$uibModalInstance.dismiss('');
				}
				
            	$rootScope.closeAlert = alertService.closeAlert; 
            	
            	$scope.newSemester = function() {

            		semesterDataService.newSemester($scope.semester).then(
							function(response) {
								$uibModalInstance.dismiss('created');
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
								
						
                    } ]);



