angular.module('GymLife.EserciziModule')

        .controller('EserciziController', ['$scope', '$rootScope', '$location', '$http', 'EserciziService', '$window', '$anchorScroll', '$q', function ($scope, $rootScope, $location, $http, EserciziService, $window, $anchorScroll, $q) {

                $scope.utenteLoggato = JSON.parse(JSON.stringify(eval('(' + sessionStorage.getItem('utenteLoggato') + ')')));

                $scope.muscoli = ["Tutto", "Pettorali", "Dorso", "Spalla", "Tricipiti", "Bicipiti", "Avambracci", "Addominali", "Glutei", "Gambe"];
                $scope.Muscolo = $scope.muscoli[0];
                $scope.difficolta = ["Tutto", "Neofita", "Esperto"];
                $scope.Difficolta = $scope.difficolta[0];
                $scope.corpolibero = ["No", "Si"];
                $scope.Corpolibero = $scope.corpolibero[0];
                $scope.esercizi = ["Tutto", "Panca piana", "Panca Alta", "Panca stretta", "Curl Bilanciere", "Lat Machine", "Lat Machine inversa", "Pressa 45", "Affondi", "Crunch", "Alzate laterali"];
                $scope.Esercizio = $scope.esercizi[0];

                $scope.trova_esercizi = function () {

                    if ($scope.Esercizio === "Tutto") {
                        var eserciziodb = "%";
                    } else {
                        var eserciziodb = $scope.Esercizio;
                    }

                    if ($scope.Muscolo === "Tutto") {
                        var muscoloodb = "%";
                    } else {
                        var muscoloodb = $scope.Muscolo;
                    }

                    if ($scope.Difficolta === "Tutto") {
                        var difficoltadb = "%";
                    } else {
                        var difficoltadb = $scope.Difficolta;
                    }

                    if ($scope.Corpolibero === "No") {
                        var corpoliberoodb = 0;
                    } else {
                        var corpoliberoodb = 1;
                    }


                    var esercizio = {
                        muscolo: muscoloodb,
                        corpo_libero: corpoliberoodb,
                        difficolta: difficoltadb,
                        nome: eserciziodb
                    };
                    EserciziService.esercizi(esercizio).then(function (response) {
                        if (response.data.esito === true) {
                            var es = response.data.exercises;
                            displayes(es);
                        } else {
                            document.getElementById("esercizi").innerHTML = "";
                        }
                    });
                };

                function displayes(es) {
                    document.getElementById("esercizi").innerHTML = "";
                    var size = 0, key;
                    for (key in es) {
                        if (es.hasOwnProperty(key))
                            size++;
                    }
                    var it = 0;
                    while (it < size) {
                        var btn = document.createElement("a");
                        btn.innerHTML = es[it]["nome"];
                        var element = document.getElementById("esercizi");
                        element.appendChild(btn);
                        var els = document.getElementById("esercizi").querySelectorAll("a");
                        for (var i = 0; i < els.length; i++) {
                            els[i].setAttribute("data-id", i);
                            els[i].setAttribute("data-target", "#myModal");
                            els[i].setAttribute("data-toggle", "modal");
                            els[i].setAttribute("ng-init", "trova_esercizi()");

                        }
                        ;
                        it++;
                    }
                    displaymodal(es);
                }
                ;

                function displaymodal(es) {

                    $('.modal').on('shown.bs.modal', function (e) {
                        var $trigger = $(e.relatedTarget).data("id");
                        document.getElementById("nome").innerHTML = "<span style='font-weight:bold'>Esercizio :</span>" + " " + es[$trigger]["nome"];
                        document.getElementById("descrizione").innerHTML = "<span style='font-weight:bold'>Descrizione :</span>" + " " + es[$trigger]["descrizione"];
                        document.getElementById("consigli").innerHTML = "<span style='font-weight:bold'>Consigli :</span>" + " " + es[$trigger]["consigli"];
                        document.getElementById("difficolta").innerHTML = "<span style='font-weight:bold'>Difficoltà :</span>" + " " + es[$trigger]["difficolta"];
                        document.getElementById("muscolo").innerHTML = "<span style='font-weight:bold'>Gruppo Muscolare :</span>" + " " + es[$trigger]["muscolo"];
                    });
                }
                ;
            }]);




   