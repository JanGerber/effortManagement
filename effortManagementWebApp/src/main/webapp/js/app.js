   angular.module('wettEditor', ['ngRoute','ui.bootstrap', 'ngAnimate' , 'ngTouch'])
    	.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
        $routeProvider
            .when('/', {
                redirectTo: '/startseite',
            })
            // route for the semester page
            .when('/semester', {
                templateUrl : 'pages/semesterList.html',
                controller  : 'semesterCtrl',
                activetab: 'semester'
            })
			// route for the user page
            .when('/home', {
                templateUrl : 'pages/user.html',
                controller  : 'userCtrl',
                activetab: 'home'
            })
            // route for the start page
            .when('/startseite', {
                templateUrl : 'pages/startseite.html',
                controller  : 'startCtrl',
                activetab: 'startseite'
            })
	        .otherwise({
	            templateUrl: 'pages/404.html',
	        });
        
        	

	}]);