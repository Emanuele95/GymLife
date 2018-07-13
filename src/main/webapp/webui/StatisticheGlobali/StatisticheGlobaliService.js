angular.module('GymLife.StatisticheGlobaliModule')
        .service('StatisticheGlobaliService', function ($http) {
            return {

                miglioramento: function (global) {
                    return $http.post('GymLife/statistiche_globali/miglioramento', global);
                },

                votazioni: function (global) {
                    return $http.post('GymLife/statistiche_globali/votazioni', global);
                }

            }

        });