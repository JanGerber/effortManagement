angular.module('wettEditor').controller(
            'vorlesungEndNoteCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'alertService' , '$uibModalInstance', 'vorlesungDataService','vorlesungId',
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , alertService , $uibModalInstance, vorlesungDataService, vorlesungId) {
            	
            	$scope.endNote = {
            			vorlesungId : vorlesungId,
            			endNote : 0
            	}
								
            	$scope.closeModal = function() {
					$uibModalInstance.dismiss('');
				};
				
				//Vorlesung laden
            	$scope.loadVorlesungData = function() {
            		
            		vorlesungDataService.getVorlesungById($rootScope.userGlobal.userId, vorlesungId).then(
							function(response) {
								$scope.vorlesung = response.data;
								$scope.endNote.endNote = $scope.vorlesung.endNote;
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
				$scope.loadVorlesungData();
				
				//Buche Aufwand
				$scope.endNoteEintragen= function() {	
            		vorlesungDataService.putEndnote($rootScope.userGlobal.userId, vorlesungId, $scope.endNote).then(
							function(response) {
								$scope.closeModal();
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				};
} ]);



