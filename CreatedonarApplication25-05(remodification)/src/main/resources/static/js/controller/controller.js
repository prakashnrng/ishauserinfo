'use strict';
var myApp = angular.module("loginApp",[]);
myApp.controller("loginController",['$log','$scope','localService','$http',function($log,$scope,localService,$http){
	$log.log("------------Controller-----------");
	var self = this;
	self.registerData = {registrationFirstName:'',registrationLastName:'',registrationEmail:'',
					registrationMobile:'',registrationPasscode:'',registrationConfirmPasscode:''};
	
	self.donar_info={ donorfirstname:"",donorlastname:"",donoremail:"",donormobile:"",donorAddress:"",
			donorRegion:"",donorCity:"",donorState:"",donorCenter:"",
			bankDetailsAccountHolderName:"",bankDetailsBankName:'',bankDetailsBranchName:"",bankDetailsAccountNo:"",
			bankDetailsIFSCCode:"",micr:"",bankDetailsAccountType:"",
			paymentDetailsStartDate:"",paymentDetailsEndDate:"",paymentDetailsAmountInRs:"",
			paymentDetailsFrequency:"",comments:""};
	
	
	self.createDonor=createDonor;
	self.registerd = [];
	self.SuccessMessage='';
	self.ErrorMessage='';
	self.DonorsList = [];
	self.createDonor=createDonor;
	self.updateDonor=updateDonor;
	self.successMessage = '';
    self.errorMessage = '';
	self.onlyNumbers = /^\d+([,.]\d+)?$/;
	
	var url='http://localhost:6511/donar1/';
	
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
	
	
	 function createDonor() {
         console.log('create donor');
         
         console.log(self.donar_info);
         localService.createDonor(self.donar_info)
             .then(
                 function (response) {
                     console.log('donor created successfully');
                     self.successMessage = 'donor created successfully';
                     self.errorMessage='';
                     self.done = true;
                  /*   self.user={};*/
                 },
                 function (errResponse) {
                     console.error('Error while creating donor');
                  /*   self.errorMessage = 'Error while creating donor:' + errResponse.data.errorMessage;
                     self.successMessage='';*/
                 }
             );
     };
	 
	 function updateDonor() {
		 console.log('update donor');
		 console.log(self.donar_info);
		 localService.updateDonor(self.donar_info)
		   .then(
	          function (response){
	        	  console.log('donor updated successfully');
	        	  self.successMessage = 'Donor updated successfully';
	          },
	          function(errResponse) {
	        	  console.error('Error while creating donor');
	          }
				   );
	 };
	 
         
        
  
	
	
}]);
/*myApp.directive("matchPassword", function () {
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
}); */
