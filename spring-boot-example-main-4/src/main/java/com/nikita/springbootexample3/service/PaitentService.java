package com.nikita.springbootexample3.service;

import com.nikita.springbootexample3.Repo.PatientRepo;
import com.nikita.springbootexample3.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaitentService {
    @Autowired
    private PatientRepo patientRepo;

    public List<Patient> getAllPatient() {
        return patientRepo.findAll();
    }
    public Patient updatePatient(Integer id, Patient patient) {
        Patient existingPatient = patientRepo.findById(id).orElse(null);
        if(existingPatient == null){
            return null;
        }
        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        System.out.println("From Database");
        return patientRepo.save(existingPatient);
    }
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }
    public void deletePatient(Integer id) {
        patientRepo.deleteById(id);
    }
    public Optional<Patient> getPatientById(Integer pid) {
        System.out.println("From Database");
        return patientRepo.findById(pid);
    }
}
