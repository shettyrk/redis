package com.nikita.springbootexample3.Repo;

import com.nikita.springbootexample3.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
    @Query(value = "Select * "+"from doctor D "+"where D.dname= ?",nativeQuery = true)
    Doctor findDoctorByName(String name);
    @Query(value = "Delete * "+"form doctor D"+"where D.dname = ?",nativeQuery = true)
    void deleteByName(String name);

    @Query(value = "Select count(*) FROM doctor WHERE did = ?1",nativeQuery = true)
    int findAllById(Integer did);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO doctor(did,dname,specs) VALUES(1?,2?,3?)",nativeQuery = true)
    int addDoctor(Integer did, String dname, String specs);
    @Modifying
    @Transactional
    @Query(value = "UPDATE doctor SET dname = 2?,specs=3? WHERE did = 1?",nativeQuery = true)
    int updateDoctor(Integer did, String dname, String specs);
}
