package com.nikita.springbootexample3.service;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.uuid.Generators;
import com.nikita.springbootexample3.DTO.UserActionLogDTO;
import com.nikita.springbootexample3.Repo.UserActionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserActionLogService {

    @Autowired
    UserActionLogRepository userActionLogRepository;

    public void addUserAction(String email, String type, String action, String message, String status) {
        String id = Generators.timeBasedGenerator().generate().toString();
        BigInteger createdTimestamp = BigInteger.valueOf(System.currentTimeMillis());

        if (email == null || email.equals("null") || email.equals("")) {
            email = "admin";
        }
        userActionLogRepository.addUserAction(id, email, type, action, createdTimestamp, message, status);
        System.out.println("added");
    }

    public List<UserActionLogDTO> getUserActionLogs() {
//
//        String email = filterObject.getString("email");
//        String type = filterObject.getString("type");
//        String action = filterObject.getString("action");
//        BigInteger start_date = filterObject.getBigInteger("start_date");
//        BigInteger end_date = filterObject.getBigInteger("end_date");
//        String status = filterObject.getString("status");
//        Integer offset = pagesize * (pageno - 1);
//        String message = "all";
//
//        if(type.equals("Device")){
//            if(action.equals("ADD")) {
//                message = "is added";
//            }else if(action.equals("UPDATE")){
//                message = "is updated for network";
//            }else if(action.equals("DELETE")){
//                message = "is deleted";
//            }
//        }
//
//        if(type.equals("Geolocation")) {
//            if(action.equals("UPDATE")){
//                type =  "Device";
//                message = "Position details";
//            }
//        }
//
//        List<UserActionLogDTO> userActionLogDTOS = userActionLogRepository.getUserActionLogs(email, type, action, start_date, end_date, status, pagesize, offset, searchkey, message);
       List<UserActionLogDTO>  userActionLogDTOS = userActionLogRepository.findAll();
        return userActionLogDTOS;
    }

    public void deleteUserActionLogRecords() {

        Integer keepRecords = 25000;
        Integer limit = 25000;

        Integer newCount;

        Integer count = userActionLogRepository.getTotalUserActionLogRecords();

        while (count > keepRecords) {

            newCount = count - limit;

            if (newCount < keepRecords) {
                limit = count - keepRecords;
            }
            count = newCount;
            userActionLogRepository.deleteUserActionLogRecords(limit);
        }
    }

    public Map<String, Integer> getUserActionLogsCount(String username, String vdmsid, JSONObject filterObject, String searchkey) {
        String email = filterObject.getString("email");
        String type = filterObject.getString("type");
        String action = filterObject.getString("action");
        BigInteger start_date = filterObject.getBigInteger("start_date");
        BigInteger end_date = filterObject.getBigInteger("end_date");
        String status = filterObject.getString("status");
        String message = "all";

        if(type.equals("Device")){
            if(action.equals("ADD")) {
                message = "is added";
            }else if(action.equals("UPDATE")){
                message = "is updated for network";
            }else if(action.equals("DELETE")){
                message = "is deleted";
            }
        }

        if(type.equals("Geolocation")) {
            if(action.equals("UPDATE")){
                type =  "Device";
                message = "Position details";
            }
        }

        Map<String,Integer> logsCount = new HashMap<>();
        Integer userActionLogsCount = userActionLogRepository.getUserActionLogsCount(email, type, action, start_date, end_date, status, searchkey, message);

        if(filterObject.getString("type") != null) {
            logsCount.put(filterObject.getString("type").toLowerCase() + "_count", userActionLogsCount);
        }
        return logsCount;
    }
}

