package com.cbuibic.assess.service;

import com.cbuibic.assess.dto.UserDto;
import com.cbuibic.assess.model.User;
import com.cbuibic.assess.repostitory.UserRepo;
import org.hibernate.ObjectNotFoundException;
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
     * @param user
     */
    @Override
    public void deleteUser(User user) {
        // validating the user before delete
        Optional<User> user1 = userRepo.findById(user.getId());
        if(user1 == null){
            throw new ObjectNotFoundException(user, user.getEmail());
        } else{
            userRepo.delete(user);
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
}
