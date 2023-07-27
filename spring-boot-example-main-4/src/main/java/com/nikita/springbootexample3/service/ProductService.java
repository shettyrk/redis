package com.nikita.springbootexample3.service;

import com.nikita.springbootexample3.Repo.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ReportRepo reportRepo;



//    public ReportDTO getReports(Integer id) {
//        return reportRepo.getReport(id);
//    }


//    public void getData(Integer id) {
//        List<Object> objects=reportRepo.findIncompleteReportData(id);
//        System.out.println(objects);
//    }
}
