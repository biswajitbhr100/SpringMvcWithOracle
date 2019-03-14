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
		<div class="generic-container" ng-controller="DeptController as ctrl">
			<div class="panel panel-default">
				<div class="panel panel-heading">
					<span class="lead">Dept Management</span>
				</div>
				<div class="formcontainer">
					<form ng-submit="ctrl.submit()" name="deptForm" class="form-horizontal">
						<input type="hidden" ng-model="ctrl.dept.id" />
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="deptno">DEPTNO</label>
								<div class="col-md-7">
									<input type="number" ng-model="ctrl.dept.deptno" id="deptno" class="form-control input-sm" placeholder="Enter Deptno" required />
									<div class="hasError" ng-show="deptForm.$dirty">
										<span ng-show="deptForm.deptno.$error.required">This is required field</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="dname">DNAME</label>
								<div class="col-md-7">
									<input type="text" ng-model="ctrl.dept.dname" id="dname" class="username form-control input-sm" placeholder="Enter DName" required />
									<div class="hasError" ng-show="deptForm.$dirty">
										<span ng-show="deptForm.dname.$error.required">This is required field</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="loc">LOCATION</label>
								<div class="col-md-7">
									<input type="text" ng-model="ctrl.dept.loc" id="loc" class="username form-control input-sm" placeholder="Enter Location" required />
									<div class="hasError" ng-show="deptForm.$dirty">
										<span ng-show="deptForm.loc.$error.required">This is required field</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-actions floatRight">
								<input type="submit" value="{{!ctrl.dept.id ? 'Create' : 'Update'}}" class="btn btn-primary btn-sm">
								<button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="deptForm.$pristine">Reset</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading"><span class="lead">Depts</span>
					<input ng-model="search.dname" placeholder="Search DName" class="username form-control input-sm">
				</div>
				<div class="tablecontainer">
					<table class="table table-hover">
						<thead>
							<tr>
								<td>DEPTNO</td>
								<td>DNAME</td>
								<td>LOCATION</td>
								<td width="30%">ACTIONS</td>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="d in ctrl.depts | filter:search">
								<td><span ng-bind="d.deptno"></span></td>
								<td><span ng-bind="d.dname"></span></td>
								<td><span ng-bind="d.loc"></span></td>
								<td>
									<button type="button" ng-click="ctrl.edit(d.deptno)" class="btn btn-success custom-width">Edit</button>
									<button type="button" ng-click="ctrl.remove(d.dname)" class="btn btn-danger custom-width">Delete</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/dept_service.js' />"></script>
	<script src="<c:url value='/static/js/controller/dept_controller.js' />"></script>
	</body>
</html>