angular.module('wettEditor').controller(
            'semesterCtrl',
            [ '$rootScope', '$scope',  '$http', '$routeParams', 'semesterDataService', '$location', '$filter', '$uibModal',
                    function($rootScope, $scope,  $http, $routeParams, semesterDataService, $location , $filter, $uibModal) {
						
            	$scope.newSemester = function() {

					var modalInstance = $uibModal.open({
						animation : $scope.animationsEnabled,
						templateUrl : 'pages/semesterCreate.html',
						controller : 'semesterCreateCtrl',
						size : 'lg',
					});
				};

				$scope.editSemester = function(semesterId) {

					var modalInstance = $uibModal.open({
						animation : $scope.animationsEnabled,
						templateUrl : 'pages/semesterEdit.html',
						controller : 'semesterEditCtrl',
						size : 'lg',
						resolve : {
							semesterId : function() {
								return semesterId;
							}
						}
					});

				};
            	
            	
            	
                    } ]);

