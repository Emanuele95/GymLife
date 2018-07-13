angular.module('GymLife.AllenatiModule')

        .controller('AllenatiController', ['$scope', '$rootScope', '$location', '$http', 'AllenatiService', '$window', '$anchorScroll', '$q', function ($scope, $rootScope, $location, $http, AllenatiService, $window, $anchorScroll, $q) {

                $scope.utenteLoggato = JSON.parse(JSON.stringify(eval('(' + sessionStorage.getItem('utenteLoggato') + ')')));

                if ($scope.utenteLoggato !== null) {
                    var utente = {
                        nome: $scope.utenteLoggato.nome
                    };
                }

                var element = document.getElementById("inizio");
                element.style.visibility = "hidden";
                var element2 = document.getElementById("fine");
                element2.style.visibility = "hidden";

                if ($rootScope.cambio == 1) {
                    AllenatiService.massimalipersonali(utente)
                            .then(function (response) {
                                if (response.data.esito === true) {
                                    $rootScope.max = response.data.massimali;
                                }
                            })
                            .then(function () {
                                document.getElementById("scelte").innerHTML = "";
                                var allenamento = [];
                                for (var i = 0; i < $rootScope.tutte.length; i++) {
                                    if ($rootScope.tutte[i]["scheda"]["id"] == $rootScope.Idscheda && $rootScope.tutte[i]["giornata"]["id"] == $rootScope.Idgiorno) {
                                        allenamento.push($rootScope.tutte[i]);
                                        $scope.proprietario = $rootScope.tutte[i]["scheda"]["proprietario"]["id"];
                                        $rootScope.regime = $rootScope.tutte[i]["scheda"]["regime"];
                                    }
                                }
                                var div = document.getElementById("allenamento");
                                var table = document.createElement("TABLE");
                                table.setAttribute("id", "scheda");
                                div.appendChild(table);
                                for (var j = -1; j < allenamento.length; j++) {
                                    var column = document.createElement("TR");
                                    table.appendChild(column);
                                    for (var k = 0; k < 5; k++) {
                                        if (j == -1) {
                                            if (k == 0) {
                                                var row = document.createElement("TH");
                                                var text = document.createTextNode("Esercizio");
                                                row.appendChild(text);
                                                column.appendChild(row);
                                                table.appendChild(row);
                                            }
                                            if (k == 1) {
                                                var row = document.createElement("TH");
                                                var text = document.createTextNode("Ripetizioni Consigliate");
                                                row.appendChild(text);
                                                column.appendChild(row);
                                                table.appendChild(row);
                                            }
                                            if (k == 2) {
                                                var row = document.createElement("TH");
                                                var text = document.createTextNode("Kg Consigliati");
                                                row.appendChild(text);
                                                column.appendChild(row);
                                                table.appendChild(row);
                                            }
                                            if (k == 3) {
                                                var row = document.createElement("TH");
                                                var text = document.createTextNode("Ripetizioni Fatte");
                                                row.appendChild(text);
                                                column.appendChild(row);
                                                table.appendChild(row);
                                            }
                                            if (k == 4) {
                                                var row = document.createElement("TH");
                                                var text = document.createTextNode("Kg Usati");
                                                row.appendChild(text);
                                                column.appendChild(row);
                                                table.appendChild(row);
                                            }
                                        } else {
                                            if (k == 0) {
                                                var row = document.createElement("TD");
                                                var text = document.createTextNode(allenamento[j]["nome"]["nome"]);
                                                row.setAttribute("class", "esercizi");
                                                row.appendChild(text);
                                                column.appendChild(row);
                                                table.appendChild(row);
                                            }
                                            if (k == 1) {
                                                var row = document.createElement("TD");
                                                var text = document.createTextNode(allenamento[j]["n_ripetizioni"]);
                                                row.setAttribute("class", "rip");
                                                row.appendChild(text);
                                                column.appendChild(row);
                                                table.appendChild(row);
                                            }
                                            if (k == 2) {
                                                var valore = trova_proporzione(allenamento[j]["nome"]["nome"], allenamento[j]["n_ripetizioni"]);
                                                var row = document.createElement("TD");
                                                row.setAttribute("class", "kgconsigliati");
                                                var text = document.createTextNode(valore);
                                                row.appendChild(text);
                                                column.appendChild(row);
                                                table.appendChild(row);
                                            }
                                            if (k == 3) {
                                                var row = document.createElement("TD");
                                                var input = document.createElement("INPUT");
                                                input.setAttribute("class", "ripfatte")
                                                row.appendChild(input);
                                                input.setAttribute("type", "number");
                                                input.setAttribute("min", "0");
                                                column.appendChild(row);
                                                table.appendChild(row);
                                            }
                                            if (k == 4) {
                                                var row = document.createElement("TD");
                                                var input = document.createElement("INPUT");
                                                input.setAttribute("class", "kgusati")
                                                row.appendChild(input);
                                                input.setAttribute("type", "number");
                                                input.setAttribute("min", "0");
                                                column.appendChild(row);
                                                table.appendChild(row);
                                                ;
                                            }
                                        }
                                    }
                                }
                                var element = document.getElementById("inizio");
                                element.style.visibility = "visible";
                            });
                }
                $scope.nuovo_allenamento = function () {
                    $location.path('/consiglia_scheda');
                }

                function trova_proporzione(nome, ripetizioni) {
                    var max = 0;
                    var valore = 0;
                    for (var i = 0; i < $rootScope.max.length; i++) {
                        if ($rootScope.max.length === 0) {
                            valore = 0;
                        }
                        if (nome === $rootScope.max[i]["esercizio"]["nome"] && $rootScope.max[i]["n_massimale"] > max) {
                            max = $rootScope.max[i]["n_massimale"];
                            if (ripetizioni === 1) {
                                valore = $rootScope.max[i]["valore"];
                            }
                            if (ripetizioni === 2 || ripetizioni === 3) {
                                valore = (($rootScope.max[i]["valore"] * 90) / 100);
                            }
                            if (ripetizioni === 5 || ripetizioni === 4) {
                                valore = (($rootScope.max[i]["valore"] * 85) / 100);
                            }
                            if (ripetizioni === 7 || ripetizioni === 6) {
                                valore = (($rootScope.max[i]["valore"] * 80) / 100);
                            }
                            if (ripetizioni === 9 || ripetizioni === 8) {
                                valore = (($rootScope.max[i]["valore"] * 75) / 100);
                            }
                            if (ripetizioni === 11 || ripetizioni === 10) {
                                valore = (($rootScope.max[i]["valore"] * 70) / 100);
                            }
                            if (ripetizioni === 13 || ripetizioni === 12) {
                                valore = (($rootScope.max[i]["valore"] * 65) / 100);
                            }
                            if (ripetizioni === 15 || ripetizioni === 14) {
                                valore = (($rootScope.max[i]["valore"] * 60) / 100);
                            }
                            if (ripetizioni === 17 || ripetizioni === 16) {
                                valore = (($rootScope.max[i]["valore"] * 55) / 100);
                            }
                            if (ripetizioni === 19 || ripetizioni === 18) {
                                valore = (($rootScope.max[i]["valore"] * 50) / 100);
                            }
                            if (ripetizioni === 20) {
                                valore = (($rootScope.max[i]["valore"] * 45) / 100);
                            }
                            if (ripetizioni > 20) {
                                valore = (($rootScope.max[i]["valore"] * 40) / 100);
                            }
                        }
                    }
                    return valore;
                }

                $scope.inizioattivita = function () {
                    $scope.inizio_ore = hours();
                    $scope.inizio_minuti = minutes();
                    $scope.inizio = totalhours();
                    var element = document.getElementById("inizio");
                    var div = document.getElementById("pulsantiera");
                    element.style.visibility = "hidden";
                    var element2 = document.getElementById("fine");
                    element2.style.visibility = "visible";
                    div.replaceChild(element2, element);
                };

                function hours() {
                    var today = new Date();
                    data = today.getHours();
                    return data;
                }
                ;
                function totalhours() {
                    var today = new Date();
                    data = 00 + today.getHours() + ":" + today.getMinutes();
                    return data;
                }
                ;

                function minutes() {
                    var today = new Date();
                    data = today.getMinutes();
                    return data;
                }
                ;

                function calendar() {
                    var today = new Date();
                    data = today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();
                    return data;
                }
                ;

                $scope.fineattivita = function () {
                    var numtd = document.getElementById('scheda').getElementsByTagName('TD');
                    var numth = document.getElementById('scheda').getElementsByTagName('TH');
                    var ess = numtd.length / numth.length;
                    var rip = document.getElementById('scheda').getElementsByClassName('rip');
                    var ripfatte = document.getElementById('scheda').getElementsByClassName('ripfatte');
                    var esercizi = document.getElementById('scheda').getElementsByClassName('esercizi');
                    var kgusati = document.getElementById('scheda').getElementsByClassName('kgusati');
                    var kgconsigliati = document.getElementById('scheda').getElementsByClassName('kgconsigliati');

                    var total = 0;
                    var totalripfatte = 0;
                    var count = 0;
                    for (var i = 0; i < ess; i++) {
                        if (ripfatte[i].value === "") {
                            ripfatte[i].value = 0;
                        }
                        if (kgusati[i].value === "") {
                            kgusati[i].value = 0;
                        }
                        var es_giornata = {
                            nome: $scope.utenteLoggato.nome,
                            esercizio: esercizi[i].innerHTML,
                            posizione: i + 1,
                            giornata: parseInt($rootScope.Idgiorno),
                            scheda: parseInt($rootScope.Idscheda),
                            proprietario: parseInt($scope.proprietario),
                            ripetizioni_riuscite: parseInt(ripfatte[i].value),
                            peso_usato: parseFloat(kgusati[i].value),
                            peso_consigliato: parseFloat(kgconsigliati[i].innerHTML),
                            ripetizioni_originali: rip[i].innerHTML
                        }
                        salva_ess(es_giornata);
                        total += parseInt(rip[i].innerHTML);
                        totalripfatte += parseInt(ripfatte[i].value);
                        if (ripfatte[i].value === rip[i].innerHTML) {
                            var count = count + 1;
                        }
                    }
                    var stats_globale = 0;
                    if (count == ess) {
                        var stats_globale = 1;
                    }
                    var note_utente = prompt("Vuoi aggiungere delle note all'allenamento?");
                    var fine_allenamento = totalhours();
                    if (stats_globale === 1) {
                        var aggiorna = 1;
                    } else {
                        var aggiorna = 0;
                    }
                    var regime_scheda = parametrok($rootScope.regime);
                    var fine_ore = hours();
                    var fine_minuti = minutes();
                    var durata = ((fine_ore - $scope.inizio_ore) * 60) + (fine_minuti - $scope.inizio_minuti);
                    if (durata == 0) {
                        durata = 1;
                    }

                    var allenamento = {
                        data: calendar(),
                        fine: fine_allenamento,
                        inizio: $scope.inizio,
                        nome: $scope.utenteLoggato.nome,
                        scheda: $rootScope.Idscheda,
                        giornata: $rootScope.Idgiorno,
                        proprietario: parseInt($scope.proprietario),
                        note: note_utente,
                        intensita: (regime_scheda * totalripfatte) / (4 * durata),
                        modifica_stats: aggiorna
                    }
                    salva_allenamento(allenamento);
                }

                function parametrok(regime) {
                    var k = 0;
                    if (regime == "Forza") {
                        var k = 19;
                    }
                    if (regime == "Massa") {
                        var k = 3;
                    }
                    if (regime == "Ricondizionamento") {
                        var k = 2;
                    }
                    return k;
                }

                function salva_ess(es_giornata) {
                    AllenatiService.salva_ess(es_giornata).then(function () {
                    })
                }

                function salva_allenamento(allenamento) {
                    AllenatiService.salva_allenamento(allenamento).then(function () {
                        $location.path('/profilo');
                    })
                }
            }]);





