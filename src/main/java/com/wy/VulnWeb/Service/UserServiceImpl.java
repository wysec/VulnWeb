package com.wy.VulnWeb.Service;

import com.wy.VulnWeb.Model.User;
import com.wy.VulnWeb.Repository.UserRepository;
import com.wy.VulnWeb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> findByName(String name) {
        return (List<User>) userRepository.findByName(name);
    }
/*
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
    */
}


