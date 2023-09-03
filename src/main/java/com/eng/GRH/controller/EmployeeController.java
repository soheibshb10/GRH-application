package com.eng.GRH.controller;

import com.eng.GRH.entity.Employee;
import com.eng.GRH.exception.EmployeeErrorResponse;
import com.eng.GRH.exception.ResourceNotFoundException;
import com.eng.GRH.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static org.springframework.web.servlet.function.ServerResponse.notFound;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getALLStudents());
        return "employees";
    }

    @GetMapping("/employees/new")
    public String createEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employee.setNomb_j(employeeService.calculeDateBetween(employee.getDebut_ca_cr(), employee.getFin_ca_cr()));
        employee.setDate_rev(employee.getFin_ca_cr().plusDays(1));
        employee.setDate_prev(employee.getDate_rev().plusDays(28));
        employee.setFin_prev(employee.getDate_prev().plusDays(21));
        employee.setOnconjet(true);
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable String id, Model model) {
        try {
            model.addAttribute("employee", employeeService.getEmployeeById(id));
            return "edit_employee";
        } catch (Exception exception) {

            throw new ResourceNotFoundException("employee id not foumd " + id, id);

            // return "redirect:/employees/notFound";
        }

    }

    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable String id, @ModelAttribute("employee") Employee employee, Model model) {
        try {
            Employee existingEmployee = employeeService.getEmployeeById(id);
            existingEmployee.setMatricule(employee.getMatricule());
            existingEmployee.setNom(employee.getNom());
            existingEmployee.setPrenom(employee.getPrenom());
            existingEmployee.setDebut_ca_cr(employee.getDebut_ca_cr());
            existingEmployee.setFin_ca_cr(employee.getFin_ca_cr());
            existingEmployee.setType(employee.getType());
            existingEmployee
                    .setNomb_j(employeeService.calculeDateBetween(employee.getDebut_ca_cr(), employee.getFin_ca_cr()));
            existingEmployee.setDate_rev(existingEmployee.getFin_ca_cr().plusDays(1));
            existingEmployee.setDate_prev(existingEmployee.getDate_rev().plusDays(28));
            existingEmployee.setFin_prev(existingEmployee.getDate_prev().plusDays(21));

            employeeService.updateEmployee(existingEmployee);
            return "redirect:/employees";
        } catch (Exception exception) {

            throw new ResourceNotFoundException("employee id not foumd " + id, id);

            // return "redirect:/employees/notFound";
        }
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    // @ExceptionHandler
    // public ResponseEntity<EmployeeErrorResponse>
    // handlleException(ResourceNotFoundException exc) {
    // EmployeeErrorResponse error = new EmployeeErrorResponse();

    // error.setStatus(HttpStatus.NOT_FOUND.value());
    // error.setMessage(exc.getMessage());
    // error.setTimeStamp(System.currentTimeMillis());

    // return new ResponseEntity<EmployeeErrorResponse>(error,
    // HttpStatus.NOT_FOUND);

    // }

}
