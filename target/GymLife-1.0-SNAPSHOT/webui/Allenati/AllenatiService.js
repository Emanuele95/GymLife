angular.module('GymLife.AllenatiModule')
        .service('AllenatiService', function ($http) {
            return {

                massimalipersonali: function (utente) {
                    return $http.post('GymLife/allenati/massimalipersonali', utente);
                },

                salva_ess: function (es_giornata) {
                    return $http.post('GymLife/allenati/salva_ess', es_giornata);
                },

                salva_allenamento: function (allenamento) {
                    return $http.post('GymLife/allenati/salva_allenamento', allenamento);
                }

            }
        }
        );
