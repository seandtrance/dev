app.controller("controller", 	function ($scope, $http) {
   $scope.getMessage = function() {
	   $http.get('api/messages/message').
	    success(function(data) {
	        $scope.respmessage = data
	    })
   } 
   
   $scope.helloMessage = function($name) {
	   $http.get('api/messages/hello/{name}').
	    success(function(data) {
	        $scope.resphellomessage = data
	    })
   } 
});
