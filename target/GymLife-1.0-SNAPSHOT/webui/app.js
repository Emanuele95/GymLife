
angular.module('GymLife',
                                    [
                                        'ngAnimate',
                                        'ngMessages',
                                        'ngRoute',
                                        'ngCookies',
                                        'GymLife.templateComuneModule',
                                        'GymLife.ProfiloModule',
                                        'GymLife.LoginModule',
                                        'GymLife.RegisterModule',
                                        'GymLife.AllenatiModule',
                                        'GymLife.ArchivioModule',
                                        'GymLife.SchedePersonaliModule',
                                        'GymLife.ConsigliaSchedaModule',
                                        'GymLife.EserciziModule',
                                        'GymLife.PrevenzioneStreatchingModule',
                                        'GymLife.StatisticheGlobaliModule',
                                        'GymLife.MassimaliMisurazioniModule',

                                    ])
.config(['$routeProvider',
    function ($routeProvider){
        $routeProvider
            .when('/profilo', {
                controller: 'ProfiloController',
                templateUrl: 'webui/Profilo/profilo.html',
            })
            
            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'webui/Login/login.html',
            })
            
            .when('/registrazione', {
                controller: 'RegisterController',
                templateUrl: 'webui/Register/registrazione.html',
            })
            
             .when('/allenati', {
                controller: 'AllenatiController',
                templateUrl: 'webui/Allenati/allenati.html',
            })
            
            .when('/archivio', {
                controller: 'ArchivioController',
                templateUrl: 'webui/Archivio/archivio.html',
            })
            
            .when('/schede_personali', {
                controller: 'SchedePersonaliController',
                templateUrl: 'webui/SchedePersonali/schede_personali.html',
            })
            
             .when('/consiglia_scheda', {
                controller: 'ConsigliaSchedaController',
                templateUrl: 'webui/ConsigliaScheda/consiglia_scheda.html',
            })
            
            .when('/esercizi', {
                controller: 'EserciziController',
                templateUrl: 'webui/Esercizi/esercizi.html',
            })
            
             .when('/massimali_misurazioni', {
                controller: 'MassimaliMisurazioniController',
                templateUrl: 'webui/MassimaliMisurazioni/massimali_misurazioni.html',
            })
            
            .when('/prevenzione_streatching', {
                controller: 'PrevenzioneStreatchingController',
                templateUrl: 'webui/PrevenzioneStreatching/prevenzione_streatching.html',
            })
            
            .when('/statistiche_globali', {
                controller: 'StatisticheGlobaliController',
                templateUrl: 'webui/StatisticheGlobali/statistiche_globali.html',
            })
            
            .otherwise({ redirectTo: '/profilo' });
    }
])
.config(function($httpProvider) {
	  $httpProvider.defaults.useXDomain = true;
      $httpProvider.defaults.headers.common['X-Requested-With'];
})


.constant('BackendCfg',  {
    url: '/GymLife',
    setupHttp: function(http) {
        http.defaults.useXDomain = true;
        http.defaults.withCredentials = true;
    }
})

