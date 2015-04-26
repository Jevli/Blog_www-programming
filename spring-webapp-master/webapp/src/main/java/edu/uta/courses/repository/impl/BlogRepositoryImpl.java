package edu.uta.courses.repository.impl;

import edu.uta.courses.repository.BlogRepository;
import edu.uta.courses.repository.domain.Blog;
import edu.uta.courses.repository.domain.User;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Blog database method implementions
 * Author Joni Laurila
 * Spring 2015 for Course www-programming
 */

@Repository("blogRepository")
public class BlogRepositoryImpl implements BlogRepository {

    Logger log = Logger.getLogger(BlogRepositoryImpl.class.getName());

    @PersistenceContext(name = "entityManager")
    EntityManager em;

    @Override
    public void create(Blog post) {
        post.setCreatedOn(new DateTime());
        em.persist(post);
        if (log.isDebugEnabled()) log.debug("Persisted post");
    }

    @Override
    public void update(Blog post) {
        post.setModifiedOn(new DateTime());
        em.merge(post);
        if (log.isDebugEnabled()) log.debug("Merged post");
    }

    @Override
    public void delete(Blog post) {
        if (log.isDebugEnabled()) log.debug("Remove post ("+ post.getId() +")");
        Blog post2 = findById(post.getId());
        em.remove(post2);
        post.setId(null);
    }

    @Override
    public void delete(Long id) {
        if (log.isDebugEnabled()) log.debug("Remove post ("+ id+")");
        Blog post2 = findById(id);
        em.remove(post2);
    }

    @Override
    public Blog findById(Long id) {
        if (log.isDebugEnabled()) log.debug("Find By Id: " + id);
        return em.find(Blog.class, id);
    }

    @Override
    public List<Blog> findBlogs() {
        if (log.isDebugEnabled()) log.debug("findBlogs()");
        return em.createQuery("SELECT u FROM Blog u  ORDER BY id DESC", Blog.class)
                .getResultList();
    }

    @Override
    public List<Blog> getAllPosts(User us) {
        if(log.isDebugEnabled()) log.debug("getAllPosts()");
        return em.createQuery("SELECT u FROM Blog u WHERE u.user LIKE :us", Blog.class).setParameter("us", us).getResultList();
    }
}