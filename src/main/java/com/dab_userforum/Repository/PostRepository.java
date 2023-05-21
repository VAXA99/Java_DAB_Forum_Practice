package com.dab_userforum.Repository;

import com.dab_userforum.Entity.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.scheduling.annotation.Async;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostRepository implements IPostRepository {

    private List<Post> posts = new ArrayList<>();
    String FILE_PATH = "src/main/resources/XML/data.xml";


    public PostRepository() {
        loadData();
    }

    @Async
    public List<Post> getAll() {
        return posts;
    }

    @Async
    public Post findById(Integer id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }
        return null;
    }

    @Async
    public void add(Post post) {
        post.setId(posts.size());
        posts.add(post);
        saveData();
    }

    @Async
    public void update(Post post) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(post.getId())) {
                posts.set(i, post);
                saveData();
                return;
            }
        }
    }

    @Async
    public void delete(Integer id) {
        posts.removeIf(wagon -> wagon.getId().equals(id));
        saveData();
    }

    private void saveData() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(FILE_PATH), posts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            posts = xmlMapper.readValue(new File(FILE_PATH), new TypeReference<List<Post>>() {});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
