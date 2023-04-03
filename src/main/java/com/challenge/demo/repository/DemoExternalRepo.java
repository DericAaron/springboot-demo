package com.challenge.demo.repository;

import com.challenge.demo.model.Repo;
import com.challenge.demo.model.UserData;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class DemoExternalRepo {

    private final RestTemplate restTemplate;

    public DemoExternalRepo(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
