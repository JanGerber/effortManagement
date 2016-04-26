angular.module('wettEditor').controller(
            'vorlesungCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'alertService' , '$uibModalInstance', 'semesterDataService' , 'vorlesungDataService',
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , alertService , $uibModalInstance, semesterDataService, vorlesungDataService) {
            	
            	$scope.vorlesungList = {};
            	
            	//Vorlesung List laden
            	$scope.loadVorlesungListData = function() {

            		vorlesungDataService.getVorlsungList().then(
							function(response) {
								$scope.vorlesungList = response.data;
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				
		        $scope.loadVorlesungListData();		
								
						
} ]);



