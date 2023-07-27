package com.nikita.springbootexample3.controller;

import com.nikita.springbootexample3.entity.Report;
import com.nikita.springbootexample3.DTO.ReportDTO;
import com.nikita.springbootexample3.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReportController {
    @Autowired
    ReportService reportService;

    @GetMapping("/getReport")
    public List<Report> getAllReports(){
        return reportService.getAllReport();}



    @GetMapping("/getReport/{rid}")
    @Cacheable(value = "editReport" ,key = "#rid")
    public Optional<Report> getReportById(@PathVariable Integer rid){
        return reportService.getReportById(rid);}

    @PutMapping("/editReport/{rid}")
    @CachePut(value = "editReport",key = "#rid")
    public Report editReport(@PathVariable Integer rid , @RequestBody ReportDTO report){
        return reportService.updateReport(rid, report);
    }


    @PostMapping("/addR")
    public Report addReport(@RequestBody ReportDTO report){
        return reportService.addReport(report);
    }

    @DeleteMapping("/deleteReport/{rid}")
    @CacheEvict(value = "editReport",key = "#rid")
    public void deleteReport(@PathVariable Integer rid){
        reportService.deleteReport(rid);
    }

}
