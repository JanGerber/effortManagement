   angular.module('wettEditor', ['ngRoute','ui.bootstrap', 'ngAnimate' , 'ngTouch'])
    	.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
        $routeProvider
            .when('/', {
                redirectTo: '/wettkampf',
            })
            			// route for the contact page
            .when('/wettkampf', {
                templateUrl : 'pages/wettkampfListe.html',
                controller  : 'wettkampfListCtrl',
                activetab: 'wettkampf'
            })
			// route for the contact page
            .when('/turner', {
                templateUrl : 'pages/athlListe.html',
                controller  : 'athlCtrl',
                activetab: 'turner'
            })
            // route for the contact page
            .when('/create/wettkampf', {
                templateUrl : 'pages/createWettkampf.html',
                controller  : 'createWettkampfCtrl',
                activetab: 'wettkampf'
            })
			// route for the contact page
            .when('/mannschaften', {
                templateUrl : 'pages/mannschaften.html',
                controller  : 'mannschaftCtrl',
                activetab: 'mannschaften'
            })
			// route for the contact page
            .when('/upload', {
                templateUrl : 'pages/upload.html',
				controller  : 'uploadCtrl',
				activetab: 'upload'
                
            })
			// route for the contact page
            .when('/wettkampf/:wettkampfId', {
                templateUrl : 'pages/wettkampf.html',
                controller  : 'wettkampfCtrl',
                activetab: 'wettkampf'
            })
            .when('/auswertung/:wettkampfId', {
                templateUrl : 'pages/auswertung.html',
                controller  : 'auswertungCtrl',
                activetab: 'wettkampf'
            })
			// route for the contact page
            .when('/anzeige/:wettkampfId', {
                templateUrl : 'pages/anzeige.html',
				controller  : 'anzeigeCtrl',
				activetab: 'anzeige'
            })
	        .otherwise({
	            templateUrl: 'pages/404.html',
	        });
        
        	//$httpProvider.interceptors.push('HttpInterceptor');

	}]);