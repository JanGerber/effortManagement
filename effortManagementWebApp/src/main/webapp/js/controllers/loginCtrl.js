angular.module('wettEditor').controller(
            'loginCtrl',
            [ '$rootScope', '$scope','$http', '$filter','$location', 'userDataService' ,'alertService' , '$uibModalInstance',
                    function($rootScope, $scope, $http, $filter, $location , userDataService ,alertService, $uibModalInstance) {
            	$rootScope.closeAlert = alertService.closeAlert; 
            	    
            	$scope.closeModal = function(){
					$uibModalInstance.dismiss('');
				};
				
				$scope.user = {
						userName: '',
						passwort: ''
				}
				
				$scope.logUserIn = function(){					
					userDataService.loginUser($scope.user).then(
							function(response) {
								$rootScope.userGlobal.userName = response.data.userName;
								$rootScope.userGlobal.passwort = response.data.passwort;
								$rootScope.userGlobal.userId = response.data.userId;
								$rootScope.userGlobal.loggedIn = true;
								$rootScope.loadSemesterListData();
								$scope.closeModal();
							}, function(response) {
								alertService.add("warning", response.data.errorMessage);
							});
				}
            	
} ]);

