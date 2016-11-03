app.controller("controller", function($scope) {
    $scope.firstName = "John";
    $scope.lastName= "Doe";
    $scope.age = sum(10, 20);
}); 

function sum(a, b) {
	return a + b;
}