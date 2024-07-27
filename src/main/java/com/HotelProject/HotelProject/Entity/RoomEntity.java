package com.HotelProject.HotelProject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "room_number", nullable = false, unique = true)
    private int roomNumber;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private boolean isAvailable;


}
