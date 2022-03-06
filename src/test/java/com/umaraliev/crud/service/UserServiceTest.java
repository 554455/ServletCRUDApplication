package com.umaraliev.crud.service;

import com.umaraliev.crud.model.User;
import com.umaraliev.crud.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserRepository userRepository = mock(UserRepository.class);
    private User oneUser;
    private User twoUser;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getById() {
        List<User> userList = new ArrayList<>();
        userList.add(oneUser);
        userList.add(twoUser);

        when(userService.getAll()).thenReturn(userList);
        when(userService.getById(1)).thenReturn(oneUser);
    }

    @Test
    public void getAll() {
        List<User> userList = new ArrayList<>();

        userList.add(oneUser);
        userList.add(twoUser);

        when(userService.getAll()).thenReturn(userList);
        assertNotNull(userList);
    }

    @Test
    public void save() {
        oneUser = new User();
        oneUser.setId(1);
        oneUser.setName("Admin");

        when(userService.save(any(User.class))).thenReturn(oneUser);

        twoUser = new User();
        twoUser.setId(2);
        twoUser.setName("Sub Admin");

        User user = userService.save(twoUser);
        assertNotNull(twoUser);
        assertEquals("Admin", user.getName());
    }

    @Test
    public void update() {
        oneUser = new User();
        oneUser.setId(1);
        oneUser.setName("Admin");

        when(userService.update(oneUser)).thenReturn(oneUser);
        assertEquals("Admin", oneUser.getName());
    }

    @Test
    public void delete() {
        userService.delete(anyInt());

        verify(userService).delete(anyInt());
    }

}