angular.module('GymLife.ProfiloModule')
        .service('ProfiloService', function ($http) {
            return {

                profilo_massimali: function (max) {
                    return $http.post('GymLife/profilo/profilo_massimali', max);
                },

                profilo_misurazione: function (mis) {
                    return $http.post('GymLife/profilo/profilo_misurazione', mis);
                },

                profilo_peso: function (peso) {
                    return $http.post('GymLife/profilo/profilo_peso', peso);
                },
                
                profilo_intensita: function (intensita) {
                    return $http.post('GymLife/profilo/profilo_intensita', intensita);
                },
                
                profilo_chiusura: function (chiusura) {
                    return $http.post('GymLife/profilo/profilo_chiusura', chiusura);
                },
            }

        });