package com.nikita.springbootexample3.controller;


import com.alibaba.fastjson.JSONObject;

import com.nikita.springbootexample3.DTO.UserActionLogDTO;
import com.nikita.springbootexample3.service.UserActionLogService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserActionLogController {

    @Autowired
    UserActionLogService userActionLogService;

    // Get User Action Logs

    @RequestMapping(method = RequestMethod.POST, value = "/user/{username}/vdms/{vdmsid}/getuseractionlogs")
    public List<UserActionLogDTO> getUserActionLogs(@PathVariable String username, @PathVariable String vdmsid,
                                                    @RequestParam(defaultValue = "1") Integer pageno,
                                                    @RequestParam(defaultValue = "10") Integer pagesize,
                                                    @RequestParam(defaultValue = "null") String searchkey,
                                                    @RequestBody JSONObject filterObject){
        return userActionLogService.getUserActionLogs(username, vdmsid, filterObject, pageno, pagesize, searchkey);
    }

    // Get User Action Logs Count
    @RequestMapping(method = RequestMethod.POST, value = "/user/{username}/vdms/{vdmsid}/getuseractionlogscount")
    public Map<String,Integer> getUserActionLogsCount(@PathVariable String username, @PathVariable String vdmsid,
                                                      @RequestParam(defaultValue = "null") String searchkey,
                                                      @RequestBody JSONObject filterObject){
        return userActionLogService.getUserActionLogsCount(username, vdmsid, filterObject,searchkey);
    }
    @RequestMapping(method = RequestMethod.GET, value = "export")
    public ResponseEntity<Resource> exportCustomer(){
        List<UserActionLogDTO> userActionLogDTOList = userActionLogService.getUserActionLogs();
    }
}

