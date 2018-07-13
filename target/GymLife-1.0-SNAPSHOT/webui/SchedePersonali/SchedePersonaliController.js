angular.module('GymLife.SchedePersonaliModule')

        .controller('SchedePersonaliController', ['$scope', '$rootScope', '$location', '$http', 'ConsigliaSchedaService', '$window', '$anchorScroll', '$q', function ($scope, $rootScope, $location, $http, ConsigliaSchedaService, $window, $anchorScroll, $q) {
                $scope.utenteLoggato = JSON.parse(JSON.stringify(eval('(' + sessionStorage.getItem('utenteLoggato') + ')')));
                $scope.votazione = ["0", "1", "2", "3", "4", "5"];
                $scope.Votazione = $scope.votazione[0];
                if ($scope.utenteLoggato == null) {
                    alert("Devi fare il login o la registrazione per poter vedere le tue schede");
                    $location.path('/profilo');
                }
                $rootScope.giorni = [];
                $rootScope.nomegiorni = [];
                $('.modal').on('hidden.bs.modal', function () {
                    if ($('#select').length !== 0) {
                        document.getElementById("select").style.visibility = "hidden";
                        var par = document.getElementById("descrizione");
                        if (par !== null) {
                            par.innerHTML = "";
                        }
                        if (document.getElementById("voto") != null) {
                            document.getElementById("voto").style.visibility = "hidden";
                        }
                        $('.votoclass').remove();
                    }
                })

                $scope.trova_schede_personali = function () {
                    if ($scope.utenteLoggato !== null) {
                        var scheda_personale = {
                            nome: $scope.utenteLoggato.nome
                        }

                        ConsigliaSchedaService.schede_personali(scheda_personale).then(function (response) {
                            if (response.data.esito === true) {
                                var personal = response.data.schede;
                                var scheda = {
                                    regime: "%",
                                    n_giorni: 0,
                                    difficolta: "%",
                                };
                                ConsigliaSchedaService.consigliascheda(scheda).then(function (response) {
                                    var tutte = response.data.schede;
                                    $rootScope.tutte = tutte;
                                    filtra(personal, tutte);
                                })

                            } else {
                                $window.alert(response.data.descrizione);
                                document.getElementById("schede_personali").innerHTML = "";
                            }
                        });
                    }
                };
                function filtra(personal, tutte) {
                    var sizetutte = 0, keytutte;
                    for (keytutte in tutte) {
                        if (tutte.hasOwnProperty(keytutte))
                            sizetutte++;
                    }
                    var sizepersonal = 0, keypersonal;
                    for (keypersonal in personal) {
                        if (personal.hasOwnProperty(keypersonal))
                            sizepersonal++;
                    }
                    var idschedepersonali = [];
                    for (var i = 0; i < sizepersonal; i++) {
                        idschedepersonali.push(personal[i]["scheda"]["id"]);
                    }
                    ;
                    var schede = [];
                    var nome_schede = [];
                    var proprietario_schede = [];
                    for (var i = 0; i < idschedepersonali.length; i++) {
                        for (var j = 0; j < sizetutte; j++) {
                            if (tutte[j]["giornata"]["scheda"]["id"] === idschedepersonali[i]) {
                                schede.push(tutte[j]["giornata"]["scheda"]["id"]);
                                nome_schede.push(tutte[j]["giornata"]["scheda"]["nome"]);
                                proprietario_schede.push(tutte[j]["giornata"]["scheda"]["proprietario"]["nome"]);
                                break;
                            }
                        }
                    }

                    var it = 0;
                    while (it < schede.length) {
                        var btn = document.createElement("a");
                        btn.innerHTML = nome_schede[it] + "  " + "<span style='font-style:italic;font-size: 12px;'> " + proprietario_schede[it] + " </span>";
                        btn.setAttribute("id", proprietario_schede[it]);
                        btn.setAttribute("class", "bello");
                        var element = document.getElementById("schede_personali");
                        element.appendChild(btn);
                        var els = document.getElementById("schede_personali").querySelectorAll("a");
                        for (var i = 0; i < els.length; i++) {
                            els[i].setAttribute("data-id", schede[i]);
                            els[i].setAttribute("data-target", "#modal_schede_personali");
                            els[i].setAttribute("data-toggle", "modal");
                        }
                        ;
                        it++;
                    }
                    displaymodalschede(tutte, sizetutte);
                }

                function displaymodalschede(es, size) {
                    $('.modal').on('shown.bs.modal', function (e) {
                        document.getElementById("descrizione").innerHTML = "";
                        if (document.getElementById("voto") != null) {
                            document.getElementById("voto").style.visibility = "hidden";
                        }
                        $rootScope.giorni = [];
                        $rootScope.nomegiorni = [];
                        var $trigger = $(e.relatedTarget).data("id");
                        document.getElementById("giornischedapersonale").innerHTML = "";
                        var giorni = [];
                        var giorniId = [];
                        var count = 0;
                        for (var k = 0; k < size; k++) {
                            if (es[k]["giornata"]["scheda"]["id"] === $trigger) {
                                document.getElementById("nomeschedapersonalemodal").innerHTML = es[k]["giornata"]["scheda"]["nome"];
                                document.getElementById("dettaglipersonali").innerHTML = "<span style='font-weight:bold'>  Descrizione :</span>" + " " + es[k]["giornata"]["scheda"]["descrizione"];
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
                            $rootScope.giorni.push(giorniId[z]);
                            $rootScope.nomegiorni.push(es[giorni[z]]["giornata"]["nome"]);
                            var element = document.getElementById("giornischedapersonale");
                            element.appendChild(nuovo);
                            for (var e = 0; e < size; e++) {
                                if (es[e]["giornata"]["id"] === giorniId[z]) {
                                    var nuovoes = document.createElement("li");
                                    nuovoes.innerHTML = "<span style='font-weight:bold'>Esercizio :</span>" + " " + es[e]["nome"]["nome"] + ". . . . . . . . . . . ." + "Rip " + es[e]["n_ripetizioni"];
                                    element.appendChild(nuovoes);
                                    $scope.prop = es[e]["proprietario"]["id"];
                                    $scope.scheda = es[e]["scheda"]["id"];
                                    var votazione = {
                                        user: $scope.utenteLoggato.nome,
                                        scheda: es[e]["scheda"]["id"],
                                        proprietario: es[e]["proprietario"]["id"],
                                    }
                                }
                            }
                            var nuovobr = document.createElement("br");
                            element.appendChild(nuovobr);
                            var nuovobr = document.createElement("br");
                            element.appendChild(nuovobr);
                        }
                        ConsigliaSchedaService.votazione(votazione).then(function (response) {
                            var trovato = 0;
                            if (response.data.esito === true) {
                                var vot = response.data.votazione;
                                trovato = 1;
                            }
                            if (response.data.esito === false) {
                                trovato = 0;
                            }
                            if (trovato == 1) {
                                for (var i = 0; i < vot.length; i++) {
                                    if (vot[i]["proprietario"]["id"] === $scope.prop && vot[i]["scheda"]["id"] === $scope.scheda) {
                                        var trovato = 2;
                                    }
                                }
                                if (trovato == 1) {
                                    trovato = 0;
                                }
                            }
                            if (trovato == 0) {
                                document.getElementById("descrizione").innerHTML = "";
                                document.getElementById("voto").style.visibility = "visible";
                                document.getElementById("descrizione").innerHTML = "Vota la scheda";
                            }

                        });
                        $('#voto').on('change', function (e) {
                            var optionSelected = $("option:selected", this);
                            var valueSelected = this.value;
                            salva_votazione(valueSelected);
                        });
                    });
                }
                ;
                $scope.vai_allenamento = function () {
                    var button = document.getElementsByClassName("btn btn-default bello");
                    $rootScope.Idscheda = button[0].id;
                    var par = document.getElementById("descrizione");
                    par.innerHTML = "Scegli la giornata con cui ti vuoi allenare";
                    var scegli = document.createElement("select");
                    scegli.setAttribute("id", "select");
                    var element = document.getElementById("modal_footer");
                    if (element.hasChildNodes()) {
                        element.removeChild(element.lastChild);
                    }
                    element.appendChild(scegli);
                    for (i = 0; i < $rootScope.giorni.length; i++) {
                        var option = document.createElement("option");
                        option.setAttribute("value", $rootScope.giorni[i]);
                        option.innerHTML = $rootScope.nomegiorni[i];
                        scegli.appendChild(option);
                    }
                    $('#select').change(function () {
                        $rootScope.Idgiorno = $(this).val();
                        if (confirm("Andiamo ad allenarci?")) {
                            $('.modal').modal('hide');
                            $rootScope.cambio = 1;
                            document.location.href = '/GymLife/#/allenati';
                        }
                    }
                    )
                };
                function salva_votazione(voto) {
                    var votazione = {
                        user: $scope.utenteLoggato.nome,
                        scheda: $scope.scheda,
                        proprietario: $scope.prop,
                        voto: voto
                    }
                    ConsigliaSchedaService.salva_votazione(votazione).then(function () {
                    });
                }
            }])






   