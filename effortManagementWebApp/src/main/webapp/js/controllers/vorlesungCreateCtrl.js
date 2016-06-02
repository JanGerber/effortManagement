angular.module('wettEditor').controller(
            'vorlesungCreateCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'alertService' , '$uibModalInstance','semesterId', 'vorlesungDataService' ,'semesterDataService',
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , alertService , $uibModalInstance,  semesterId, vorlesungDataService ,semesterDataService) {
            	
            	$scope.vorlesung = {
            			userId : '',
            			vorlesungName : '',
            	  		aufwand : '',
            	  		geplanterAufwand : '',
            	  		angestrebteNote : '',
            	  		creditPoints : '',
            	  		semesterId : ''
            	};
            	//Modal schliessen
            	$scope.closeModal = function() {
					$uibModalInstance.dismiss('');
				};
				
				//Semester List laden
            	$scope.loadSemesterListData = function() {

            		semesterDataService.getSemesterList($rootScope.userGlobal.userId).then(
							function(response) {
								$scope.semesterList = response.data;
								$scope.vorlesung.semesterId = semesterId;
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				$scope.loadSemesterListData();
				
				//Semester erstellen
            	$scope.vorlesungErstellen = function() {
            		vorlesungDataService.newVorlesung($rootScope.userGlobal.userId, $scope.vorlesung).then(
							function(response) {
								$scope.closeModal();
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				
								
						
} ]);



