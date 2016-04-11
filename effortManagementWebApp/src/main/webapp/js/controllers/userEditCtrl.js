angular.module('wettEditor').controller(
            'userEditCtrl',
            [ '$rootScope', '$scope','$http', '$filter','$location', 'userDataService' , '$uibModalInstance','alertService',
                    function($rootScope, $scope, $http, $filter, $location , userDataService , $uibModalInstance,alertService) {
            	    $rootScope.closeAlert = alertService.closeAlert; 
            	    changeUser = {
            	    	userName : "",
            	    	email : "",
            	    	hochschule : "" 
            	    };
            	    $scope.user = {};
			        $scope.loadUserData = function() {
						userDataService.getUser().then(
								function(response) {
									$scope.user = response.data;
								}, function(response) {
									console.log(response);
									alertService.add("warning", response.data.errorMessage);
								});
					};						
						
					$scope.loadUserData();	

					//User editieren 						
					$scope.editUser = function() {
						changeUser.userName = $scope.user.userName;
						changeUser.hochschule = $scope.user.hochschule;
						changeUser.email = $scope.user.email;
						userDataService.changeUser(changeUser).then(
								function(response) {
									$uibModalInstance.dismiss('changed');
								}, function(response) {
									alertService.add("warning", response.data.errorMessage);
								});
					};
					
					//Modal schließen
					$scope.closeModal = function() {
						$uibModalInstance.dismiss('');
					}

} ]);

