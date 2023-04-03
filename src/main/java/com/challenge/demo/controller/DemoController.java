package com.challenge.demo.controller;
import com.challenge.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    private DemoService service;

    @GetMapping("/user/repos")
    public Map<String, Object> getGitUser(@RequestParam(value = "username") String username) throws IllegalAccessException{
        return service.getCombinedUserData(username);
    }

}