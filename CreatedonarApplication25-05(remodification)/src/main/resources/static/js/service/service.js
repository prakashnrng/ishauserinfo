'use strict';
myApp.factory("localService",['$http','$log','$q',function($http,$log,$q){
	var factory = {
			register : registration	,
			fetchDonors  : fetchDonors
	};
	return factory;
	
	function registration(registerData){
		var deferred = $q.defer();
		$log.log("---Register servivce entered---");
		$http.post('http://localhost:6512/hello1/',registerData)
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
		return $http.get("http://localhost:6512/hello1/")
		.then(function(fetchResponse){
			return fetchResponse.data;
			
		},function(errResponse){
			$log.error('Error while fetching Donors');
			return $q.reject(errResponse);
		}
		);
	};

}]);