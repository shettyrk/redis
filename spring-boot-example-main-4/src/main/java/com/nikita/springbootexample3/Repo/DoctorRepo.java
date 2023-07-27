package com.nikita.springbootexample3.Repo;

import com.nikita.springbootexample3.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
    @Query(value = "Select * "+"from doctor D "+"where D.dname= ?",nativeQuery = true)
    Doctor findDoctorByName(String name);
    @Query(value = "Delete * "+"form doctor D"+"where D.dname = ?",nativeQuery = true)
    void deleteByName(String name);
}
