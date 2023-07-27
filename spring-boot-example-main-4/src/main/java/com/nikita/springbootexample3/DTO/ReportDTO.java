package com.nikita.springbootexample3.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportDTO {
    private Integer id;
    private String test;
    private String status;
    private Integer pid;
    private Integer did;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getId() {
        return id;
    }

    public String getTest() {
        return test;
    }

    public String getStatus() {
        return status;
    }

    public Integer getPid() {
        return pid;
    }

    public Integer getDid() {
        return did;
    }
}
