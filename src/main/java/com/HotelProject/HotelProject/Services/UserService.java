package com.HotelProject.HotelProject.Services;

import com.HotelProject.HotelProject.Entity.EmployeeEntity;
import com.HotelProject.HotelProject.Entity.UserEntity;
import com.HotelProject.HotelProject.Repositories.EmployeeRepository;
import com.HotelProject.HotelProject.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    public UserService(UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }





    //insetion user

    public void addUser(UserEntity user){
        userRepository.save(user);
    }

    //delete user
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    //get all Users
    public List<UserEntity> getAllUsers(Long id){
        if (id != null)
            return userRepository.search(id);
        return userRepository.findAll();
    }

    //get user by id
    public UserEntity getUserById(Long id){ return userRepository.findById(id).orElse(null);
    }
}
