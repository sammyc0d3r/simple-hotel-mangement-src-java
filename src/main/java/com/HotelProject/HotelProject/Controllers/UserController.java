package com.HotelProject.HotelProject.Controllers;

import com.HotelProject.HotelProject.Entity.UserEntity;
import com.HotelProject.HotelProject.Services.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    //display home page user
    @GetMapping("/")
    public String getUserHome(){
        return "UserHome";
    }

    //display user-registration page
    @GetMapping("/userReg")
    public String getUserRegistration(){
        return "User-Registration";
    }

    //save user information
    @PostMapping("/registration")
    public String createUser(@ModelAttribute UserEntity user){
            service.addUser(user);
            return "redirect:/user/UserList";
    }


    //display user List
    @GetMapping("/UserList")
    public String getAllUsers(Model model , @Param("id") Long id){
        List<UserEntity> userList = service.getAllUsers(id);
        model.addAttribute("id" , id);
        model.addAttribute("users" , userList);
        return "User-List";
    }

    //Delete user
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        service.deleteUser(id);
        return "redirect:/user/UserList";
    }

    //Update User
    @RequestMapping("/edit/{id}")
    public String getUserById(@PathVariable Long id , Model model){
        UserEntity user = service.getUserById(id);
        model.addAttribute("user" , user);
        return "Edit-User";

    }


}
