package edu.uta.courses.service;


import edu.uta.courses.repository.domain.Blog;
import edu.uta.courses.repository.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Service?
 * Author Joni Laurila
 * Spring 2015 for Course www-programming
 */

public interface BlogService {

    @Transactional
    public void createPost(Blog post);

    @Transactional
    public  List<Blog> getAllPosts();

     @Transactional
     public void deleteUsersPosts(User user);

     @Transactional
     public void deletePost(Long id);

     @Transactional
     public Blog getPost(Long id);

     @Transactional
     public void editPost(Long id, String post);

    @Transactional
    public User getUser(Long id);

}