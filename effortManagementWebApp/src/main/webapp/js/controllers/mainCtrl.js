angular.module('wettEditor').controller(
            'mainCtrl',
            [ '$rootScope', '$scope', '$filter', '$route' ,
                    function($rootScope, $scope, $filter, $route)  {
             			$scope.$route = $route;
            			
            			/*
						$scope.page1 = 'active';
						$scope.page2 = '';
						$scope.page3 = '';
						$scope.page4 = '';
						$scope.page5 = '';
						$scope.page6 = '';
						
						
						$scope.changePage = function(page){
							console.log("change Page: " + page);
							switch(page) {
							  case 'page1':
								 $scope.page1 = 'active';
								 $scope.page2 = '';
								 $scope.page3 = '';
								 $scope.page4 = '';
								 $scope.page5 = '';
								 $scope.page6 = '';
								 break;
							  case "page2":
								 $scope.page1 = '';
								 $scope.page2 = 'active';
								 $scope.page3 = '';
								 $scope.page4 = '';
								 $scope.page5 = '';
								 $scope.page6 = '';
								 break;
							  case "page3":
								 $scope.page1 = '';
								 $scope.page2 = '';
								 $scope.page3 = 'active';
								 $scope.page4 = '';
								 $scope.page5 = '';
								 $scope.page6 = '';
								 break;
							  case "page4":
								 $scope.page1 = '';
								 $scope.page2 = '';
								 $scope.page3 = '';
								 $scope.page4 = 'active';
								 $scope.page5 = '';
								 $scope.page6 = '';
								 break;
							  case "page5":
								 $scope.page1 = '';
								 $scope.page2 = '';
								 $scope.page3 = '';
								 $scope.page4 = '';
								 $scope.page5 = 'active';
								 $scope.page6 = '';
								 break;
							  case "page6":
								 $scope.page1 = '';
								 $scope.page2 = '';
								 $scope.page3 = '';
								 $scope.page4 = '';
								 $scope.page5 = '';
								 $scope.page6 = 'active';
								 break;
							  default:
								 console.log('There should not be a default failover at this thing.');
							};
                		};
                        */

                    } ]);

