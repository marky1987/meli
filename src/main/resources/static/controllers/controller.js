app.controller("climaCtrl", function($scope, $http) {

	$scope.calcularClima = function () {
	$http.get("/info")
    .then(function(response) {
        $scope.status = response.status;
        $scope.sequia = response.data.cantidadPeriodoSequia;
        $scope.lluvia = response.data.cantidadPeriodoLluvia
        $scope.diaLluvia = response.data.diaPicoMaxLluvia;
        $scope.optimo = response.data.periodoCondicionesOptimaYPresion;
    });
    }
	
 });