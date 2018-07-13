angular.module('GymLife.ArchivioModule')

        .controller('ArchivioController', ['$scope', '$rootScope', '$location', '$http', 'ArchivioService', '$window', '$anchorScroll', '$q', function ($scope, $rootScope, $location, $http, ArchivioService, $window, $anchorScroll, $q) {

                $scope.utenteLoggato = JSON.parse(JSON.stringify(eval('(' + sessionStorage.getItem('utenteLoggato') + ')')));


                if ($scope.utenteLoggato == null) {
                    alert("Devi fare il login o la registrazione per poter vedere il tuo archivio");
                    $location.path('/profilo');
                }

                window.addEventListener('load', function () {
                    vanillaCalendar.init({
                    });
                })

                var vanillaCalendar = {
                    month: document.querySelectorAll('[data-calendar-area="month"]')[0],
                    next: document.querySelectorAll('[data-calendar-toggle="next"]')[0],
                    previous: document.querySelectorAll('[data-calendar-toggle="previous"]')[0],
                    label: document.querySelectorAll('[data-calendar-label="month"]')[0],
                    activeDates: null,
                    date: new Date, todaysDate: new Date,
                    init: function (t) {
                        this.options = t,
                                this.date.setDate(1), this.createMonth(), this.createListeners()
                    },
                    createListeners: function () {
                        var t = this;
                        this.next.addEventListener("click", function () {
                            t.clearCalendar();
                            var e = t.date.getMonth() + 1;
                            t.date.setMonth(e), t.createMonth()
                        }), this.previous.addEventListener("click", function () {
                            t.clearCalendar();
                            var e = t.date.getMonth() - 1;
                            t.date.setMonth(e), t.createMonth()
                        })
                    },
                    createDay: function (t, e, a) {
                        var n = document.createElement("div"), s = document.createElement("span");
                        s.innerHTML = t, n.className = "vcal-date", n.setAttribute("data-calendar-date", this.date), 1 === t && (n.style.marginLeft = 0 === e ? 6 * 14.28 + "%" : 14.28 * (e - 1) + "%"), this.options.disablePastDays && this.date.getTime() <= this.todaysDate.getTime() - 1 ? n.classList.add("vcal-date--disabled") : (n.classList.add("vcal-date--active"), n.setAttribute("data-calendar-status", "active")), this.date.toString() === this.todaysDate.toString() && n.classList.add("vcal-date--today"), n.appendChild(s), this.month.appendChild(n)

                    },
                    dateClicked: function () {
                        var t = this;
                        this.activeDates = document.querySelectorAll('[data-calendar-status="active"]');
                        for (var e = 0; e < this.activeDates.length; e++)
                            this.activeDates[e].addEventListener("click", function (e) {
                                document.querySelectorAll('[data-calendar-label="picked"]')[0].innerHTML = this.dataset.calendarDate, t.removeActiveClass(), this.classList.add("vcal-date--selected")
                                var data = this.dataset.calendarDate;
                                var data_bella = data.slice(4, 16);
                                var mese = data_bella.slice(0, 3);
                                var n_mese = converti(mese);
                                var numero = data_bella.slice(4, 6);
                                var anno = data_bella.slice(7, 11);
                                var data_finale = anno + "-" + n_mese + "-" + numero;
                                trova_archivio(data_finale);
                            })
                    },
                    createMonth: function () {
                        for (var t = this.date.getMonth(); this.date.getMonth() === t; )
                            this.createDay(this.date.getDate(), this.date.getDay(), this.date.getFullYear()), this.date.setDate(this.date.getDate() + 1);
                        this.date.setDate(1), this.date.setMonth(this.date.getMonth() - 1), this.label.innerHTML = this.monthsAsString(this.date.getMonth()) + " " + this.date.getFullYear(), this.dateClicked()
                    },
                    monthsAsString: function (t) {
                        return["January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"][t]
                    },
                    clearCalendar: function () {
                        vanillaCalendar.month.innerHTML = ""
                    },
                    removeActiveClass: function () {
                        for (var t = 0; t < this.activeDates.length; t++)
                            this.activeDates[t].classList.remove("vcal-date--selected")
                    }};


                function converti(mese) {
                    var n_mese;
                    if (mese == "Jan") {
                        var n_mese = 1;
                    }
                    if (mese == "Feb") {
                        var n_mese = 2;
                    }
                    if (mese == "Mar") {
                        var n_mese = 3;
                    }
                    if (mese == "Apr") {
                        var n_mese = 4;
                    }
                    if (mese == "May") {
                        var n_mese = 5;
                    }
                    if (mese == "Jun") {
                        var n_mese = 6;
                    }
                    if (mese == "Jul") {
                        var n_mese = 7;
                    }
                    if (mese == "Aug") {
                        var n_mese = 8;
                    }
                    if (mese == "Sep") {
                        var n_mese = 9;
                    }
                    if (mese == "Oct") {
                        var n_mese = 10;
                    }
                    if (mese == "Nov") {
                        var n_mese = 11;
                    }
                    if (mese == "Dec") {
                        var n_mese = 12;
                    }
                    return n_mese;
                }

                function trova_archivio(data_finale) {

                    var archivio = {
                        user: $scope.utenteLoggato.nome,
                        data: data_finale
                    }
                    ArchivioService.archivio_massimale(archivio).then(function (response) {
                        if (response.data.esito == true) {
                            $scope.archivio_massimale = response.data.massimale;
                            displaymassimale($scope.archivio_massimale);
                        } else {
                            var element = document.getElementById("massimale_archivio");
                            element.innerHTML = "Nessun Massimale";
                            var massimale = null;
                        }
                    });
                    ArchivioService.archivio_misurazione(archivio).then(function (response) {
                        if (response.data.esito == true) {
                            $scope.archivio_misurazione = response.data.misurazione;
                            displaymisurazione($scope.archivio_misurazione);
                        } else {
                            var element = document.getElementById("misurazione_archivio");
                            element.innerHTML = " Nesuna Misurazione";
                            var misurazione = null;
                        }
                    });
                    ArchivioService.archivio_allenamento(archivio).then(function (response) {
                        if (response.data.esito == true) {
                            $scope.archivio_allenamento = response.data.allenamento;
                            displayallenamento($scope.archivio_allenamento);
                            for (var i = 0; i < $scope.archivio_allenamento.length; i++) {
                                var esercizio = {
                                    user: $scope.utenteLoggato.nome,
                                    n_allenamento: $scope.archivio_allenamento[i]["n_allenamento"]
                                }
                                ArchivioService.archivio_esercizio(esercizio).then(function (response) {
                                    var es = response.data.esercizio;
                                    $scope.archivio_esercizi = es;
                                });
                            }
                        } else {
                            var element = document.getElementById("allenamento_archivio");
                            element.innerHTML = "Nessun Allenamento";
                        }
                    });
                }
                function displaymassimale(massimale) {
                    var element = document.getElementById("massimale_archivio");
                    element.innerHTML = "";
                    for (var it = 0; it < massimale.length; it++) {
                        var btn = document.createElement("a");
                        btn.innerHTML = massimale[it]["esercizio"]["nome"];
                        var element = document.getElementById("massimale_archivio");
                        element.appendChild(btn);
                        var els = document.getElementById("massimale_archivio").querySelectorAll("a");
                        for (var i = 0; i < els.length; i++) {
                            els[i].setAttribute("data-id", i);
                            els[i].setAttribute("data-class", "massimale")
                            els[i].setAttribute("data-target", "#myModalSscheda");
                            els[i].setAttribute("data-toggle", "modal");
                        }
                    }
                    displaymodal();
                }

                function displaymisurazione(misurazione) {
                    var element = document.getElementById("misurazione_archivio");
                    element.innerHTML = "";
                    for (var it = 0; it < misurazione.length; it++) {
                        var btn = document.createElement("a");
                        btn.innerHTML = misurazione[it]["parte"]["nome"];
                        var element = document.getElementById("misurazione_archivio");
                        element.appendChild(btn);
                        var els = document.getElementById("misurazione_archivio").querySelectorAll("a");
                        for (var i = 0; i < els.length; i++) {
                            els[i].setAttribute("data-id", i);
                            els[i].setAttribute("data-class", "misurazione")
                            els[i].setAttribute("data-target", "#myModalSscheda");
                            els[i].setAttribute("data-toggle", "modal");
                        }
                    }
                    displaymodal();
                }


                function displayallenamento(allenamento) {
                    var element = document.getElementById("allenamento_archivio");
                    element.innerHTML = "";
                    for (var it = 0; it < allenamento.length; it++) {
                        var btn = document.createElement("a");
                        btn.innerHTML = allenamento[it]["giornata"]["nome"] + "  " + "<span style='font-style:italic;font-size: 12px;'> " + allenamento[it]["scheda"]["nome"] + " </span>";
                        var element = document.getElementById("allenamento_archivio");
                        element.appendChild(btn);
                        var els = document.getElementById("allenamento_archivio").querySelectorAll("a");
                        for (var i = 0; i < els.length; i++) {
                            els[i].setAttribute("data-id", i);
                            els[i].setAttribute("data-class", "allenamento")
                            els[i].setAttribute("data-target", "#myModalSscheda");
                            els[i].setAttribute("data-toggle", "modal");
                        }
                    }
                    displaymodal();
                }

                function displaymodal() {
                    $('.modal').on('shown.bs.modal', function (e) {
                        var id = $(e.relatedTarget).data("id");
                        var classe = $(e.relatedTarget).data("class");
                        if (classe == "massimale") {
                            document.getElementById("valoriarchivio").innerHTML = "";
                            var els = document.getElementById("titolomodalrachivio");
                            els.innerHTML = $scope.archivio_massimale[id]["esercizio"]["nome"];
                            var element = document.getElementById("valoriarchivio");
                            element.innerHTML = "Valore:" + " " + $scope.archivio_massimale[id]["valore"] + "kg";
                        }
                        if (classe == "misurazione") {
                            document.getElementById("valoriarchivio").innerHTML = "";
                            var els = document.getElementById("titolomodalrachivio");
                            els.innerHTML = $scope.archivio_misurazione[id]["parte"]["nome"];
                            var element = document.getElementById("valoriarchivio");
                            element.innerHTML = "Valore:" + " " + $scope.archivio_misurazione[id]["valore"] + " " + $scope.archivio_misurazione[id]["misura"];
                        }
                        if (classe == "allenamento") {
                            document.getElementById("valoriarchivio").innerHTML = "";
                            var els = document.getElementById("titolomodalrachivio");
                            els.innerHTML = $scope.archivio_allenamento[id]["giornata"]["nome"] + "  " + "<span style='font-style:italic;font-size: 12px;'> " + $scope.archivio_allenamento[id]["scheda"]["nome"] + " </span>";
                            var elementw = document.getElementById("valoriarchivio");
                            var j = 0;
                            var i = 0;
                            var ordinati = [];
                            while (j < $scope.archivio_esercizi.length) {
                                for (var i = 0; i < $scope.archivio_esercizi.length; i++) {
                                    if ($scope.archivio_esercizi[i]["posizione"] == j + 1 && $scope.archivio_esercizi[i]["n_allenamento"] == $scope.archivio_allenamento[id]["n_allenamento"]) {
                                        ordinati.push($scope.archivio_esercizi[i]);
                                        j = j + 1;
                                        break;
                                    }
                                }
                            }
                            for (var i = 0; i < $scope.archivio_esercizi.length; i++) {
                                var nuovoes = document.createElement("li");
                                nuovoes.innerHTML = "<span style='font-weight:bold'>Esercizio :</span>" + " " + ordinati[i]["esercizio"]["nome"] + " " + "<span style='font-weight:bold'>Ripetizioni fatte :</span>" + " " + ordinati[i]["ripetizioni_riuscite"] + " " + "<span style='font-weight:bold'>con :</span>" + " " + ordinati[i]["peso_usato"] + "kg";
                                elementw.appendChild(nuovoes);
                            }
                            var nuovoes = document.createElement("p");
                            nuovoes.innerHTML = " ";
                            elementw.appendChild(nuovoes);
                            var nuovoes = document.createElement("p");
                            nuovoes.innerHTML = "<span style='font-weight:bold'>Ora Inizio :</span>" + " " + $scope.archivio_allenamento[id]["ora_inizio"];
                            elementw.appendChild(nuovoes);
                            var nuovoes = document.createElement("p");
                            nuovoes.innerHTML = "<span style='font-weight:bold'>Ora Fine :</span>" + " " + $scope.archivio_allenamento[id]["ora_fine"];
                            elementw.appendChild(nuovoes);
                            var nuovoes = document.createElement("p");
                            nuovoes.innerHTML = "<span style='font-weight:bold'>Note :</span>" + " " + $scope.archivio_allenamento[id]["note"];
                            elementw.appendChild(nuovoes);

                        }
                    })
                }

            }]);






   