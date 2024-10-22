package com.cbuibic.assess.service;

import com.cbuibic.assess.dto.UserDto;
import com.cbuibic.assess.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User creatNewUser(UserDto userDto) throws Exception;
    void deleteUser (long id) throws Exception;
    Optional<User> findUserById (Long id);
    List<User> getAllUsers();
    User updateUser(UserDto userDto);
}
