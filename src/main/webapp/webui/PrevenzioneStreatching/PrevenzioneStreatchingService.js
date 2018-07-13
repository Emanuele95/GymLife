angular.module('GymLife.PrevenzioneStreatchingModule')
        .service('PrevenzioneStreatchingService', function ($http) {
            return {

                fisioterapia: function (fisioterapia) {
                    return $http.post('GymLife/fisioterapia', fisioterapia);
                }
            }
        });