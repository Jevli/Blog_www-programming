package edu.uta.courses.service.impl;

import edu.uta.courses.repository.BlogRepository;
import edu.uta.courses.repository.domain.Blog;
import edu.uta.courses.service.BlogService;
import edu.uta.courses.repository.domain.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Service?
 * Author Joni Laurila
 * Spring 2015 for Course www-programming
 */

@Service("blogService")
public class BlogServiceImpl implements BlogService {

    Logger log = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    BlogRepository blogRepository;


    @Override
    public void createPost(Blog post) {
        blogRepository.create(post);
    }

    @Override
    public List<Blog> getAllPosts() {
        try {
            return blogRepository.findBlogs();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Blog>();
        }
    }

    @Override
    public void deleteUsersPosts(User user) {
        List<Blog> userPosts = blogRepository.getAllPosts(user);
        while(userPosts.size() > 0) {
            blogRepository.delete(userPosts.remove(0));
        }
    }

    @Override
    public void deletePost(Long id) {
        blogRepository.delete(id);
    }

    @Override
    public User getUser(Long id) {
        Blog post = blogRepository.findById(id);
        return post.getUser();
    }

    @Override
    public void editPost(Long id, String post) {
        Blog post2 = blogRepository.findById(id);
        post2.setPost(post);
        blogRepository.update(post2);
    }

    @Override
    public Blog getPost(Long id) {
        return blogRepository.findById(id);
    }

}