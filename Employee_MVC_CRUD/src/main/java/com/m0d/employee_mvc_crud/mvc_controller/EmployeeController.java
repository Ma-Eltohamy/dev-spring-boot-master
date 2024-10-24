package com.m0d.employee_mvc_crud.mvc_controller;

import com.m0d.employee_mvc_crud.entity.Employee;
import com.m0d.employee_mvc_crud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // Listing all the employees

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employeesList", employeeService.findAllSortedByFirstName());

        // Instead of calling the db to get the employee by ID
        model.addAttribute("employeeDTO", new Employee());
        return "list";
    }

    // Adding a new Employee

    @GetMapping("/showAddForm")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("operation", "Add");
        return "employeeForm";
    }

    // Adding a new Employee

    @PostMapping("/showUpdateForm")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, Model model){
        model.addAttribute("operation", "Update");
        return "employeeForm";
    }


    // Processing the adding operation

    @PostMapping("/processOperation")
    public String processOperation(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors())
            return "employeeForm";

        String operationMessage;

        if(employee.getId() == null)  // This is an adding operation
            operationMessage = "Employee has been added to the system successfully!";
        else
            operationMessage = "Employee has been updated successfully!";

        model.addAttribute("operationMessage", operationMessage);

        employeeService.save(employee);
        return "successfulOperation";
    }


    // Deleting an Employee
    // I will post the employee data through a post mapping to avoid getting it from the db
    // because I still know nothing about caching
    @PostMapping("/deleteConfirmation")
    public String deleteEmployee(@ModelAttribute("employee") Employee employee){
        return "deleteConfirmation";
    }

    @PostMapping("/processDeletion")
    public String processDeletion(@RequestParam("employeeId") Integer employeeId, Model model){
        employeeService.delete(employeeId);
        String operationMessage = "The employee have been successfully deleted.";
        model.addAttribute("operationMessage", operationMessage);
        return "successfulOperation";
    }

    // In case you want to use url to delete you can use this
    @GetMapping("/processDeletionGet/")
    public String processDeletionGet(@RequestParam("employeeId") Integer employeeId, Model model){
        employeeService.delete(employeeId);
        String operationMessage = "The employee have been successfully deleted.";
        model.addAttribute("operationMessage", operationMessage);
        return "successfulOperation";
    }

}
