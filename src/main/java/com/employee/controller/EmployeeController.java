package com.employee.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Entity.Employee;
import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
		
	@Autowired
	private ModelMapper mapper;
	

	@PostMapping
	public ResponseEntity<EmployeeDto> createUserAll( @RequestBody EmployeeDto dto) {
		return new ResponseEntity<>(employeeService.createUserAll(dto),HttpStatus.CREATED);
	}

	@GetMapping
	public List<EmployeeDto> getAllUsers(){
		return employeeService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee>  getallById(@PathVariable(value = "id") long id) {
	   return new ResponseEntity<>(employeeService.getallById(id),HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updatePost(@RequestBody EmployeeDto employeeDto, @PathVariable(name = "id") long id){
		EmployeeDto userResponse = employeeService.updatePost(employeeDto, id);
	    return new ResponseEntity<>(userResponse, HttpStatus.OK);

	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id){
    	employeeService.deletePostById(id);
        return new ResponseEntity<>("Employee  deleted successfully.", HttpStatus.OK);
	}
    
    @GetMapping("/page")
    public ResponseEntity<List<Employee>> getPaginatedPosts(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Employee> paginatedPosts = employeeService.getPaginatedPosts(pageNo, pageSize, sortBy);
        return ResponseEntity.ok(paginatedPosts);
    }
}