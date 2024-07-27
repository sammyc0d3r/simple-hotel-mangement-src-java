package com.HotelProject.HotelProject.Services;

import com.HotelProject.HotelProject.Entity.EmployeeEntity;
import com.HotelProject.HotelProject.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    //insertion
    public void addEmployee(EmployeeEntity employee){
        repository.save(employee);
    }

    //update employee
    public void updateEmployee(EmployeeEntity  employee){
        repository.save(employee);
    }

    //delete employee
    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }

    //find employee by id
    public EmployeeEntity getEmployeeById(Long id){
        return repository.findById(id).orElse(null);
    }
    //find all employeee
    public List<EmployeeEntity > getAllEmployee(Long id){
        if (id != null)
            return repository.search(id);
        return repository.findAll();
    }
}
