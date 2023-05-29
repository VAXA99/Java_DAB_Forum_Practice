package com.dab_userforum.Repository;

import com.dab_userforum.Entity.User;

import java.util.List;

public interface IUserRepository {
    public List<User> getAll();
    public User findById(Integer id);

    public User findByUsername(String login);
    public void add(User user);
    public void update(User user);
    public void delete(Integer id);
}
