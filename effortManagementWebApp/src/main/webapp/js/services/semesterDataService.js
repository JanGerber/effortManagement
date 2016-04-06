angular.module('wettEditor').service('wettkampfDataService',[ '$http', '$location' ,
															function($http , $location) {
    var srv = {};

    srv._baseUrl = $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/jaxtest';

    //get all Semester
    srv.getSemesterList = function() {
		return $http.get( srv._baseUrl + "/semester/"); 
    };
    //get Semester by semesterId
    srv.getSemesterById = function(semesterId) {
		return $http.get( srv._baseUrl + "/semester/" +  semesterId); 
    };
    //delete a Semester
    srv.deleteSemester = function(semesterId) {
		return $http.delete( srv._baseUrl + "/semester/" + semesterId); 
    };
    //change Semester
    srv.changeSemester = function(semesterId, semester) {
		return $http.put( srv._baseUrl + "/semester/" +  semesterId, semester); 
    };
    //new Semester
    srv.newSemester = function(semester) {
		return $http.post( srv._baseUrl + "/semester" , semester); 
    };    

    // Public API
    return {
    	getSemesterList: function() {
            return srv.getSemesterList();
        },
        getSemesterById: function(semesterId) {
	        return srv.getSemesterById(semesterId);
	    },
	    deleteSemester: function(semesterId) {
            return srv.deleteSemester(semesterId);
        },
        changeSemester: function(semesterId, semester) {
	        return srv.changeSemester(semesterId, semester);
	    },
	    newSemester: function(semester) {
            return srv.newSemester(semester);
        }
   
    };
}]);