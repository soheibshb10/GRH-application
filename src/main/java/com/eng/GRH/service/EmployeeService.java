package com.eng.GRH.service;

import com.eng.GRH.entity.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeService {
    public List<Employee>getALLStudents();
    Employee saveEmployee(Employee employee);

    public long calculeDateBetween(LocalDate startDate, LocalDate endDate);

    public long getNumber_Employee_onconjet();
    Employee getEmployeeById(String id);
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(String id);

}
