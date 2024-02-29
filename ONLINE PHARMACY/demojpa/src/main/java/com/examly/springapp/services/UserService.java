package com.examly.springapp.services;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;



@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean post(User user)
    {
        try{
            userRepo.save(user);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
}
