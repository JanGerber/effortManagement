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
					console.log("logUserIn")
					userDataService.loginUser($scope.user).then(
							function(response) {
								console.log($rootScope.userGlobal);
								$rootScope.userGlobal.userName = response.data.userName;
								$rootScope.userGlobal.passwort = response.data.passwort;
								$rootScope.userGlobal.loggedIn = true;
								console.log($rootScope.userGlobal);
								$scope.closeModal();
							}, function(response) {
								console.log(response);
								alertService.add("warning", response.data.errorMessage);
							});
				}
            	
} ]);

