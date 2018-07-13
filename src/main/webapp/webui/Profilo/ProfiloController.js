angular.module('GymLife.ProfiloModule')

        .controller('ProfiloController', ['$scope', '$rootScope', '$location', '$http', 'ProfiloService', '$window', '$anchorScroll', '$q', function ($scope, $rootScope, $location, $http, ProfiloService, $window, $anchorScroll, $q) {

                $scope.utenteLoggato = JSON.parse(JSON.stringify(eval('(' + sessionStorage.getItem('utenteLoggato') + ')')));
                $scope.massimaleprofilo = ["Panca piana", "Panca Alta", "Panca stretta", "Curl Bilanciere", "Lat Machine", "Lat Machine inversa", "Pressa 45", "Affondi", "Crunch", "Alzate laterali"];
                $scope.MassimaleProfilo = $scope.massimaleprofilo[0];
                $scope.misurazioneprofilo = ["Collo", "Petto", "Braccio", "Vita", "Coscia"];
                $scope.MisurazioneProfilo = $scope.misurazioneprofilo[0];

                if ($scope.utenteLoggato == null) {
                    document.getElementById("graficomassimale").innerHTML = "Fai il login per vedere i grafici relativi ai massimali";
                    document.getElementById("graficomisurazione").innerHTML = "Fai il login per vedere i grafici relativi alle misurazioni";
                    document.getElementById("graficopeso").innerHTML = "Fai il login per vedere i grafici relativi al peso";
                    document.getElementById("graficochiusura").innerHTML = "Fai il login per vedere i grafici relativi alla % di chiusura";
                    document.getElementById("graficointensita").innerHTML = "Fai il login per vedere i grafici relativi all'intensità";
                } else {
                    if ($scope.MassimaleProfilo = $scope.massimaleprofilo[0]) {
                        var max = {
                            username: $scope.utenteLoggato.nome,
                            esercizio: $scope.massimaleprofilo[0]
                        };
                        back_end_massimale(max, $scope.misurazioneprofilo[0]);
                    }
                    if ($scope.MisurazioneProfilo = $scope.misurazioneprofilo[0]) {
                        var mis = {
                            username: $scope.utenteLoggato.nome,
                            parte: $scope.misurazioneprofilo[0]
                        };
                        back_end_misurazione(mis, $scope.misurazioneprofilo[0]);
                    }
                    $('#massimaleprofilo').on('change', function (e) {
                        var optionSelected = $("option:selected", this);
                        var valueSelected = this.value;

                        var max = {
                            username: $scope.utenteLoggato.nome,
                            esercizio: $scope.massimaleprofilo[valueSelected]
                        };
                        back_end_massimale(max, $scope.massimaleprofilo[valueSelected]);
                    });
                    $('#misurazioneprofilo').on('change', function (e) {
                        var optionSelected = $("option:selected", this);
                        var valueSelected = this.value;

                        var mis = {
                            username: $scope.utenteLoggato.nome,
                            parte: $scope.misurazioneprofilo[valueSelected]
                        };
                        back_end_misurazione(mis, $scope.misurazioneprofilo[valueSelected]);
                    });
                    
                      var intensita = {
                        username: $scope.utenteLoggato.nome
                    };
                    back_end_intensita(intensita);

                    var peso = {
                        username: $scope.utenteLoggato.nome,
                        parte: "Peso"
                    };
                    back_end_peso(peso);

                    var chiusura = {
                        username: $scope.utenteLoggato.nome
                    };
                    back_end_chiusura(chiusura);
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

                function back_end_massimale(max, esercizio) {
                    ProfiloService.profilo_massimali(max).then(function (response) {
                        if (response.data.esito === true) {
                            document.getElementById("graficomassimale").innerHTML = "";
                            var es = response.data.massimale;
                            var array = [];
                            for (var i = 0; i < es.length; i++) {
                                array.push({
                                    period: es[i]["data"],
                                    valore: es[i]["valore"]

                                });
                            }
                            crea_grafico(array, "graficomassimale", "orange", "brown");

                        } else {
                            document.getElementById("graficomassimale").innerHTML = "Non ci sono massimali di" + " " + esercizio;
                        }
                    });
                }

                function back_end_misurazione(mis, misurazione) {
                    ProfiloService.profilo_misurazione(mis).then(function (response) {
                        if (response.data.esito === true) {
                            document.getElementById("graficomisurazione").innerHTML = "";
                            var es = response.data.misuarzione;
                            var array = [];
                            for (var i = 0; i < es.length; i++) {
                                array.push({
                                    period: es[i]["data"],
                                    valore: es[i]["valore"]

                                });
                            }
                            crea_grafico(array, "graficomisurazione", "violet", "black");

                        } else {
                            document.getElementById("graficomisurazione").innerHTML = "Non ci sono misurazioni di" + " " + misurazione;
                        }
                    });
                }

                function back_end_peso(peso) {
                    ProfiloService.profilo_peso(peso).then(function (response) {
                        if (response.data.esito === true) {
                            document.getElementById("graficopeso").innerHTML = "";
                            var es = response.data.misuarzione;
                            var array = [];
                            for (var i = 0; i < es.length; i++) {
                                array.push({
                                    period: es[i]["data"],
                                    valore: es[i]["valore"]

                                });
                            }
                            crea_grafico(array, "graficopeso", "grey", "blue");
                        } else {
                            document.getElementById("graficopeso").innerHTML = "Non ci sono misurazioni di" + " " + "Peso";
                        }
                    });
                }

                function back_end_intensita(intensita) {
                    ProfiloService.profilo_intensita(intensita).then(function (response) {
                        if (response.data.esito === true) {
                            document.getElementById("graficointensita").innerHTML = "";
                            $scope.allenamenti = response.data.allenamento;
                            var array = [];
                            for (var i = 0; i < $scope.allenamenti.length; i++) {
                                array.push({
                                    period: $scope.allenamenti[i]["data"],
                                    valore: $scope.allenamenti[i]["intensità"]

                                });
                            }
                            crea_grafico(array, "graficointensita", "red", "black");

                        } else {
                            document.getElementById("graficointensita").innerHTML = "Non ti sei mai allenato con questa applicazione, corri a farlo!";
                        }
                    });
                }

                function back_end_chiusura(chiusura) {
                    ProfiloService.profilo_chiusura(chiusura).then(function (response) {
                        if (response.data.esito === true) {
                            document.getElementById("graficochiusura").innerHTML = "";
                            var es = response.data.esercizio;
                            var durate = []
                            var array = [];
                            var rip_fatte = 0;
                            var rip_totali = 0;
                            for (var i = 0; i < $scope.allenamenti.length; i++) {
                                durate.push($scope.allenamenti[i]["data"])
                            }
                            for (var i = 0; i < durate.length; i++) {
                                for (var j = 0; j < es.length; j++) {
                                    if (es[j]["n_allenamento"] === (i + 1)) {
                                        var rip_fatte = rip_fatte + es[j]["ripetizioni_riuscite"];
                                        var rip_totali = rip_totali + es[j]["ripetizioni_originali"];
                                    }
                                }
                                array.push({
                                    period: durate[i],
                                    valore: ((rip_fatte * 100) / rip_totali)
                                });
                                var rip_fatte = 0;
                                var rip_totali = 0;
                            }
                            crea_grafico(array, "graficochiusura", "green", "blue");
                        } else {
                            document.getElementById("graficochiusura").innerHTML = "Non ti sei mai allenato con questa applicazione, corri a farlo!";
                        }
                    });
                }
            }]);






   