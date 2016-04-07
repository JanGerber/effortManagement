angular.module('wettEditor').controller(
            'semesterEditCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'semesterDataService' , 'semesterId',
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , semesterDataService, semesterId) {
	            	$scope.closeModal = function(){
						$uibModalInstance.dismiss('');
					}

					
								
						
                    } ]);



