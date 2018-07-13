
'use strict';
angular.module('GymLife.MassimaliMisurazioniModule')
        .service('MassimaliMisurazioniService', function ($http) {
            return {

                nuovoMassimale: function (ese) {
                    return $http.post('GymLife/massimali_misurazioni/nuovoMassimale' ,ese);
                },

                nuovoMisurazione: function (nuovoMisurazione) {
                    return $http.post('GymLife/massimali_misurazioni/nuovoMisurazione' ,nuovoMisurazione);
                }
            }

        });