package com.dab_userforum.Repository;

import com.dab_userforum.Entity.Post;

import java.util.List;

public interface IPostRepository {
    public List<Post> getAll();
    public Post findById(Integer id);
    public void add(Post post);
    public void update(Post post);
    public void delete(Integer id);
}
