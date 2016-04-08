angular.module('wettEditor').controller(
            'mainCtrl',
            [ '$rootScope', '$scope', '$filter', '$route' , 'alertService',
                    function($rootScope, $scope, $filter, $route, alertService)  {
             			$scope.$route = $route;
             			
             			 $rootScope.closeAlert = alertService.closeAlert; 
                    } ]);

