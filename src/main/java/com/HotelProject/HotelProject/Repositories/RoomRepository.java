package com.HotelProject.HotelProject.Repositories;

import com.HotelProject.HotelProject.Entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    RoomEntity findByRoomNumber(int roomNumber);
}
