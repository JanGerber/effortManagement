angular.module('wettEditor').controller(
            'registrierenCtrl',
            [ '$rootScope', '$scope','$http', '$filter','$location', 'userDataService' ,'alertService', '$uibModalInstance',
                    function($rootScope, $scope, $http, $filter, $location , userDataService , alertService, $uibModalInstance) {
            	$rootScope.closeAlert = alertService.closeAlert; 
            	
            	$scope.user = {
            			userName : '',
            			passwort : '',
            			hochschule : '',
            			email : ''
            	}
            	
            	$scope.closeModal = function(){
					$uibModalInstance.dismiss('');
				}
            	
            	$scope.userRegistrieren = function(){
            		userDataService.newUser($scope.user).then(
							function(response) {
								$uibModalInstance.dismiss('created');
								$rootScope.globalUser.userName = $scope.user.userName;
								$rootScope.globalUser.passwort = $scope.user.passwort;
								$rootScope.userGlobal.userId = $scope.user.userId;
								$rootScope.globalUser.loggedIn = true;
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
            	}
} ]);

