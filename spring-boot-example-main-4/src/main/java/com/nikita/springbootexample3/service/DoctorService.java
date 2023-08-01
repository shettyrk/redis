package com.nikita.springbootexample3.service;

import com.nikita.springbootexample3.DTO.DoctorDTO;
import com.nikita.springbootexample3.Repo.DoctorRepo;
import com.nikita.springbootexample3.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    public List<Doctor> getAllDoctor() {
        return doctorRepo.findAll();}

    public Optional<Doctor> getDoctorById(Integer id) {
        Doctor existingDoctor = doctorRepo.findById(id).orElse(null);
        if(existingDoctor != null)
        {
            return doctorRepo.findById(id);
        }
        return null;
    }

    public Doctor updateDoctor(Integer id , DoctorDTO temp) {
        Doctor existingDoctor = doctorRepo.findById(id).orElse(null);
        if (existingDoctor == null) {
            return null;
        }
        existingDoctor.setDname(temp.getDname());
        existingDoctor.setSpecs(temp.getSpecs());
        System.out.println("From Database");
        return doctorRepo.save(existingDoctor);
    }
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }
    public void deleteDoctor(Integer id) {
        doctorRepo.deleteById(id);
    }

    public Doctor getDoctorByName(String name) {
        System.out.println("Form Database");
        return doctorRepo.findDoctorByName(name);
    }

    public void deleteDoctorbyName(String name) {
        doctorRepo.deleteByName(name);}

    public void upsertDoctor(DoctorDTO doctorDTO) {
        if(doctorRepo.findAllById(doctorDTO.getDid()) == 0) {
            doctorRepo.addDoctor(doctorDTO.getDid(),doctorDTO.getDname(),doctorDTO.getSpecs());
        }
        else {
            doctorRepo.updateDoctor(doctorDTO.getDid(), doctorDTO.getDname(), doctorDTO.getSpecs());
        }
    }
}
