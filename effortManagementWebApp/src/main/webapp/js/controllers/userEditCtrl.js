angular.module('wettEditor').controller(
            'userEditCtrl',
            [ '$rootScope', '$scope','$http', '$filter','$location', 'userDataService' , '$uibModalInstance',
                    function($rootScope, $scope, $http, $filter, $location , userDataService , $uibModalInstance) {

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
									// error
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
									// error
								});
					};
					
					//Modal schließen
					$scope.closeModal = function() {
						$uibModalInstance.dismiss('');
					}

} ]);

