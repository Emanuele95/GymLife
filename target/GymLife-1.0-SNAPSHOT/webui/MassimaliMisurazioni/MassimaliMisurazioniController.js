angular.module('GymLife.MassimaliMisurazioniModule')

        .controller('MassimaliMisurazioniController', ['$scope', '$rootScope', '$location', '$http', 'MassimaliMisurazioniService', '$window', '$anchorScroll', '$q', function ($scope, $rootScope, $location, $http, MassimaliMisurazioniService, $window, $anchorScroll, $q) {

                $scope.utenteLoggato = JSON.parse(JSON.stringify(eval('(' + sessionStorage.getItem('utenteLoggato') + ')')));

                $scope.esercizi = [ "Panca piana", "Panca Alta", "Panca stretta", "Curl Bilanciere", "Lat Machine", "Lat Machine inversa", "Pressa 45", "Affondi", "Crunch", "Alzate laterali"];
                $scope.Esercizio = $scope.esercizi[0];
                $scope.misurazioni = ["Collo", "Petto", "Braccio", "Vita", "Coscia"];
                $scope.Misurazione = $scope.misurazioni[0];

                function time() {
                    var today = new Date();
                    return data = today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();
                }
                ;

                function eliminanodi(div) {
                    while (div.firstChild) {
                        div.removeChild(div.firstChild);
                    }
                }
                ;

                document.getElementById("esercizio_label").style.visibility = "hidden";
                document.getElementById("esercizio").style.visibility = "hidden";
                document.getElementById("kg_label").style.visibility = "hidden";
                document.getElementById("kg").style.visibility = "hidden";
                document.getElementById("NewMassimale").style.visibility = "hidden";

                document.getElementById("misurazione_label").style.visibility = "hidden";
                document.getElementById("misurazione").style.visibility = "hidden";
                document.getElementById("cm_label").style.visibility = "hidden";
                document.getElementById("cm").style.visibility = "hidden";
                document.getElementById("NewMisurazione").style.visibility = "hidden";

                document.getElementById("peso_label").style.visibility = "hidden";
                document.getElementById("peso").style.visibility = "hidden";
                document.getElementById("NewBilancia").style.visibility = "hidden";

                document.getElementById("br11").style.visibility = "hidden";
                document.getElementById("br12").style.visibility = "hidden";
                document.getElementById("br13").style.visibility = "hidden";
                document.getElementById("br14").style.visibility = "hidden";
                document.getElementById("br21").style.visibility = "hidden";
                document.getElementById("br22").style.visibility = "hidden";
                document.getElementById("br23").style.visibility = "hidden";
                document.getElementById("br24").style.visibility = "hidden";
                document.getElementById("br31").style.visibility = "hidden";
                document.getElementById("br32").style.visibility = "hidden";


                $scope.display_massimali = function () {
                    document.getElementById("massimali_misurazioni").innerHTML = "";
                    document.getElementById("esercizio_label").style.visibility = "visible";
                    document.getElementById("esercizio").style.visibility = "visible";
                    document.getElementById("kg_label").style.visibility = "visible";
                    document.getElementById("kg").style.visibility = "visible";
                    document.getElementById("NewMassimale").style.visibility = "visible";
                    document.getElementById("br11").style.visibility = "visible";
                    document.getElementById("br12").style.visibility = "visible";
                    document.getElementById("br13").style.visibility = "visibele";
                    document.getElementById("br14").style.visibility = "visible";

                };

                $scope.display_misurazioni = function () {
                    document.getElementById("massimali_misurazioni").innerHTML = "";
                    document.getElementById("misurazione_label").style.visibility = "visible";
                    document.getElementById("misurazione").style.visibility = "visible";
                    document.getElementById("cm_label").style.visibility = "visible";
                    document.getElementById("cm").style.visibility = "visible";
                    document.getElementById("NewMisurazione").style.visibility = "visible";
                    document.getElementById("br21").style.visibility = "visible";
                    document.getElementById("br22").style.visibility = "visible";
                    document.getElementById("br23").style.visibility = "visibele";
                    document.getElementById("br24").style.visibility = "visible";
                    var div = document.getElementById("massimalidiv");
                    eliminanodi(div);
                };

                $scope.display_peso = function () {
                    document.getElementById("massimali_misurazioni").innerHTML = "";
                    document.getElementById("peso_label").style.visibility = "visible";
                    document.getElementById("peso").style.visibility = "visible";
                    document.getElementById("NewBilancia").style.visibility = "visible";
                    document.getElementById("br31").style.visibility = "visible";
                    document.getElementById("br32").style.visibility = "visible";
                    var div = document.getElementById("massimalidiv");
                    eliminanodi(div);
                    var div2 = document.getElementById("misurazionidiv");
                    eliminanodi(div2);
                };

                $scope.NewMassimale = function () {
                    if ($scope.utenteLoggato == null) {
                        alert("Devi fare il login o la registrazione per poter salvare un nuovo massimale");
                    } else {
                        var d = time();
                        var ese = {
                            username: $scope.utenteLoggato.nome,
                            esercizio: $scope.Esercizio,
                            valore: $scope.Massimale,
                            data: d,

                        };
                    }
                    MassimaliMisurazioniService.nuovoMassimale(ese).then(function (response) {
                        if (response.data.esito == true) {
                            $window.alert(response.data.descrizione);
                            $location.path('/profilo');
                        } else {
                            $window.alert(response.data.descrizione);
                            $location.path('/profilo');
                        }
                    })
                };




                $scope.NewMisurazione = function () {
                    if ($scope.utenteLoggato == null) {
                        alert("Devi fare il login o la registrazione per poter salvare una nuova misurazione");
                    } else {
                        var d = time();
                        var mis = {
                            parte: $scope.Misurazione,
                            valore: $scope.Valore_misurazione,
                            data: d,
                            misura: "cm",
                            username: $scope.utenteLoggato.nome,
                        };
                    }
                    MassimaliMisurazioniService.nuovoMisurazione(mis).then(function (response) {
                        if (response.data.esito == true) {
                            $window.alert(response.data.descrizione);
                            $location.path('/profilo');
                        } else {
                            $window.alert(response.data.descrizione);
                            $location.path('/profilo');
                        }
                    })

                };

                $scope.NewBilancia = function () {
                    if ($scope.utenteLoggato == null) {
                        alert("Devi fare il login o la registrazione per poter salvare un nuovo valore di bilancia");
                    } else {
                        var d = time();
                        var bil = {
                            parte: "peso",
                            valore: $scope.Peso,
                            data: d,
                            misura: "kg",
                            username: $scope.utenteLoggato.nome,
                        };
                    }
                    MassimaliMisurazioniService.nuovoMisurazione(bil).then(function (response) {
                        if (response.data.esito == true) {
                            $window.alert(response.data.descrizione);
                            $location.path('/profilo');
                        } else {
                            $window.alert(response.data.descrizione);
                            $location.path('/profilo');
                        }
                    })
                };
            }]);






   