angular.module('wettEditor').controller(
            'registrierenCtrl',
            [ '$rootScope', '$scope','$http', '$filter','$location', 'userDataService' ,'alertService', '$uibModalInstance',
                    function($rootScope, $scope, $http, $filter, $location , userDataService , alertService, $uibModalInstance) {
            	$rootScope.closeAlert = alertService.closeAlert; 
            	    

} ]);

