angular.module('GymLife.ArchivioModule')
        .service('ArchivioService', function ($http) {
            return {

                archivio_massimale: function (archivio) {
                    return $http.post('GymLife/archivio/archivio_massimale', archivio);
                },
                archivio_misurazione: function (archivio) {
                    return $http.post('GymLife/archivio/archivio_misurazione', archivio);
                },
                archivio_allenamento: function (archivio) {
                    return $http.post('GymLife/archivio/archivio_allenamento', archivio);
                },
                archivio_esercizio: function (esercizio) {
                    return $http.post('GymLife/archivio/archivio_esercizio', esercizio);
                }

            }

        });