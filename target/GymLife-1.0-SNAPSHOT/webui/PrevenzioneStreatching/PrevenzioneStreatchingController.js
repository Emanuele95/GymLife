angular.module('GymLife.PrevenzioneStreatchingModule')

        .controller('PrevenzioneStreatchingController', ['$scope', '$rootScope', '$location', '$http', 'PrevenzioneStreatchingService', '$window', '$anchorScroll', '$q', function ($scope, $rootScope, $location, $http, PrevenzioneStreatchingService, $window, $anchorScroll, $q) {
                $scope.utenteLoggato = JSON.parse(JSON.stringify(eval('(' + sessionStorage.getItem('utenteLoggato') + ')')));

                $scope.eserciziFis = ["Tutto", "Scapole spinte contro il muro"];
                $scope.EsercizioFis = $scope.eserciziFis[0];
                $scope.muscoliFis = ["Tutto", "Pettorali", "Schiena", "Spalla", "Tricipiti", "Bicipiti", "Avambracci", "Addominali", "Glutei", "Gambe"];
                $scope.MuscoloFis = $scope.muscoliFis[0];
                $scope.difficoltaFis = ["Tutto", "Neofita", "Esperto"];
                $scope.DifficoltaFis = $scope.difficoltaFis[0];
                $scope.corpoliberoFis = ["Si", "No"];
                $scope.CorpoliberoFis = $scope.corpoliberoFis[0];

                $scope.trova_fisioterapia = function () {

                    if ($scope.EsercizioFis === "Tutto") {
                        var eserciziodbFis = "%";
                    } else {
                        var eserciziodbFis = $scope.EsercizioFis;
                    }

                    if ($scope.MuscoloFis === "Tutto") {
                        var muscoloodbFis = "%";
                    } else {
                        var muscoloodbFis = $scope.MuscoloFis;
                    }

                    if ($scope.DifficoltaFis === "Tutto") {
                        var difficoltadbFis = "%";
                    } else {
                        var difficoltadbFis = $scope.DifficoltaFis;
                    }

                    if ($scope.CorpoliberoFis === "No") {
                        var corpoliberoodbFis = 0;
                    } else {
                        var corpoliberoodbFis = 1;
                    }

                    var fisioterapia = {
                        muscolo: muscoloodbFis,
                        corpo_libero: corpoliberoodbFis,
                        difficolta: difficoltadbFis,
                        nome: eserciziodbFis
                    };
                    PrevenzioneStreatchingService.fisioterapia(fisioterapia).then(function (response) {
                        if (response.data.esito === true) {
                            var es = response.data.exercises;
                            displayesFis(es);
                        } else {
                            $window.alert(response.data.descrizione);
                            document.getElementById("eserciziFis").innerHTML = "";
                        }
                    });
                };

                function displayesFis(es) {
                    document.getElementById("eserciziFis").innerHTML = "";
                    var size = 0, key;
                    for (key in es) {
                        if (es.hasOwnProperty(key))
                            size++;
                    }
                    var it = 0;
                    while (it < size) {
                        var btn = document.createElement("a");
                        btn.innerHTML = es[it]["nome"];
                        var element = document.getElementById("eserciziFis");
                        element.appendChild(btn);
                        var els = document.getElementById("eserciziFis").querySelectorAll("a");
                        for (var i = 0; i < els.length; i++) {
                            els[i].setAttribute("data-id", i);
                            els[i].setAttribute("data-target", "#myModalFis");
                            els[i].setAttribute("data-toggle", "modal");
                        }
                        ;
                        it++;
                    }
                    displaymodalFis(es);

                }
                ;

                function displaymodalFis(es) {

                    $('.modal').on('show.bs.modal', function (e) {
                        var $trigger = $(e.relatedTarget).data("id");
                        document.getElementById("nomeFis").innerHTML = "<span style='font-weight:bold'>Esercizio :</span>" + " " + es[$trigger]["nome"];
                        document.getElementById("descrizioneFis").innerHTML = "<span style='font-weight:bold'>Descrizione :</span>" + " " + es[$trigger]["descrizione"];
                        document.getElementById("consigliFis").innerHTML = "<span style='font-weight:bold'>Consigli :</span>" + " " + es[$trigger]["consigli"];
                        document.getElementById("difficoltaFis").innerHTML = "<span style='font-weight:bold'>Difficoltà :</span>" + " " + es[$trigger]["difficolta"];
                        document.getElementById("muscoloFis").innerHTML = "<span style='font-weight:bold'>Gruppo Muscolare :</span>" + " " + es[$trigger]["muscolo"];

                    });
                }
                ;

            }]);






   