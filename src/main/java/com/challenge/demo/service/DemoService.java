package com.challenge.demo.service;

import com.challenge.demo.model.Repo;
import com.challenge.demo.model.UserData;
import com.challenge.demo.utility.Utility;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemoService {
    private final RestTemplate restTemplate;

    public DemoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getCombinedUserData(String username) throws IllegalAccessException {
        UserData user = getUserData(username);
        List<Repo> repos = getUserRepos(username);

        Map<String, Object> combinedData = new HashMap<>();
        combinedData.putAll(Utility.objectToHashMap(user));
        combinedData.put("repos", repos);

        return combinedData;
    }

    public UserData getUserData(String username) {
        String uri = "https://api.github.com/users/"+username;
        return restTemplate.getForObject(uri, UserData.class);
    }

    public List<Repo> getUserRepos(String username) {
        String uri = "https://api.github.com/users/"+username+"/repos";

        Repo[] repos = restTemplate.getForObject(uri, Repo[].class);
        return Arrays.asList(repos);
    }
}
