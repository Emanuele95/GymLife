'use strict';
angular.module('GymLife.LoginModule')
    .service('LoginService', function ($http) {
    	
    	return {
    		
    		login: function(utente){
    			return $http.post('GymLife/login' ,utente);
    		}
    		
    	}
           
    });
    
       