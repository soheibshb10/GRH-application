package com.eng.GRH.service.impl;

import com.eng.GRH.entity.Employee;
import com.eng.GRH.repository.EmployeeRepository;
import com.eng.GRH.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeteServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeteServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public List<Employee> getALLStudents() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public long calculeDateBetween(LocalDate startDate, LocalDate endDate){
        long between = ChronoUnit.DAYS.between(startDate, endDate);
        return between;

    }

    @Override
    public long getNumber_Employee_onconjet(){
        int nmb=0;
        List<Employee>employees=employeeRepository.findAll();
        for (Employee employee:employees){
            if (employee.isOnconjet())
                nmb++;
        }
       return nmb;
    }

    @Override
    public Employee getEmployeeById(String id) {
        Optional<Employee>result= employeeRepository.findById(id);
        Employee employee=null;

        if(result.isPresent()){
            employee=result.get();
        }
        else{
            throw new RuntimeException("Did not find Employee id "+id);
        }
      return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }


    @Override
    public void deleteEmployeeById(String id) {
        Optional<Employee>result= employeeRepository.findById(id);

        if(result.isPresent()){
            employeeRepository.deleteById(id);

        }
    }


}
