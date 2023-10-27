package com.finalprojectbillingapp.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    private UserEntity userEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void testVerifyLogin() {
//given
        String loginEmail = "testuser@example.com";
        String password = "testpassword";

        UserEntity expectedUser = new UserEntity();
        Mockito.when(userRepository.findByLoginEmailAndPassword(loginEmail, password)).thenReturn(expectedUser);
//when
        var result = userService.verifyLogin(loginEmail, password);
//then
        assertNotNull(result);

        assertEquals(expectedUser, result);

    }

    @Test
    public void testGetAllListOfUsers() {
        //given
        userEntity = new UserEntity();
        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(userEntity);
       //when
        Mockito.when(userRepository.findAll()).thenReturn(userEntityList);
        List<UserEntity> result = userService.getAllUsers();
        //then
        assertNotNull(result);
        assertEquals(result.size(), 1);
    }
}