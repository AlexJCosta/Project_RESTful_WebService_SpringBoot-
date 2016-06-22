var app = angular.module("ProductManagement", []);
         
            app.controller("ProductManagementController", function($scope, $http) {
               
                $scope.submitProduct = function() {
                    var url = "http://localhost:8080/registering_product?name="+$scope.form.nameProduct;
                    $http({
	                     method : 'POST',
	                     url : url
	                 }).then(function successCallback(response) {
	                	 showAnswer(response, 'alert alert-success');
	                 }, function errorCallback(response) {
	                	 showAnswer(response, 'alert alert-danger');
	                 });
               };
                function clearForm() {
                    $scope.form.searchFor = "";
                };
                function showAnswer(response, alertClass){
                	if (response.data == null || response.status == 404) {
                		$("#alertAnswer").attr('class', 'alert alert-warning');	
                		$('#alertAnswer').text("Ops! (404) I'm sorry.");
                		$("#alertAnswer").hide("slow").fadeIn(300).delay(1500).fadeOut(600);
                	}else{
                		$("#alertAnswer").attr('class', alertClass);	
                		$('#alertAnswer').text(response.data.message);
                		$("#alertAnswer").hide("slow").fadeIn(300).delay(1500).fadeOut(600);
                		clearForm();
                	}
                }
            });
