package com.HotelProject.HotelProject.Repositories;

import com.HotelProject.HotelProject.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    @Query(value = "Select * from employee where id = ?1" , nativeQuery = true)
    public List<EmployeeEntity> search(@Param("keyword") Long id);
}
