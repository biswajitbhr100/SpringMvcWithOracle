<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Dept Management</title>
		<style type="text/css">
			.name.ng-dirty.ng-invalid-required{
				background-color : red;
			}
			.address.ng-dirty.ng-invalid-required{
				background-color : red;
			}
		</style>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		
	</head>
	<body ng-app="empApp" class="ng-cloak">
		<div ng-controller="DeptController as dctrl">
		<div class="generic-container" ng-controller="EmpController as ctrl">
			<div class="panel panel-default">
				<div class="panel panel-heading">
					<span class="lead">Emp Management</span>
				</div>
				<div class="formcontainer">
					<form ng-submit="ctrl.submit()" name="empForm" class="form-horizontal">
						<input type="hidden" ng-model="ctrl.emp.id" />
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="empno">EMPNO</label>
								<div class="col-md-7">
									<input type="number" ng-model="ctrl.emp.empno" id="empno" class="form-control input-sm" placeholder="Enter Empno" required />
									<div class="hasError" ng-show="empForm.$dirty">
										<span ng-show="empForm.empno.$error.required">This is required field</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="ename">ENAME</label>
								<div class="col-md-7">
									<input type="text" ng-model="ctrl.emp.ename" id="ename" class="username form-control input-sm" placeholder="Enter Name" required />
									<div class="hasError" ng-show="empForm.$dirty">
										<span ng-show="empForm.ename.$error.required">This is required field</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="job">JOB</label>
								<div class="col-md-7">
									<input type="text" ng-model="ctrl.emp.job" id="job" class="username form-control input-sm" placeholder="Enter Designation" required />
									<div class="hasError" ng-show="empForm.$dirty">
										<span ng-show="empForm.job.$error.required">This is required field</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="sal">SAL</label>
								<div class="col-md-7">
									<input type="number" ng-model="ctrl.emp.sal" id="sal" class="form-control input-sm" placeholder="Enter Salary" required />
									<div class="hasError" ng-show="empForm.$dirty">
										<span ng-show="empForm.sal.$error.required">This is required field</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="comm">COMM</label>
								<div class="col-md-7">
									<input type="number" ng-model="ctrl.emp.comm" id="comm" class="form-control input-sm" placeholder="Enter Commision" required />
									<div class="hasError" ng-show="empForm.$dirty">
										<span ng-show="empForm.comm.$error.required">This is required field</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="hiredate">HIREDATE</label>
								<div class="col-md-7">
									<input type="date" ng-model="ctrl.emp.hiredate" id="hiredate" class="form-control input-sm" required />
									<div class="hasError" ng-show="empForm.$dirty">
										<span ng-show="empForm.hiredate.$error.required">This is required field</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="mgr">MGR</label>
								<div class="col-md-7">
									<input type="number" ng-model="ctrl.emp.mgr" id="mgr" class="form-control input-sm" placeholder="Enter MGR" />
									<div class="hasError" ng-show="empForm.$dirty">
										<span ng-show="empForm.mgr.$error.required">This is required field</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="deptno">DEPTNO</label>
								<div class="col-md-7">
									<select class="form-control input-sm" ng-model="ctrl.emp.deptno" id="deptno" required>
										<option value="" selected disabled>Select Dept</option>
										<option ng-repeat="d in dctrl.depts" value="d.deptno">
											{{d.dname}}
										</option>
									</select>
									<div class="hasError" ng-show="empForm.$dirty">
										<span ng-show="empForm.dept.$error.required">This is required field</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-actions floatRight">
								<input type="submit" value="{{!ctrl.emp.id ? 'Create' : 'Update'}}" class="btn btn-primary btn-sm">
								<button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="empForm.$pristine">Reset</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading"><span class="lead">Emps</span>
					<input ng-model="search.ename" placeholder="Search Name" class="username form-control input-sm">
				</div>
				<div class="tablecontainer">
					<table class="table table-hover">
						<thead>
							<tr>
								<td>EMPNO</td>
								<td>NAME</td>
								<td>JOB</td>
								<td>SAL</td>
								<td>COMM</td>
								<td>HIREDATE</td>
								<td>MGR</td>
								<td>DEPTNO</td>
								<td width="30%">ACTIONS</td>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="d in ctrl.emps | filter:search">
								<td><span ng-bind="d.empno"></span></td>
								<td><span ng-bind="d.ename"></span></td>
								<td><span ng-bind="d.job"></span></td>
								<td><span ng-bind="d.sal"></span></td>
								<td><span ng-bind="d.comm"></span></td>
								<td><span ng-bind="d.hiredate"></span></td>
								<td><span ng-bind="d.mgr"></span></td>
								<td><span ng-bind="d.deptno.deptno"></span></td>
								<td>
									<button type="button" ng-click="ctrl.edit(d.empno)" class="btn btn-success custom-width">Edit</button>
									<button type="button" ng-click="ctrl.remove(d.empno)" class="btn btn-danger custom-width">Delete</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/dept_service.js' />"></script>
	<script src="<c:url value='/static/js/controller/dept_controller.js' />"></script>
	<script src="<c:url value='/static/js/service/emp_service.js' />"></script>
	<script src="<c:url value='/static/js/controller/emp_controller.js' />"></script>
	</body>
</html>