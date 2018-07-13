
'use strict';
angular.module('GymLife.RegisterModule')
    .service('RegisterService', function ($http) {
    	
    	return {
    		
    		datiRegistrazione: function(nuovoUtente){
    			return $http.post('GymLife/register' ,nuovoUtente);
    		}
    		
    	}
           
    });
    