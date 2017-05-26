'use strict';
myApp.factory("localService",['$http','$log','$q',function($http,$log,$q){
	var factory = {
			register : registration	,
			fetchDonors : fetchDonors,
			createDonor: createDonor
	};
	return factory;
	
	function registration(registerData){
		var deferred = $q.defer();
		$log.log("---Register servivce entered---");
		$http.post('http://localhost:6511/hello1/',registerData)
		.then(function(SuccesResponse){
			$log.log("----Registerd Successfully----");
			deferred.resolve(SuccesResponse.data);
		},
		function(ErrorResponse){
			$log.log("----Error while Registering----");
			deferred.reject(ErrorResponse);
		}
		);
		return deferred.promise;
	};
	
	function fetchDonors(){
		return $http.get("http://localhost:6511/hello1/")
		.then(function(fetchResponse){
			return fetchResponse.data;
			
		},function(errResponse){
			$log.error('Error while fetching Donors');
			return $q.reject(errResponse);
		}
		);
	};
	
	function createDonor(donar_info) {
	     console.log('Creating donor');
	     var deferred = $q.defer();
	     console.log('-------------------creteDonor service--------------');
	  
	     console.log(donar_info);
	     $http.post('http://localhost:6511/donar1/',donar_info)
	         .then(
	             function (response) {
	            	 console.log('response block');
	            	 console.log(donar_info);
	            //	 loadAlldonor();
	                 deferred.resolve(response.data);
	             },
	             function (errResponse) { 
	                console.error('Error while creating Donor :');
	                deferred.reject(errResponse);
	             }
	         );
	     return deferred.promise;
	 }

}]);
