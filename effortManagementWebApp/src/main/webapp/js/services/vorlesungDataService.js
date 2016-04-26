angular.module('wettEditor').service('vorlesungDataService',[ '$http', '$location' ,
															function($http , $location) {
    var srv = {};

    srv._baseUrl = $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/resteffmanage';

    //new Vorlesung
    srv.newVorlesung = function(vorlesung) {
		return $http.post( srv._baseUrl + "/" , vorlesung); 
    };
    //get alle Noten 
    srv.getNotenList = function(semesterId) {
		return $http.get( srv._baseUrl + "/list/" + semesterId + "/noten"); 
    };
    //get Vorlesung
    srv.getVorlesungById = function(vorlesung) {
		return $http.get( srv._baseUrl + "/" +  vorlesungId); 
    };
    //put Aufwand
    srv.putAufwand = function(vorlesungId, aufwand) {
		return $http.put( srv._baseUrl + "/" +  vorlesungId + "/aufwand", aufwand); 
    };
    //get Aufwand
    srv.getAufwandById = function(vorlesungId) {
		return $http.get( srv._baseUrl + vorlesungId  +"/aufwand"); 
    };  
    //get alle Vorlesung
    srv.getVorlesungList = function(semesterId) {
		return $http.get( srv._baseUrl + "/list/" +  semesterId); 
    };
    
    
    // Public API
    return {
    	newVorlesung: function() {
            return srv.getSemesterList();
        },
        getNotenList: function(semesterId) {
	        return srv.getSemesterById(semesterId);
	    },
	    getVorlesungById: function(semesterId) {
            return srv.deleteSemester(semesterId);
        },
        putAufwand: function(semesterId, semester) {
	        return srv.changeSemester(semesterId, semester);
	    },
	    getAufwandById: function(semester) {
            return srv.newSemester(semester);
        },
        getVorlesungList: function(semester) {
            return srv.newSemester(semester);
        }
   
    };
}]);