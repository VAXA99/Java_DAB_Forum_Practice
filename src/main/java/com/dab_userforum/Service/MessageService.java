package com.dab_userforum.Service;

import com.dab_userforum.Entity.Message;
import com.dab_userforum.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Async
    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    @Async
    public Message findById(Integer id) {
        return messageRepository.findById(id);
    }

    @Async
    public void add(Message message) {
        messageRepository.add(message);
    }

    @Async
    public void update(Message message) {
        messageRepository.update(message);
    }

    @Async
    public void delete(Integer id) {
        messageRepository.delete(id);
    }}
