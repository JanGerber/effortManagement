angular.module('wettEditor').controller(
            'mainCtrl',
            [ '$rootScope', '$scope', '$filter', '$route' , 'alertService','semesterDataService', '$window', '$uibModal',
                    function($rootScope, $scope, $filter, $route, alertService, semesterDataService, $window, $uibModal)  {
             			$scope.$route = $route;
             			
             			 $rootScope.closeAlert = alertService.closeAlert; 
             			 
             			 $rootScope.userGlobal = {
             					 userName: '',
             					 passwort: '',
             					 loggedIn: false
             			 }
             			 
             			 $scope.scrollToTop = function(){
             				$window.scrollTo(0, 0);
             			 }
             			 
             			//Semester List laden
                     	$scope.loadSemesterListData = function() {

                     		semesterDataService.getSemesterList().then(
         							function(response) {
         								$scope.semesterList = response.data;
         							}, function(response) {
         								alertService.add("warning", response.data.errorMessage);
         							});
         				};
         				
         		        $scope.loadSemesterListData();	
         		        
                    	//Modal oeffnen Login
                    	$scope.openLogin = function() {
                    		console.log("openLogin");
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

         		        
         		        
                    } ]);

