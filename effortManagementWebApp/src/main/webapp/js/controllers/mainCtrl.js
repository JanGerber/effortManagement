angular.module('wettEditor').controller(
            'mainCtrl',
            [ '$rootScope', '$scope', '$filter', '$route' , 'alertService','semesterDataService',
                    function($rootScope, $scope, $filter, $route, alertService, semesterDataService)  {
             			$scope.$route = $route;
             			
             			 $rootScope.closeAlert = alertService.closeAlert; 
             			 
             			//Semester List laden
                     	$scope.loadSemesterListData = function() {

                     		semesterDataService.getSemesterList().then(
         							function(response) {
         								$scope.semesterList = response.data;
         							}, function(response) {
         								alertService.add("warning", response.data.errorMessage);
         							});
         				};
         				
         		        $scope.loadSemesterListData();	
         		        
                    } ]);

