angular.module('wettEditor').controller(
            'semesterCreateCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'semesterDataService' ,
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , semesterDataService) {
            		
            	$scope.closeModal = function(){
					$uibModalInstance.dismiss('');
				}
					
								
						
                    } ]);



