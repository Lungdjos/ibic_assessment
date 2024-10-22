package com.cbuibic.assess.service;

import com.cbuibic.assess.dto.UserDto;
import com.cbuibic.assess.model.User;
import com.cbuibic.assess.repostitory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    // the logic

    /**
     * creating a new user
     * @param userDto
     * @return
     */
    @Override
    public User creatNewUser(UserDto userDto) throws Exception {
        var user = new User();
        // validating the new user
        User user1 = userRepo.findUserByEmail(userDto.getEmail());
        if(user1 != null) {
            throw new Exception("This user already exists");
        } else  {

            // creating new user
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setPhone(userDto.getPhone());
            user.setEmpId(userDto.getEmpId());


            userRepo.save(user);
        }

        return user;
    }

    /**
     * delete user
     * @param id
     */
    @Override
    public void deleteUser(long id) throws Exception {
        // validating the user before delete
        User user1 = userRepo.findById(id)
                .orElseThrow();
        if(user1 == null){
            throw new Exception();
        } else{
            userRepo.delete(user1);
        }

    }

    /**
     * find user by id
     * @param id
     * @return
     */
    @Override
    public Optional<User> findUserById(Long id) {
        return userRepo.findById(id);
    }

    /**
     * returning all users
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    /**
     * method to update the user
     * @param userDto
     * @return
     */
    @Override
    public User updateUser(UserDto userDto) {
        return null;
    }
}
