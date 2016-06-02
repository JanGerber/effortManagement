angular.module('wettEditor').controller(
            'mainCtrl',
            [ '$rootScope', '$scope', '$filter', '$route' , 'alertService','semesterDataService', '$window', '$uibModal',
                    function($rootScope, $scope, $filter, $route, alertService, semesterDataService, $window, $uibModal)  {
             			$scope.$route = $route;
             			
             			 $rootScope.closeAlert = alertService.closeAlert; 
             			 
             			 $rootScope.userGlobal = {
             					 userName: '',
             					 passwort: '',
             					 userId: '',
             					 loggedIn: false
             			 }
             			 
             			 $scope.scrollToTop = function(){
             				$window.scrollTo(0, 0);
             			 }
             			 
             			//Semester List laden
             			$rootScope.loadSemesterListData = function() {
             				console.log($rootScope.userGlobal.userId);
                     		semesterDataService.getSemesterList($rootScope.userGlobal.userId).then(
         							function(response) {
         								$scope.semesterList = response.data;
         								console.log($scope.semesterList);
         							}, function(response) {
         								alertService.add("warning", response.data.errorMessage);
         							});
         				};
         				
         					
         		        
                    	//Modal oeffnen Login
                    	$scope.openLogin = function() {
        					var modalInstance = $uibModal.open({
        						animation : $scope.animationsEnabled,
        						templateUrl : 'pages/login.html',
        						controller : 'loginCtrl',
        						size : 'lg',
        					});
        					
        					
        				};
        				
        				
                    	//Modal oeffnen Registrieren
                    	$scope.openRegistrieren = function() {
        					var modalInstance = $uibModal.open({
        						animation : $scope.animationsEnabled,
        						templateUrl : 'pages/registrieren.html',
        						controller : 'registrierenCtrl',
        						size : 'lg',
        					});
        				
        				};
        				$scope.logout = function(){
        					 $rootScope.userGlobal = {
                 					 userName: '',
                 					 passwort: '',
                 					 userId: '',
                 					 loggedIn: false
                 			 };
        				};

         		        
         		        
                    } ]);

