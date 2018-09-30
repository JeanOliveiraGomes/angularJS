var aluguelApp = angular.module("AluguelControllers", []);
var urlBase = "http://localhost:8080/api/";

aluguelApp.controller("AluguelController", function ($scope, $http) {

    $scope.listar = function () {
        $http.get(urlBase + "alugueis").then(response => {
            $scope.alugueis = response.data;
            
        }).catch( (data, status) => {
        	
            window.alert("Aconteceu algum problema ! Codigo do erro: " + data.status + " Error: " +data.data.error);
        })
    }
    $scope.novo = function(){
    	$scope.aluguel = ""
    }
    $scope.listar();
    
    $scope.salvar = function () {
        if(!$scope.aluguel.identifier){
        	$http.post(urlBase +"alugueis/",$scope.aluguel).then(response =>{
        		$scope.listar();
        		$scope.novo();
        	}).catch( (data, status) => {
            	
                window.alert("Aconteceu algum problema ! Codigo do erro: " + data.status + " Error: " +data.data.error);
            })
        }else{
        	$http.put(urlBase +"alugueis/"+$scope.aluguel.identifier, $scope.aluguel).then(response =>{
        		$scope.listar();
        		$scope.novo();
        	}).catch( (data, status) => {
            	
                window.alert("Aconteceu algum problema ! Codigo do erro: " + data.status + " Error: " +data.data.error);
            })
        }
    }
    $scope.editar = function(aluguelSel){
    	$scope.aluguel = angular.copy(aluguelSel)
    	$scope.aluguel.fimAnuncio = new Date($scope.aluguel.fimAnuncio);
    }
  
    $scope.deletar = function(aluguelSel){
    	if(window.confirm("Tem certeza ?")){
    		$http.delete(urlBase+"alugueis/" +aluguelSel.identifier).then(
    				function(response){
    					$scope.listar();
    				}).catch(response=>{
    	        		 window.alert("Aconteceu algum problema ! Codigo do erro: " + data.status + " Error: " +data.data.error);
    	        	});
    	}
    }
    
    $scope.orderByMe =  function (AluguelOrdenado){
    	
    	$scope.myOrderBy = AluguelOrdenado;	
    }
});
