package com.HotelProject.HotelProject.Controllers;

import com.HotelProject.HotelProject.Entity.EmployeeEntity;
import com.HotelProject.HotelProject.Services.EmployeeService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //display the home page
    @GetMapping("/")
    public String getHomePage(){

        return "EmpHome"; //display home page viewer
    }


    //display employee register page
    @GetMapping("/EmpRegister")
    public String getSaveEmployee(){
        return "Save-Employee";
    }

    @PostMapping("/Register")
    public String saveEmployee(@ModelAttribute EmployeeEntity employee){
        service.addEmployee(employee);
        return "redirect:/employee/employeeList";
    }


    //display all the employee in the employee list
    @GetMapping("/employeeList")
    public String getAllEmployee(Model model , @Param("id") Long id){
        List<EmployeeEntity> employeeList = service.getAllEmployee(id);
        model.addAttribute("employee" , employeeList);
        model.addAttribute("id" , id);
        return "Employee-List";

    }



    //delete employe in the employee list
    @GetMapping("/remove/{id}")
    public String deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return "redirect:/employee/employeeList";
    }

    //update the employee
    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id , Model model){
        EmployeeEntity employee = service.getEmployeeById(id);
        model.addAttribute("employee" , employee);
        return "Edit-Employee";
    }




}
