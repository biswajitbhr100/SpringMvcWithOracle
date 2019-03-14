'use strict';
angular.module('empApp').controller('EmpController', ['$scope' , 'EmpService' , function($scope,EmpService){
	var self = this;
	self.emp = {id:null,empno:null,ename:'',job:'',sal:null,mgr:null,comm:null,hiredate:'',deptno:null};
	self.emps = [];
	self.submit = submit;
	self.edit = edit;
	self.remove = remove;
	self.reset = reset;
	//console.log(self.dept);
	fetchAllEmps();
	function fetchAllEmps(){
		EmpService.fetchAllEmps().then(function(d){
			self.emps = d;
		},function(errResponse){
			console.error('Error while fetching emps');
		});
	}
	function createEmp(emp){
		EmpService.createEmp(emp).then(fetchAllEmps,function(errResponse){
			console.error('Error while creating emp');
		});
	}
	function updateEmp(emp,empno){
		EmpService.updateEmp(emp,empno).then(fetchAllEmps,function(errResponse){
			console.error('Error while updating emp');
		});
	}
	function deleteEmp(empno){
		EmpService.deleteEmp(empno).then(fetchAllEmps,function(errResponse){
			console.error('Error while deleting emp');
		});
	}
	function submit(){
		
		if(self.emp.id === null){
			console.log(self.emp.hiredate);
			createEmp(self.emp);
		}else{
			updateEmp(self.emp,self.emp.empno);
		}
		reset();
	}
	function edit(empno){
		for(var i = 0 ; i < self.emps.length ; i++){
			if(self.emps[i].empno === empno){
				self.emp = angular.copy(self.emps[i]);
				break;
			}
		}
	}
	function remove(empno){
		if(self.emp.empno === empno){
			reset();
		}
		deleteEmp(empno);
	}
	function reset(){
		self.emp = {id:null,empno:null,ename:'',job:'',sal:null,mgr:null,comm:null,hiredate:'',deptno:null};
		$scope.empForm.$setPristine();
	}
	
}]);