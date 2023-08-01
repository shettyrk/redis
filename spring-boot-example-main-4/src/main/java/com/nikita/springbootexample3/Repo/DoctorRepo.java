package com.nikita.springbootexample3.Repo;

import com.nikita.springbootexample3.entity.Doctor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import javax.transaction.Transactional;
import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
    @Query(value = "Select * "+"from doctor D "+"where D.dname= ?",nativeQuery = true)
    Doctor findDoctorByName(String name);
    @Query(value = "Delete * "+"form doctor D"+"where D.dname = ?",nativeQuery = true)
    void deleteByName(String name);

    @Query(value = "Select count(*) FROM doctor WHERE did = ?1",nativeQuery = true)
    int findAllById(Integer did);

    @Query(value = "Select * "+"from doctor D "+"where D.did= ?1",nativeQuery = true)
    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
    @Cacheable(value = "doctorCacheRepo",key = "#did")
    Optional<Doctor> findDoctorById(Integer did);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO doctor(did, dname, specs) VALUES (?1, ?2, ?3)", nativeQuery = true)
    int addDoctor(Integer did, String dname, String specs);

    @Modifying
    @Transactional
    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
    @Cacheable(value = "doctorCacheRepo",key = "#did")
    @Query(value = "UPDATE doctor SET dname = ?2, specs = ?3 WHERE did = ?1", nativeQuery = true)
    int updateDoctor(Integer did, String dname, String specs);

}
