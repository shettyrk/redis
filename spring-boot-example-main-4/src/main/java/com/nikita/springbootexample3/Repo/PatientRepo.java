package com.nikita.springbootexample3.Repo;

import com.nikita.springbootexample3.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Integer> {
}
