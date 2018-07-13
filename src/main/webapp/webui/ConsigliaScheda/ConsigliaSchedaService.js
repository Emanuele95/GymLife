angular.module('GymLife.ConsigliaSchedaModule')
        .service('ConsigliaSchedaService', function ($http) {
            return {

                consigliascheda: function (scheda) {
                    return $http.post('GymLife/consiglia_scheda/consigliascheda', scheda);
                },
                salva_scheda: function (scheda_personale) {
                    return $http.post('GymLife/consiglia_scheda/salva_scheda', scheda_personale);
                },
                schede_personali: function (scheda_personale) {
                    return $http.post('GymLife/schede_personali/schede_personali', scheda_personale);
                },
                votazione: function (votazione) {
                    return $http.post('GymLife/schede_personali/votazione', votazione);
                },

                salva_votazione: function (votazione) {
                    return $http.post('GymLife/schede_personali/salva_votazione', votazione);
                }

            }
        });