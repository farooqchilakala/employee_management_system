package com.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.employee.Entity.Employee;
import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeResponse;
import com.employee.exception.ResourceNotFoundException;
import com.employee.repository.EmployeeRepository;




@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDto createUserAll(EmployeeDto employeeDto) {
			Employee employee= maptoEntity(employeeDto);
			Employee employee2 = employeeRepository.save(employee);
			EmployeeDto dto =mapToDto(employee2);
			return dto;
	}
	
	private EmployeeDto mapToDto(Employee employee2) {
			EmployeeDto employeeDto   = mapper.map(employee2, EmployeeDto.class);
			return employeeDto;
	}
	
	private Employee maptoEntity(EmployeeDto employeeDto) {
			Employee employee = mapper.map(employeeDto, Employee.class);
			return employee;
	}

	@Override
	public List<EmployeeDto> getAllUsers() {
			List<Employee> users = employeeRepository.findAll();
			return users.stream().map(use -> mapToDto(use)).collect(Collectors.toList());
    }

	@Override
	public Employee getallById(long id) {
			Employee uesrs = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id)) ;
			return uesrs;
		
		
	}

	@Override
	public EmployeeDto updatePost(EmployeeDto dto, long id) {
			Employee existingUser = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
			existingUser.setFirstname(dto.getFirstname());
			existingUser.setLastname(dto.getLastname());
			existingUser.setEmail(dto.getEmail());
			existingUser.setMobile(dto.getMobile());
			Employee updatedUser = employeeRepository.save(existingUser);
			return mapToDto(updatedUser);
	}

	@Override
	public void deletePostById(long id) {
			Employee user = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
			employeeRepository.delete(user);
	}
	@Override
	public List<Employee> getPaginatedPosts(Integer pageNo, Integer pageSize, String sortBy) {
			Pageable of = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<Employee> paginated = employeeRepository.findAll(of);
			return paginated.getContent();
	}

	



}