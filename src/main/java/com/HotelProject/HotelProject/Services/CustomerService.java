package com.HotelProject.HotelProject.Services;

import com.HotelProject.HotelProject.Entity.CustomerEntity;
import com.HotelProject.HotelProject.Entity.RoomEntity;
import com.HotelProject.HotelProject.Repositories.CustomerRepository;
import com.HotelProject.HotelProject.Repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {

    private final  CustomerRepository repository;
    private  final RoomRepository roomRepository;
    public CustomerService(CustomerRepository repository, RoomRepository roomRepository) {
        this.repository = repository;
        this.roomRepository = roomRepository;
    }



    //insetion customer
    public CustomerEntity addCustomer(CustomerEntity customer) {
//        RoomEntity room = roomRepository.findByRoomNumber(roomNumber);
            return repository.save(customer);

    }


    //update
    public void updateCustomer(CustomerEntity customer){
        repository.save(customer);
    }

    //delete
    public void deleteCustomer(Long id){
        repository.deleteById(id);
    }

    //find customer by id
    public CustomerEntity getCustomerById(Long id){
        return  repository.findById(id).orElse(null);
    }

    //find all customer
    public List<CustomerEntity> getAllCustomer(Long id){
        if (id != null)
            return repository.search(id);
        return repository.findAll();
    }
}
