'use strict';
var myApp = angular.module("loginApp",[]);
myApp.controller("loginController",['$log','$scope','localService',function($log,$scope,localService){
	$log.log("------------Controller-----------");
	var self = this;
	self.registerData = {registrationFirstName:'',registrationLastName:'',registrationEmail:'',
					registrationMobile:'',registrationPasscode:'',registrationConfirmPasscode:''};

	self.registerd = [];
	self.SuccessMessage='';
	self.ErrorMessage='';
	self.DonorsList = [];
	
	
	
	self.register = function register(){
		$log.log("-----Register Function-----");
		localService.register(self.registerData)
		.then(
			function(d){
				$log.log(self.registerData);
				self.registerd = d;
				self.SuccessMessage='New User Registerd SuccessFully';
				self.ErrorMessage='';
				//$log.log(self.registerd);
			},	
			function(errResponse){
				self.ErrorMessage='Error while Creating';
				$log.log("--------Error in Controller----");
			}
		);
	};

	self.fetchDonors = function fetchDonors(){
		$log.log("-----Fetch Donors------");
		localService.fetchDonors()
		.then(
				function(fetchResponse){
					$log.log("successfully fetched data");
					self.DonorsList = fetchResponse;
					//$log.log(self.DonorsList);
			
		},function(errResponse){
			$log.log("Error while fetching");
			alert("Error while fetching");
		})
		
	};
	self.fetchDonors();
}]);
myApp.directive("matchPassword", function () {
    return {
        require: "ngModel",
        scope: {
            otherModelValue: "=matchPassword"
        },
        link: function(scope, element, attributes, ngModel) {
            console.log("Passwordsssssssssss");
        	ngModel.$validators.matchPassword = function(modelValue) {
        		console.log(scope.otherModelValue);
                return modelValue == scope.otherModelValue;
            };
            scope.$watch("otherModelValue", function() {
            	console.log(scope.otherModelValue);
            	ngModel.$validate();
            });
        }
    };
});