package com.employee.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.employee.service.DeptService;
import com.employee.model.Dept;
@RestController("deptRestController")
public class DeptController {
	@Autowired
	private DeptService deptService;
	@RequestMapping(value = "/depts/",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dept>> allDepts() {
		List<Dept> depts = deptService.getAllDept();
		if(depts.isEmpty()) {
			return new ResponseEntity<List<Dept>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Dept>>(depts,HttpStatus.OK);
	}
	@RequestMapping(value = "/depts/{deptno}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dept> getDeptByDeptno(@PathVariable("deptno")int deptno){
		Dept dept = deptService.getDept(deptno);
		System.out.println(dept);
		if(dept == null) {
			return new ResponseEntity<Dept>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Dept>(dept,HttpStatus.OK);
	}
	@RequestMapping(value = "/depts/dname/{dname}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dept> getDeptByDname(@PathVariable("dname")String dname){
		Dept dept = deptService.getDeptByName(dname);
		if(dept == null) {
			return new ResponseEntity<Dept>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Dept>(dept,HttpStatus.OK);
	}
	@RequestMapping(value = "/depts/",method = RequestMethod.POST)
	public ResponseEntity<Void> createDept(@RequestBody Dept dept,UriComponentsBuilder builder){
		if(deptService.isDeptExist(dept)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		deptService.saveDept(dept);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/depts/{deptno}").buildAndExpand(dept.getDeptno()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	@RequestMapping(value = "/depts/{deptno}",method = RequestMethod.PUT)
	public ResponseEntity<Dept> updateDept(@PathVariable("deptno") int deptno,@RequestBody Dept dept){
		Dept currentDept = dept;//deptService.getDept(deptno);
		//System.out.println(deptno + " " + currentDept);
		if(currentDept == null) {
			return new ResponseEntity<Dept>(HttpStatus.NOT_FOUND);
		}
		currentDept.setDeptno(deptno);
		deptService.updateDept(currentDept);
		return new ResponseEntity<Dept>(currentDept,HttpStatus.OK);
	}
	@RequestMapping(value = "/depts/{dname}",method = RequestMethod.DELETE)
	public ResponseEntity<Dept> deleteDept(@PathVariable("dname") String dname){
		Dept dept = deptService.getDeptByName(dname);
		if(dept == null) {
			return new ResponseEntity<Dept>(HttpStatus.NOT_FOUND);
		}
		deptService.deleteDept(dname);
		return new ResponseEntity<Dept>(HttpStatus.NO_CONTENT);
	}
}
