angular.module('wettEditor').controller(
            'notenUebersichtCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'alertService' , '$uibModal', 'semesterDataService' , 'vorlesungDataService',
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , alertService , $uibModal, semesterDataService, vorlesungDataService) {
            	
            	$scope.aktuelleSemesterId = null;
            	$scope.avarage = {
            			angestrebteNote : 0,
            			erhalteneNote : 0
            	};
            	
            	$scope.vorlesungList = [];
            	//Vorlesung List laden
            	$scope.loadVorlesungListData = function(semesterId) {
            		
            		vorlesungDataService.getVorlesungList(semesterId).then(
							function(response) {
								$scope.vorlesungList = response.data;
								calcAvarage();
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				
				$scope.changeSemester = function(semesterId){
					$scope.loadVorlesungListData($scope.aktuelleSemesterId );					
				};
            	
				
				calcAvarage = function(){
					var AnzErhalteneNote  = 0;
					var gesamtErhalteneNote = 0;
					var AnzAngestrebteNote  = 0;
					var gesamtAngestrebteNote = 0;
					
					console.log($scope.vorlesungList);
					
					for (index in $scope.vorlesungList) {

						AnzAngestrebteNote++;
						gesamtAngestrebteNote += $scope.vorlesungList[index].angestrebteNote;
					    if ($scope.vorlesungList[index].erhalteneNote !== 0){
					    	AnzErhalteneNote++;
					    	gesamtErhalteneNote += $scope.vorlesungList[index].endNote;
					    }
					}
					$scope.avarage.angestrebteNote = gesamtAngestrebteNote / AnzAngestrebteNote;
					$scope.avarage.erhalteneNote = gesamtErhalteneNote / AnzErhalteneNote;
					
				}; 
								
						
} ]);



