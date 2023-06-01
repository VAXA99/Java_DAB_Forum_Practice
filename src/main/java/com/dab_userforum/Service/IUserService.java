package com.dab_userforum.Service;

import com.dab_userforum.Entity.Message;
import com.dab_userforum.Entity.User;

import java.util.List;

public interface IUserService {

    public List<User> getAll();
    public User findById(Integer id);
    public void add(User user);
    public void update(User user);
    public void delete(Integer id);
    public void writeMessage(Message message,Integer userId);
    public void deleteMessage(Integer messageId, Integer userId);
    public void updateMessage(Message message);
}
