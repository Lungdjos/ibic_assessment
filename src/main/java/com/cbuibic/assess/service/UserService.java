package com.cbuibic.assess.service;

import com.cbuibic.assess.dto.UserDto;
import com.cbuibic.assess.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    User creatNewUser(UserDto userDto);
    void deleteUser (User user);
    Optional<User> findUserById (Long id);
}
