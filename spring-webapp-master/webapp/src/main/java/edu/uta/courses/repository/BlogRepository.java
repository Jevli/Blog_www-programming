package edu.uta.courses.repository;

import edu.uta.courses.repository.domain.Blog;
import edu.uta.courses.repository.domain.User;

import java.util.List;

/**
 * Blog database methods
 * Author Joni Laurila
 * Spring 2015 for Course www-programming
 */

public interface BlogRepository {
    public void update(Blog post);

    public void create(Blog post);

    public void delete(Blog post);

    public void delete(Long id);

    public Blog findById(Long id);

    public List<Blog> findBlogs();

    public List<Blog> getAllPosts(User us);
    
}