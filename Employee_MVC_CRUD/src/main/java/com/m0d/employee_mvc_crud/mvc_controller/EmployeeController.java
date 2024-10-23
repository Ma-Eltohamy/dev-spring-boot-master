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

    @GetMapping("/")
    public String getEmployees(Model model){
        // I know that I am passing the passwords also to the View
        model.addAttribute("employeesList", employeeService.findAll());
        model.addAttribute("employeeDTO", new Employee());
        return "home";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee){
        return "update_employee";
    }

    @PostMapping("/processUpdate")
    public String processUpdate(@Valid @ModelAttribute Employee employee, BindingResult bindingResult){

        System.out.println(bindingResult.toString());

        if(bindingResult.hasErrors())
            return "update_employee";

        employeeService.update(employee);
        return "successful_update";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("employee") Employee employee){
        return "delete_confirmation";
    }

    @PostMapping("/processDeletion")
    public String processDeletion(@RequestParam("employeeId") Integer employeeId){
        System.out.println(employeeId);

        employeeService.delete(employeeId);
        return "successful_deletion";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "add_employee";
    }

    @PostMapping("/processSaving")
    public String processSaving(@Valid @ModelAttribute Employee employee, BindingResult bindingResult){

        System.out.println(employee.getUserName());
        System.out.println(employee.getFirstName() + ' ' + employee.getLastName());
        System.out.println(employee.getEmail());

        if(bindingResult.hasErrors())
            return "add_employee";

        employeeService.add(employee);
        return "successful_update";
    }
}
