package com.eng.GRH.doa;

import com.eng.GRH.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeDOAImpl implements EmployeeDOA{
    private EntityManager entityManager;


    @Autowired
    public EmployeeDOAImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee", Employee.class);
        List<Employee> dbEmployees=theQuery.getResultList();
        return dbEmployees;
    }


    @Override
    public Employee findByid(String id) {
        Employee dbEmployee=entityManager.find(Employee.class,id);
        return dbEmployee;
    }

    @Override
    public Employee save(Employee employee) {

        Employee dbEmployee=entityManager.merge(employee);
        return dbEmployee;

    }

    @Override
    public void deleteById(int id) {
        Employee dbEmployee=entityManager.find(Employee.class,id);
        entityManager.remove(dbEmployee);

    }
}
