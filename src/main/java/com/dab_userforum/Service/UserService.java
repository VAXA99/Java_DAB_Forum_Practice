package com.dab_userforum.Service;


import com.dab_userforum.Entity.Message;
import com.dab_userforum.Entity.User;
import com.dab_userforum.Repository.IMessageRepository;
import com.dab_userforum.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IMessageRepository messageRepository;

    @Async
    public List<User> getAll(){
        return userRepository.getAll();
    }

    @Async
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    @Async
    public User findByUsername(String login) {
        return userRepository.findByUsername(login);
    }

    @Async
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Async
    public void add(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.add(user);
    }

    @Async
    public void update(User user) {
        userRepository.update(user);
    }

    @Async
    public void writeMessage(Message message, Integer userId) {
        User writingUser = userRepository.findById(userId);
        Integer currentMessageNumber = writingUser.getNumberOfMessages();
        writingUser.setNumberOfMessages(currentMessageNumber + 1);
        userRepository.update(writingUser);
        messageRepository.add(message);
    }

    @Async
    public void deleteMessage(Integer messageId, Integer userId) {
        User writingUser = userRepository.findById(userId);
        Integer currentMessageNumber = writingUser.getNumberOfMessages();
        writingUser.setNumberOfMessages(currentMessageNumber - 1);
        userRepository.update(writingUser);
        messageRepository.delete(messageId);
    }

}
