'use strict';
angular.module('empApp').factory('DeptService' , ['$http' , '$q' , function($http,$q){
	var rest_uri = "http://localhost:5050/SpringMvcWithOracle/depts/";
	var factory = {
			fetchAllDepts : fetchAllDepts,
			createDept : createDept,
			updateDept : updateDept,
			deleteDept : deleteDept
	};
	return factory;
	function fetchAllDepts(){
		console.log('Fetching All Depts');
		var deferred = $q.defer();
		$http.get(rest_uri).then(function(response){
			deferred.resolve(response.data);
		},function(errResponse){
			console.error('Error in fetching all Depts');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
	function createDept(dept){
		var deferred = $q.defer();
		$http.post(rest_uri,dept).then(function(response){
			deferred.resolve(response.data);
		},function(errResponse){
			console.error('Error while adding dept');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
	function updateDept(dept,deptno){
		//console.log(deptno);
		var deferred = $q.defer();
		$http.put(rest_uri+deptno,dept).then(function(response){
			deferred.resolve(response.data);
		},function(errResponse){
			console.error('Error while updating dept');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
	function deleteDept(dname){
		var deferred = $q.defer();
		$http.delete(rest_uri+dname).then(function(response){
			deferred.resolve(response.data);
		},function(errResponse){
			console.error('Error while deleting dept')
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
}]);