package com.HotelProject.HotelProject.Services;

import com.HotelProject.HotelProject.Entity.RoomEntity;
import com.HotelProject.HotelProject.Repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomService {
    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    //insertion
    public void addRoom(RoomEntity room){
        repository.save(room);
    }

    //update room
    public void  updateRoom(RoomEntity room){
        repository.save(room);
    }

    //delete room
    public void deleteRoom(Long id){
        repository.deleteById(id);
    }

    //find all rooms
    public List<RoomEntity> getAllRooms(){
        return repository.findAll();
    }

    //find by id
    public RoomEntity getRoomById(Long id){
        return repository.findById(id).orElse(null);
    }


}
