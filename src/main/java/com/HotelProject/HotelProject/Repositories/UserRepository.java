package com.HotelProject.HotelProject.Repositories;

import com.HotelProject.HotelProject.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity , Long> {
    @Query(value = "Select * from users where id = ?" , nativeQuery = true)
    public List<UserEntity> search(@Param("keyword") Long id);
}
