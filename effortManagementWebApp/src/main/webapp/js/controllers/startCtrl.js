angular.module('wettEditor').controller(
            'wettkampfListCtrl',
            [ '$rootScope', '$scope', '$filter', '$http','wettkampfDataService' ,
                    function($rootScope, $scope, $filter, $http, wettkampfDataService) {
            			
						wettkampfDataService.getAllWettkaempfe()	
							.then(function(response) {
								//First function handles success
								$scope.daten = response.data;
							}, function(response) {
								//Second function handles error
								$scope.daten = "Something went wrong";
								$scope.statuscode = response.status;
							});
						

                    } ]);

