angular.module('wettEditor').service('vorlesungDataService',[ '$http', '$location' ,
															function($http , $location) {
    var srv = {};

    srv._baseUrl = $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/resteffmanage/vorlesung';

    //new Vorlesung
    srv.newVorlesung = function(vorlesung) {
		return $http.post( srv._baseUrl + "/" , vorlesung); 
    };
    //get alle Noten 
    srv.getNotenList = function(semesterId) {
		return $http.get( srv._baseUrl + "/list/" + semesterId + "/noten"); 
    };
    //get Vorlesung
    srv.getVorlesungById = function(vorlesungId) {
		return $http.get( srv._baseUrl + "/" +  vorlesungId); 
    };
    //put Aufwand
    srv.putAufwand = function(vorlesungId, aufwand) {
    	console.log(vorlesungId + aufwand);
		return $http.put( srv._baseUrl + "/" +  vorlesungId + "/aufwand", aufwand); 
    };
    //get Aufwand
    srv.getAufwandById = function(vorlesungId) {
		return $http.get( srv._baseUrl +"/" + vorlesungId  +"/aufwand"); 
    };  
    //get alle Vorlesung
    srv.getVorlesungList = function(semesterId) {
		return $http.get( srv._baseUrl + "/list/" +  semesterId); 
    };
    
    
    // Public API
    return {
    	newVorlesung: function(vorlesung) {
            return srv.newVorlesung(vorlesung);
        },
        getNotenList: function(semesterId) {
	        return srv.getNotenList(semesterId);
	    },
	    getVorlesungById: function(vorlesungId) {
            return srv.getVorlesungById(vorlesungId);
        },
        putAufwand: function(vorlesungId, aufwand) {
	        return srv.putAufwand(vorlesungId, aufwand);
	    },
	    getAufwandById: function(vorlesungId) {
            return srv.getAufwandById(vorlesungId);
        },
        getVorlesungList: function(semesterId) {
            return srv.getVorlesungList(semesterId);
        }
   
    };
}]);