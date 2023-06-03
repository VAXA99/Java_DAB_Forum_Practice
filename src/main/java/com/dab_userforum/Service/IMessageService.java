package com.dab_userforum.Service;

import com.dab_userforum.Entity.Message;
import com.dab_userforum.Entity.User;

import java.util.List;

public interface IMessageService {
    public List<Message> getAll();
    public Message findById(Integer id);
    public void add(Message message);
    public void update(Message message);
    public void delete(Integer id);}
