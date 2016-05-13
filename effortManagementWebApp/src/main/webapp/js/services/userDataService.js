angular.module('wettEditor').service('userDataService',[ '$http', '$location' ,
															function($http , $location) {
    var srv = {};

    srv._baseUrl = $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/resteffmanage';

    //get User
    srv.getUser = function() {
		return $http.get( srv._baseUrl + "/user"); 
    };
    //change User
    srv.changeUser = function(user) {
		return $http.put( srv._baseUrl + "/user/", user); 
    };
    //new User
    srv.newUser = function(user) {
		return $http.post( srv._baseUrl + "/", user); 
    };
  //change User
    srv.changePasswort = function(passwort) {
		return $http.put( srv._baseUrl + "/user/passwort", passwort); 
    };
    //login
    srv.loginUser = function(user) {
    	console.log("srvLoginUser");
    	console.log(user);
		return $http({
			  method: 'GET',
			  url: srv._baseUrl + "/user/login",
			  params: {'userName': user.userName, 'passwort': user.passwort},
			});
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
        changePasswort: function(passwort) {
            return srv.changePasswort(passwort);
        },
        loginUser: function(user) {
            return srv.loginUser(user);
        }
  
    };
}]);