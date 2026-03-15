package com.fightbooking.service;

import com.fightbooking.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService instance = new UserService(); // ⭐ instance เดียว

    private List<User> users = new ArrayList<>();

    // ⭐ constructor private เพื่อไม่ให้ new เอง
    private UserService(){}

    // ⭐ method สำหรับเรียก instance
    public static UserService getInstance(){
        return instance;
    }

    public boolean register(User user) {

        for(User u : users){
            if(u.getEmail().equals(user.getEmail())){
                return false;
            }
        }

        users.add(user);
        return true;
    }

    public User login(String email, String password){

        for(User u : users){

            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                return u;
            }

        }

        return null;
    }

    public List<User> getUsers(){
        return users;
    }
}