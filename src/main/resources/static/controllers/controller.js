app.controller("climaCtrl", function($scope, $http) {
	
	$scope.diaRequerido = false;
	
	$scope.validate = function() {
		$scope.diaRequerido = $scope.anio == null;	
	}
	
	$scope.calcularClima = function (anio) {
	if(!$scope.anio){
		$scope.diaRequerido = true;
		return false;
	}	
	$http.get("/?anio="+anio)
    .then(function(response) {
        $scope.status = response.status;
        $scope.sequia = response.data.cantidadPeriodoSequia;
        $scope.lluvia = response.data.cantidadPeriodoLluvia
        $scope.diaLluvia = response.data.diaPicoMaxLluvia;
        $scope.optimo = response.data.periodoCondicionesOptimaYPresion;
    });
    }
	
	$scope.limpiar = function (){
		$scope.anio = null;
		$scope.status = null;
	}
    
 });