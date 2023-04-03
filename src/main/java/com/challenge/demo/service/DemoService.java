package com.challenge.demo.service;

import com.challenge.demo.model.Repo;
import com.challenge.demo.model.UserData;
import com.challenge.demo.repository.DemoExternalRepo;
import com.challenge.demo.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemoService {

    @Autowired
    private DemoExternalRepo repository;

    public Map<String, Object> getCombinedUserData(String username) throws IllegalAccessException {
        UserData user = repository.getUserData(username);
        List<Repo> repos = repository.getUserRepos(username);

        Map<String, Object> combinedData = new HashMap<>();
        combinedData.putAll(Utility.objectToHashMap(user));
        combinedData.put("repos", repos);

        return combinedData;
    }


}
