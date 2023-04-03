package com.challenge.demo.unit;

import com.challenge.demo.model.Repo;
import com.challenge.demo.model.UserData;
import com.challenge.demo.repository.DemoExternalRepo;
import com.challenge.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ServiceTests {

    @Mock
    private DemoExternalRepo repository;

    @InjectMocks
    private DemoService service;
    @Test
    public void testGetCombinedUserData() throws IllegalAccessException{
        // Given
        UserData mockUser = new UserData("Bob", "", "", "San Francisco", "Bob@demo.edu", "mock.com", new Date());
        when(repository.getUserData("Bob")).thenReturn(mockUser);

        List<Repo> mockRepos = Arrays.asList(new Repo("Foo Bar", "FooBarTheUrl.com"));
        when(repository.getUserRepos("Bob")).thenReturn(mockRepos);

        Map<String, Object> expected = getExpectedObject(mockUser, mockRepos);

        // When
        Map<String, Object> result = service.getCombinedUserData("Bob");

        // Then
        assertEquals(expected, result);
    }

    public Map<String, Object> getExpectedObject(UserData user, List<Repo> repos){
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", user.getUser_name());
        map.put("display_name", user.getDisplay_name());
        map.put("avatar", user.getAvatar());
        map.put("geo_location", user.getGeo_location());
        map.put("email", user.getEmail());
        map.put("url", user.getUrl());
        map.put("created_at", user.getCreated_at());
        map.put("repos", repos);

        return map;
    }
}
