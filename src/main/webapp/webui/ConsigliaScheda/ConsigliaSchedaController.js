angular.module('GymLife.ConsigliaSchedaModule')

        .controller('ConsigliaSchedaController', ['$scope', '$rootScope', '$location', '$http', 'ConsigliaSchedaService', '$window', '$anchorScroll', '$q', function ($scope, $rootScope, $location, $http, ConsigliaSchedaService, $window, $anchorScroll, $q) {

                $scope.utenteLoggato = JSON.parse(JSON.stringify(eval('(' + sessionStorage.getItem('utenteLoggato') + ')')));

                $scope.difficoltascheda = ["Tutto", "Neofita", "Esperto"];
                $scope.DifficoltaScheda = $scope.difficoltascheda[0];
                $scope.regime = ["Tutto", "Ricondizionamento", "Forza", "Massa", "Definizione"];
                $scope.Regime = $scope.regime[0];
                $scope.giorni = ["Tutto", "1", "2", "3", "4"];
                $scope.Giorni = $scope.giorni[0];
                $scope.inativita = ["Da 0-4 mesi", "Da più di 4 mesi"];
                $scope.Inativita = $scope.inativita[0];

                $scope.trova_scheda = function () {

                    if ($scope.Inativita === "Da più di 4 mesi") {
                        regimedb = "Ricondizionamento";
                        difficoltaschedadb = "%";
                        giornidb = 0;
                        var scheda = {
                            regime: regimedb,
                            n_giorni: giornidb,
                            difficolta: difficoltaschedadb,
                        };

                    } else {
                        if ($scope.DifficoltaScheda === "Tutto") {
                            var difficoltaschedadb = "%";
                        } else {
                            var difficoltaschedadb = $scope.DifficoltaScheda;
                        }

                        if ($scope.Regime === "Tutto") {
                            var regimedb = "%";
                        } else {
                            var regimedb = $scope.Regime;
                        }

                        if ($scope.Giorni === "Tutto") {
                            var giornidb = 0;
                        } else {
                            var giornidb = $scope.Giorni;
                        }
                        var scheda = {
                            regime: regimedb,
                            n_giorni: giornidb,
                            difficolta: difficoltaschedadb,
                        };
                    }
                    ConsigliaSchedaService.consigliascheda(scheda).then(function (response) {
                        if (response.data.esito === true) {
                            var es = response.data.schede;
                            displayscheda(es);
                        } else {
                            document.getElementById("schede").innerHTML = "";
                        }
                    });
                };


                function displayscheda(es) {
                    var element = document.getElementById("schede");
                    if (element !== null) {
                        element.innerHTML = "";
                    }
                    var size = 0, key;
                    for (key in es) {
                        if (es.hasOwnProperty(key))
                            size++;
                    }
                    var schede = [];
                    var nome_schede = [];
                    var proprietario_schede = [];
                    var count = 0;
                    for (var i = 0; i < size; i++) {
                        count = 0;
                        for (var j = 0; j < schede.length; j++) {
                            if ((es[i]["giornata"]["scheda"]["id"]) === (schede[j])) {
                                count++;
                                break;
                            }
                        }
                        if (count === 0) {
                            schede.push(es[i]["giornata"]["scheda"]["id"]);
                            nome_schede.push(es[i]["giornata"]["scheda"]["nome"]);
                            proprietario_schede.push(es[i]["giornata"]["scheda"]["proprietario"]["nome"]);
                        }


                    }
                    var it = 0;
                    while (it < schede.length) {
                        var btn = document.createElement("a");
                        btn.innerHTML = nome_schede[it] + "  " + "<span style='font-style:italic;font-size: 12px;'> " + proprietario_schede[it] + " </span>";
                        btn.setAttribute("id", proprietario_schede[it]);
                        btn.setAttribute("class", "bello");
                        var element = document.getElementById("schede");
                        element.appendChild(btn);
                        var els = document.getElementById("schede").querySelectorAll("a");
                        for (var i = 0; i < els.length; i++) {
                            els[i].setAttribute("data-id", schede[i]);
                            els[i].setAttribute("data-target", "#myModalSscheda");
                            els[i].setAttribute("data-toggle", "modal");
                        }
                        ;
                        it++;

                    }
                    displaymodalschede(es, size);
                }

                function displaymodalschede(es, size) {
                    $('.modal').on('shown.bs.modal', function (e) {
                        var $trigger = $(e.relatedTarget).data("id");
                        document.getElementById("giornischeda").innerHTML = "";
                        var giorni = [];
                        var giorniId = [];
                        var count = 0;
                        for (var k = 0; k < size; k++) {
                            if (es[k]["giornata"]["scheda"]["id"] === $trigger) {
                                document.getElementById("nomeschedamodal").innerHTML = es[k]["giornata"]["scheda"]["nome"];
                                document.getElementById("dettagli").innerHTML = "<span style='font-weight:bold'>  Descrizione :</span>" + " " + es[k]["giornata"]["scheda"]["descrizione"];
                                for (var h = 0; h < giorni.length; h++) {
                                    count = 0;
                                    if (giorniId[h] === es[k]["giornata"]["id"]) {
                                        count = count + 1;
                                        break;
                                    }
                                }
                                if (count === 0) {
                                    giorni.push(k);
                                    giorniId.push(es[k]["giornata"]["id"]);
                                }
                            }
                        }
                        var salva = document.getElementsByClassName("btn btn-default bello");
                        salva[0].setAttribute("id", $trigger);
                        for (var z = 0; z < giorniId.length; z++) {
                            var nuovo = document.createElement("p");
                            nuovo.innerHTML = "<span style='font-weight:bold;text-align:center;'>Giorno :</span>" + " " + es[giorni[z]]["giornata"]["nome"];
                            var element = document.getElementById("giornischeda");
                            element.appendChild(nuovo);

                            for (var e = 0; e < size; e++) {
                                if (es[e]["giornata"]["id"] === giorniId[z]) {
                                    var nuovoes = document.createElement("li");
                                    nuovoes.innerHTML = "<span style='font-weight:bold'>Esercizio :</span>" + " " + es[e]["nome"]["nome"] + ". . . . . . . . . . . ." + "Rip " + es[e]["n_ripetizioni"];
                                    element.appendChild(nuovoes);
                                }
                            }
                            var nuovobr = document.createElement("br");
                            element.appendChild(nuovobr);
                            var nuovobr = document.createElement("br");
                            element.appendChild(nuovobr);
                        }
                    });
                }
                ;
                $scope.salva_scheda = function () {
                    if ($scope.utenteLoggato == null) {
                        alert("Devi fare il login o la registrazione per poter salvare una nuova scheda");
                        $location.path('/consiglia_scheda');
                    } else {
                        var button = document.getElementsByClassName("btn btn-default bello");
                        var proprietario = document.getElementsByClassName("bello");
                        var scheda_personale = {
                            scheda: button[0].id,
                            id_utilizzatore: $scope.utenteLoggato.nome,
                            visibile: 1,
                            proprietario: proprietario[0].id
                        };
                    }
                    ConsigliaSchedaService.salva_scheda(scheda_personale).then(function (response) {
                        if (response.data.esito == true) {
                            $window.alert(response.data.descrizione);
                        } else {
                            $window.alert(response.data.descrizione);
                        }
                    });
                };
            }]);

   