angular.module('myApp',['ui.router','myApp.controllers'])
.config(function($stateProvider,$urlRouterProvider){
    $urlRouterProvider.otherwise("/inicio");
    $stateProvider
    .state('inicio',{
        url:"/inicio",
        templateUrl:"inicio.html"
    })

    .state('alugueis',{
        url:"/alugueis",
        templateUrl: "alugueis.html",
        controller: "AluguelController"
    })
});