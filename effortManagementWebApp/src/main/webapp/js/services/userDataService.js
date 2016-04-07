angular.module('wettEditor').service('userDataService',[ '$http', '$location' ,
															function($http , $location) {
    var srv = {};

    srv._baseUrl = $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/jaxtest';

    //get User
    srv.getUser = function() {
		return $http.get( srv._baseUrl + "/user"); 
    };
    //change User
    srv.changeUser = function(user) {
		return $http.put( srv._baseUrl + "/user/", user); 
    };
    //alle Turner
    srv.newUser = function(user) {
		return $http.post( srv._baseUrl + "/", user); 
    };
    

    // Public API
    return {
    	getUser: function() {
            return srv.getUser();
        },
        changeUser: function(user) {
            return srv.changeUser(user);
        },
        newUser: function(user) {
            return srv.newUser(user);
        },
  
    };
}]);