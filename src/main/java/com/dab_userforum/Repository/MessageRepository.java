package com.dab_userforum.Repository;

import com.dab_userforum.Entity.Message;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository implements IMessageRepository {
    private List<Message> messages = new ArrayList<>();
    private final String FILE_PATH = "src/main/resources/JSON/messages.json";

    public MessageRepository() {
        loadData();
    }

    @Async
    public List<Message> getAll() {
        return messages;
    }

    @Async
    public Message findById(Integer id) {
        for (Message message : messages) {
            if (message.getId().equals(id)) {
                return message;
            }
        }
        return null;
    }

    @Async
    public void add(Message message) {
        message.setId(messages.size());
        messages.add(message);
        saveData();
    }

    @Async
    public void update(Message message) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getId().equals(message.getId())) {
                messages.set(i, message);
                saveData();
                return;
            }
        }
    }

    @Async
    public void delete(Integer id) {
        messages.removeIf(message -> message.getId().equals(id));
        saveData();
    }

    private void saveData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(FILE_PATH), messages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            messages = objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<Message>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
