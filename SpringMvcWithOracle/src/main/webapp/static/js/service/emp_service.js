'use strict';
angular.module('empApp').factory('EmpService' , ['$http' , '$q' , function($http,$q){
	var rest_uri = "http://localhost:5050/SpringMvcWithOracle/emps/";
	var factory = {
			fetchAllEmps : fetchAllEmps,
			createEmp : createEmp,
			updateEmp : updateEmp,
			deleteEmp : deleteEmp
	};
	return factory;
	function fetchAllEmps(){
		console.log('Fetching All Emps');
		var deferred = $q.defer();
		$http.get(rest_uri).then(function(response){
			deferred.resolve(response.data);
		},function(errResponse){
			console.error('Error in fetching all Emps');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
	function createEmp(emp){
		var deferred = $q.defer();
		$http.post(rest_uri,emp).then(function(response){
			deferred.resolve(response.data);
		},function(errResponse){
			console.error('Error while adding emp');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
	function updateEmp(emp,empno){
		//console.log(deptno);
		var deferred = $q.defer();
		$http.put(rest_uri+empno,emp).then(function(response){
			deferred.resolve(response.data);
		},function(errResponse){
			console.error('Error while updating dept');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
	function deleteEmp(empno){
		var deferred = $q.defer();
		$http.delete(rest_uri+empno).then(function(response){
			deferred.resolve(response.data);
		},function(errResponse){
			console.error('Error while deleting emp')
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
}]);