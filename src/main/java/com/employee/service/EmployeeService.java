package com.employee.service;

import java.util.List;

import com.employee.Entity.Employee;
import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeResponse;

public interface EmployeeService {

	EmployeeDto createUserAll( EmployeeDto employeeDto);

	Employee getallById(long id);

	EmployeeDto updatePost(EmployeeDto employeeDto, long id);

	void deletePostById(long id);

	List<EmployeeDto> getAllUsers();

	List<Employee> getPaginatedPosts(Integer pageNo, Integer pageSize, String sortBy);

}
