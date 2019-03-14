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
import com.employee.model.Emp;
import com.employee.service.EmpService;
@RestController("empRestController")
public class EmpController {
	@Autowired
	private EmpService empService;
	@RequestMapping(value = "/emps/",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> allEmps() {
		List<Emp> emps = empService.getAllEmp();
		if(emps.isEmpty()) {
			return new ResponseEntity<List<Emp>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Emp>>(emps,HttpStatus.OK);
	}
	@RequestMapping(value = "/emps/{empno}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emp> getEmpByEmpno(@PathVariable("empno")int empno){
		Emp emp = empService.getEmp(empno);
		if(emp == null) {
			return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Emp>(emp,HttpStatus.OK);
	}
	@RequestMapping(value = "/emps/",method = RequestMethod.POST)
	public ResponseEntity<Void> createEmp(@RequestBody Emp emp,UriComponentsBuilder builder){
		if(empService.isEmpExist(emp)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		System.out.println("Inside save controller");
		empService.saveEmp(emp);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/emps/{empno}").buildAndExpand(emp.getEmpno()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	@RequestMapping(value = "/emps/{empno}",method = RequestMethod.PUT)
	public ResponseEntity<Emp> updateEmp(@PathVariable("empno") int empno,@RequestBody Emp emp){
		Emp currentEmp = emp;
		if(currentEmp == null) {
			return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		}
		currentEmp.setEmpno(empno);
		empService.updateEmp(currentEmp);
		return new ResponseEntity<Emp>(currentEmp,HttpStatus.OK);
	}
	@RequestMapping(value = "/emps/{empno}",method = RequestMethod.DELETE)
	public ResponseEntity<Emp> deleteEmp(@PathVariable("empno") int empno){
		Emp emp = empService.getEmp(empno);
		if(emp == null) {
			return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		}
		empService.deleteEmp(empno);
		return new ResponseEntity<Emp>(HttpStatus.NO_CONTENT);
	}
}
