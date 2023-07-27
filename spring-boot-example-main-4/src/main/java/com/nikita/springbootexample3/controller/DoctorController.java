package com.nikita.springbootexample3.controller;

import com.nikita.springbootexample3.DTO.DoctorDTO;
import com.nikita.springbootexample3.Repo.DoctorRepo;
import com.nikita.springbootexample3.entity.Doctor;
import com.nikita.springbootexample3.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @GetMapping("/getDoctor")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctor();}
    @GetMapping("/getDoctor/{did}")
    @Cacheable(value = "editDoctor" ,key = "#did")
    public Optional<Doctor> getDoctorById(@PathVariable Integer did){
        return doctorService.getDoctorById(did);}

    @GetMapping("/getDoctorbyName/{name}")
    @Cacheable(value = "editDoctor" ,key = "#name")
    public Doctor getDoctorByName(@PathVariable String name){
        return doctorService.getDoctorByName(name);}


    @PutMapping("/editDoctor/{did}")
    @CachePut(value = "editDoctor",key = "#did")
    public Doctor editDoctor(@PathVariable Integer did, @RequestBody DoctorDTO doctor){
        return doctorService.updateDoctor(did, doctor);
    }
    @PostMapping("/addD")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("/deleteDoctor/{did}")
    @CacheEvict(value = "editDoctor" ,key = "#did")
    public void deleteDoctor(@PathVariable Integer did){
        doctorService.deleteDoctor(did);
    }
    @DeleteMapping("/deleteDoctorByName/{name}")
    @CacheEvict(value = "editDoctor" ,key = "#name")
    public void deleteDoctorbyName(@PathVariable String name){
        doctorService.deleteDoctorbyName(name);
    }

}
