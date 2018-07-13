angular.module('GymLife.EserciziModule')
.service('EserciziService', function ($http) {
return {
    		
    		esercizi: function(esercizio){
    			return $http.post('GymLife/esercizi' ,esercizio);
    		}
    		
    	}
        });