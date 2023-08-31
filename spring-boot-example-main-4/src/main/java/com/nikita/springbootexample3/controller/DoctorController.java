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
    public Optional<Doctor> getDoctorById(@PathVariable Integer did){
        return doctorService.getDoctorById(did);}

    @GetMapping("/getDoctorbyName/{name}")
    public Doctor getDoctorByName(@PathVariable String name){
        return doctorService.getDoctorByName(name);}


    @PutMapping("/editDoctor/{did}")
    public Doctor editDoctor(@PathVariable Integer did, @RequestBody DoctorDTO doctor){
        return doctorService.updateDoctor(did, doctor);
    }
    @PostMapping("/addD")
    public void addDoctor(@RequestBody Doctor doctor){
         doctorService.addDoctor(doctor);
    }
    @PostMapping("/upsertDoctor")
    public void upsertDoctor(@RequestBody DoctorDTO doctorDTO){
         doctorService.upsertDoctor(doctorDTO);
    }
    @GetMapping("getDoctorByIDnew/{did}")
    public Optional<Doctor> getDoctorByIdnew(@PathVariable Integer did){
        return doctorService.getDoctorByIdNew(did);
    }

    @DeleteMapping("/deleteDoctor/{did}")
    public void deleteDoctor(@PathVariable Integer did){
        doctorService.deleteDoctor(did);
    }
    @DeleteMapping("/deleteDoctorByName/{name}")
    public void deleteDoctorbyName(@PathVariable String name){
        doctorService.deleteDoctorbyName(name);
    }

}
