package com.dab_userforum.Repository;

import com.dab_userforum.Entity.Message;

import java.util.List;

public interface IMessageRepository {
    public List<Message> getAll();
    public Message findById(Integer id);
    public void add(Message message);
    public void update(Message message);
    public void delete(Integer id);

}
