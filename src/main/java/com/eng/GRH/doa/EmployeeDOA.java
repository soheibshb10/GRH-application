package com.eng.GRH.doa;

import com.eng.GRH.entity.Employee;

import java.util.List;


public interface EmployeeDOA {

    public List<Employee> findAll();
    public Employee findByid(String id);

    public Employee save(Employee employee);
    public void deleteById(int id);





}
