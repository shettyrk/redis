package com.nikita.springbootexample3.service;

import com.nikita.springbootexample3.Repo.DoctorRepo;
import com.nikita.springbootexample3.Repo.PatientRepo;
import com.nikita.springbootexample3.Repo.ReportRepo;
import com.nikita.springbootexample3.entity.Doctor;
import com.nikita.springbootexample3.entity.Patient;
import com.nikita.springbootexample3.entity.Report;
import com.nikita.springbootexample3.DTO.ReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    ReportRepo reportRepo;
    @Autowired
    PatientRepo patientRepo;
    @Autowired
    DoctorRepo doctorRepo;

    public List<Report> getAllReport() {
        return reportRepo.findAll();}

    public Report updateReport(Integer id, ReportDTO report) {
        Report existingReport = reportRepo.findById(id).orElse(null);
        if(existingReport == null){
            return null;
        }
        Doctor updatedDoctor = doctorRepo.findById(report.getDid()).orElse(null);
        Patient updatedPatient = patientRepo.findById(report.getPid()).orElse(null);
        existingReport.setTest(report.getTest());
        existingReport.setStatus(report.getStatus());
        existingReport.setDoctor(updatedDoctor);
        existingReport.setPatient(updatedPatient);
        System.out.println("Form Database");
        return reportRepo.save(existingReport);
    }
    public Report addReport(ReportDTO report) {
        try{
            Report newReport = new Report();
            Doctor addDoctor = doctorRepo.findById(report.getDid()).orElse(null);
            Patient addPatient = patientRepo.findById(report.getPid()).orElse(null);
            newReport.setId(report.getId());
            newReport.setTest(report.getStatus());
            newReport.setStatus(report.getStatus());
            newReport.setDoctor(addDoctor);
            newReport.setPatient(addPatient);
            System.out.println("Form Database");
            return reportRepo.save(newReport);
        }
        catch(Exception e){
            System.out.println("Failed");
        }

        return  null;
    }
    public void deleteReport(Integer id) {
        reportRepo.deleteById(id);
    }

    public Report addReports(Report report) {
        return reportRepo.save(report);

    }


    public Optional<Report> getReportById(Integer rid) {
        System.out.println("From Database");
        return reportRepo.findById(rid);
    }
}
