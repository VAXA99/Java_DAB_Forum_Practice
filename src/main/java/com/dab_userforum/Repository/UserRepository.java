package com.dab_userforum.Repository;

import com.dab_userforum.Entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private List<User> users = new ArrayList<>();
    String FILE_PATH = "src/main/resources/XML/admins.xml";


    public UserRepository() {
        loadData();
    }

    @Async
    public List<User> getAll() {
        return users;
    }

    @Async
    public User findById(Integer id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Async
    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getLogin().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Async
    public void add(User user) {
        user.setId(users.size());
        users.add(user);
        saveData();
    }

    @Async
    public void update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                saveData();
                return;
            }
        }
    }

    @Async
    public void delete(Integer id) {
        users.removeIf(wagon -> wagon.getId().equals(id));
        saveData();
    }

    private void saveData() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(FILE_PATH), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            users = xmlMapper.readValue(new File(FILE_PATH), new TypeReference<List<User>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

