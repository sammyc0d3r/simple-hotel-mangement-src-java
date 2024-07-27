package com.HotelProject.HotelProject.Controllers;

import com.HotelProject.HotelProject.Entity.CustomerEntity;
import com.HotelProject.HotelProject.Services.CustomerService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    //all Requests

    //Go to the home page
    @GetMapping("/")
    public String getHomepage(){
        return "homeCustomer"; //home page name
    }



    //Go to the Add-Customer page
    @GetMapping("/AddCustomer")
    public String getAddCustomer(){
        return "Add-Customer"; // go to the registor page of the customer
    }

    //save the customer in the add-customer page
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute CustomerEntity customer){
            service.addCustomer(customer);
            return "redirect:/customer/CustomerList";

    }



    //display all customers in the customer list
    @GetMapping("/CustomerList")
    public String getAllCustomer(Model model , @Param("keyword")Long keyword){
        List<CustomerEntity> CustomerList = service.getAllCustomer(keyword);
        model.addAttribute("customers" , CustomerList);
        model.addAttribute("id" , keyword);
        return "Customer-List"; // display the customer List
    }

    //delete customer in the customer list
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){
        service.deleteCustomer(id);
        return "redirect:/customer/CustomerList"; //display customer list that deleted customer
    }

    //get  customer by id in the customer list
    @RequestMapping("/edit/{id}")
    public String getCustomerById(@PathVariable Long id , Model model){
        CustomerEntity customer = service.getCustomerById(id);
        model.addAttribute("customer" , customer);
        return "Edit-Customer"; // update page
    }
}
