angular.module('GymLife.StatisticheGlobaliModule')

        .controller('StatisticheGlobaliController', ['$scope', '$rootScope', '$location', '$http', 'StatisticheGlobaliService', '$window', '$anchorScroll', '$q', function ($scope, $rootScope, $location, $http, StatisticheGlobaliService, $window, $anchorScroll, $q) {
                $scope.utenteLoggato = JSON.parse(JSON.stringify(eval('(' + sessionStorage.getItem('utenteLoggato') + ')')));

                function hours(i) {
                    var today = new Date();
                    data = today.getHours() + i;
                    return data;
                }

                function crea_grafico(dati, dove, colore_grafico, colore_punti) {
                    Morris.Area({
                        element: dove,
                        data: dati,
                        xkey: 'period',
                        ykeys: ['valore'],
                        labels: ['Valore'],
                        pointSize: 5,
                        hideHover: 'auto',
                        resize: true,
                        lineColors: [colore_grafico],
                        pointFillColors: [colore_punti]
                    });
                }
                var global = {
                    id: "%"
                };

                StatisticheGlobaliService.miglioramento(global).then(function (response) {
                    if (response.data.esito === true) {
                        var es = response.data.miglioramento;
                        var array = [];
                        for (var i = 0; i < es.length; i++) {
                            if (es[i]["n_miglioramento"] == 0) {
                                var miglioramento = 0
                            } else {
                                miglioramento = es[i]["miglioramento"] / es[i]["n_miglioramento"];
                            }
                            array.push({
                                period: hours(i + 1) + es[i]["nome"],
                                valore: miglioramento

                            });
                        }
                        crea_grafico(array, "miglioramento_globale", "orange", "brown");
                    } else {
                        document.getElementById("miglioramento_globale").innerHTML = "Nessuno si è allenato";
                    }
                });

                StatisticheGlobaliService.votazioni(global).then(function (response) {
                    if (response.data.esito === true) {
                        var es = response.data.votazioni;
                        console.log(es);
                        var array = [];
                        for (var i = 0; i < es.length; i++) {
                            if (es[i]["n_valutazione"] === 0) {
                                var votazione = 0;
                            } else {
                                votazione = es[i]["valutazione"] / es[i]["n_valutazione"];
                            }
                            array.push({
                                period: hours(i + 1) + es[i]["nome"],
                                valore: votazione
                            });
                        }
                        console.log(array);
                        crea_grafico(array, "votazione_globale", "violet", "black");
                    } else {
                        document.getElementById("votazione_globale").innerHTML = "Nessuno si è allenato";
                    }
                });
            }]);






   