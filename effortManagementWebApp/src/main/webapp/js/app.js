   angular.module('wettEditor', ['ngRoute','ui.bootstrap', 'ngAnimate' , 'ngTouch'])
    	.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
        $routeProvider
            .when('/', {
                redirectTo: '/home',
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
            .when('/vorlesung', {
                templateUrl : 'pages/vorlesung.html',
                controller  : 'vorlesungCtrl',
                activetab: 'vorlesung'
            })
            // route for the start page
            .when('/vorlesung/:semesterId', {
                templateUrl : 'pages/vorlesung.html',
                controller  : 'vorlesungCtrl',
                activetab: 'vorlesung'
            })
            // route for the start page
            .when('/aufwand', {
                templateUrl : 'pages/vorlesungAufwand.html',
                controller  : 'vorlesungAufwandCtrl',
                activetab: 'aufwand'
            })
            // route for the start page
            .when('/noten', {
                templateUrl : 'pages/notenUebersicht.html',
                controller  : 'notenUebersichtCtrl',
                activetab: 'noten'
            })
	        .otherwise({
	            templateUrl: 'pages/404.html',
	        });
        
        	

	}]);