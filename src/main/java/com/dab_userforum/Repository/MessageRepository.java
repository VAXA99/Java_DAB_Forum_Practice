package com.dab_userforum.Repository;

import com.dab_userforum.Entity.Message;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.scheduling.annotation.Async;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageRepository implements IMessageRepository {
    private List<Message> messages = new ArrayList<>();
    String FILE_PATH = "src/main/resources/XML/data.xml";


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
        messages.removeIf(wagon -> wagon.getId().equals(id));
        saveData();
    }

    private void saveData() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(FILE_PATH), messages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            messages = xmlMapper.readValue(new File(FILE_PATH), new TypeReference<List<Message>>() {});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
