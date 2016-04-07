angular.module('wettEditor').controller(
            'userEditCtrl',
            [ '$rootScope', '$scope','$http', '$filter','$location', 'userDataService' , '$uibModalInstance',
                    function($rootScope, $scope, $http, $filter, $location , userDataService , $uibModalInstance) {
						
						
						

											
					$scope.editUser = function() {
					userDataService.changeUser($scope.user).then(
							function(response) {
								$uibModalInstance.dismiss('changed');
							}, function(response) {
								// error
							});
					};
					$scope.closeModal = function() {
						$uibModalInstance.dismiss('');
					}
						
						
						
						
                    } ]);

