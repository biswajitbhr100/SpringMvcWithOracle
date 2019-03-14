'use strict';
angular.module('empApp').controller('DeptController', ['$scope' , 'DeptService' , function($scope,DeptService){
	var self = this;
	self.dept = {id:null,deptno:null,dname:'',loc:''};
	self.depts = [];
	self.submit = submit;
	self.edit = edit;
	self.remove = remove;
	self.reset = reset;
	//console.log(self.dept);
	fetchAllDepts();
	function fetchAllDepts(){
		DeptService.fetchAllDepts().then(function(d){
			self.depts = d;
		},function(errResponse){
			console.error('Error while fetching depts');
		});
	}
	function createDept(dept){
		DeptService.createDept(dept).then(fetchAllDepts,function(errResponse){
			console.error('Error while creating dept');
		});
	}
	function updateDept(dept,deptno){
		DeptService.updateDept(dept,deptno).then(fetchAllDepts,function(errResponse){
			console.error('Error while updating dept');
		});
	}
	function deleteDept(deptno){
		DeptService.deleteDept(deptno).then(fetchAllDepts,function(errResponse){
			console.error('Error while deleting dept');
		});
	}
	function submit(){
		console.log("Inside Submit");
		if(self.dept.id === null){
			createDept(self.dept);
		}else{
			updateDept(self.dept,self.dept.deptno);
		}
		reset();
	}
	function edit(deptno){
		for(var i = 0 ; i < self.depts.length ; i++){
			if(self.depts[i].deptno === deptno){
				self.dept = angular.copy(self.depts[i]);
				break;
			}
		}
	}
	function remove(dname){
		if(self.dept.dname === dname){
			reset();
		}
		deleteDept(dname);
	}
	function reset(){
		self.dept = {id:null,deptno:null,dname:'',loc:''};
		$scope.deptForm.$setPristine();
	}
}]);