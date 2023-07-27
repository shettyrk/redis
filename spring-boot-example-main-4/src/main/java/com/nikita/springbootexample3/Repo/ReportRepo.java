package com.nikita.springbootexample3.Repo;

import com.nikita.springbootexample3.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report,Integer> {


}
