package com.nikita.springbootexample3.Repo;

import com.nikita.springbootexample3.entity.Doctor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import javax.transaction.Transactional;
import java.util.Optional;

public interface DoctorRepo  {
    @Query(value = "Select * "+"from doctor D "+"where D.dname= ?",nativeQuery = true)
    void findDoctorByName(String name);
    @Query(value = "Delete * "+"form doctor D"+"where D.dname = ?",nativeQuery = true)
    void deleteByName(String name);

    @Query(value = "Select count(*) FROM doctor WHERE did = ?1",nativeQuery = true)
    int findAllById(Integer did);

    @Query(value = "Select * from doctor D where D.did= ?1",nativeQuery = true)
//    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
    @Cacheable(value = "doctorCacheRepo",key = "#did")
    Optional<Doctor> findDoctorById(Integer did);

    @Modifying
    @Transactional
    @CachePut(value = "customersCache", key = "#root.methodName")
    @Query(value = "INSERT INTO doctor(did, dname, specs) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void addDoctor(Integer did, String dname, String specs);

    @Modifying
    @Transactional
    @CachePut(value = "customersCache", key = "#root.methodName")
    @Query(value = "UPDATE doctor SET dname = ?2, specs = ?3 WHERE did = ?1", nativeQuery = true)
    void updateDoctor(Integer did, String dname, String specs);
@Query(value = "INSERT INTO user_action_log(id, email, type, action, created_timestamp, message,status) values (?1)")
    void save(Doctor doctor);
}
