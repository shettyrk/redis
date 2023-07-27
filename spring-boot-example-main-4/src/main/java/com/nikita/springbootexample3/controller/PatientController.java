package com.nikita.springbootexample3.controller;

import com.nikita.springbootexample3.entity.Patient;
import com.nikita.springbootexample3.service.PaitentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    PaitentService paitentService;

    @GetMapping("/getPatient")
    public List<Patient> getAllPatients(){
        return paitentService.getAllPatient();}
    @GetMapping("/getPatient/{pid}")
    @Cacheable(value = "editPatient" ,key = "#pid")
    public Optional<Patient> getPatientById(@PathVariable Integer pid){
        return paitentService.getPatientById(pid);}
    @CachePut(value = "editPatient",key = "#pid")
    @PutMapping("/editPatient/{pid}")
    public Patient editPatient(@PathVariable Integer pid, @RequestBody Patient patient){
        return paitentService.updatePatient(pid, patient);
    }
    @PostMapping("/addP")
    public Patient addPatient(@RequestBody Patient patient){
        return paitentService.addPatient(patient);
    }

    @DeleteMapping("/deletePatient/{pid}")
    @CacheEvict(value = "editPatient",key = "#pid")
    public void deletePatient(@PathVariable Integer pid){
        paitentService.deletePatient(pid);
    }

}
