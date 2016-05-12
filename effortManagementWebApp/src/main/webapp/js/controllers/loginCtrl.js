angular.module('wettEditor').controller(
            'loginCtrl',
            [ '$rootScope', '$scope','$http', '$filter','$location', 'userDataService' ,'alertService' , '$uibModalInstance',
                    function($rootScope, $scope, $http, $filter, $location , userDataService ,alertService, $uibModalInstance) {
            	$rootScope.closeAlert = alertService.closeAlert; 
            	    
            	$scope.closeModal = function(){
					$uibModalInstance.dismiss('');
				};
            	
} ]);

