package com.wy.VulnWeb.Service;

import com.wy.VulnWeb.Model.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public List<User> findByName(String name);
/*
    public void save(User user);

    public void edit(User user);

    public void delete(long id);
*/

}
