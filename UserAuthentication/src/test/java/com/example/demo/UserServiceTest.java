package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.pojo.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    @Test
    void testUserExistsInDatabase() {
        // Given
        User user = new User();
        user.setUsername("naveen");
        user.setPassword("1000");

        // Mocking the behavior of UserRepo.existsByUsernameAndPassword
        when(userRepo.existsByUsernameAndPassword("naveen", "1000")).thenReturn(true);

        // When
        boolean userExists = userService.userExistsInDatabase(user);

        // Then
        assertTrue(userExists);

        // Verify that the existsByUsernameAndPassword method was called with the correct arguments
        verify(userRepo, times(1)).existsByUsernameAndPassword("naveen", "1000");
    }
}
