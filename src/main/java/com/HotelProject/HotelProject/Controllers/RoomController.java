package com.HotelProject.HotelProject.Controllers;

import com.HotelProject.HotelProject.Entity.RoomEntity;
import com.HotelProject.HotelProject.Services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    //display RoomHome
    @GetMapping("/")
    public String getRoom(){
        return "RoomHome";
    }

    //go to the Room registration page
    @GetMapping("/RoomReg")
    public String getRoomRegistration(){
        return "Room-Registor";
    }

    //store room in the list room
    @PostMapping("/add")
    public String storeRoom(@ModelAttribute RoomEntity room){
        service.addRoom(room);
        return "redirect:/room/RoomList";
    }


    //display list of room list
    @GetMapping("/RoomList")
    public String getRoomList(Model model){
        List<RoomEntity> roomList = service.getAllRooms();
        model.addAttribute("rooms" , roomList);
        return "Room-List";
    }


    //Delete Room
    @RequestMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id){
        service.deleteRoom(id);
        return "redirect:/room/RoomList";
    }

    @RequestMapping("/edit/{id}")
    public String getRoomById_Update(@PathVariable Long id , Model model){
        RoomEntity room = service.getRoomById(id);
        model.addAttribute("room" , room);
        return "Edit-Room";
    }


}
