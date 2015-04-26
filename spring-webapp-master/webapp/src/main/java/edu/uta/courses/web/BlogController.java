package edu.uta.courses.web;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.uta.courses.repository.PersonRepository;
import edu.uta.courses.repository.domain.Blog;
import edu.uta.courses.repository.domain.WwwUser;
import edu.uta.courses.service.BlogService;
import edu.uta.courses.util.UserUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import edu.uta.courses.repository.domain.Constants;
import edu.uta.courses.repository.domain.User;
import edu.uta.courses.util.UserUtil;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Blog?
 * Author Joni Laurila
 * Spring 2015 for Course www-programming
 */

@Controller
@RequestMapping("/blog")

public class BlogController {
    
    @Autowired
    BlogService blogService;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model = basic(model);
        return "/blog/index";
    }

    private Model basic(Model model) {
         model.addAttribute("posts", blogService.getAllPosts());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            model.addAttribute("logedin", true);
        } else {
            model.addAttribute("logedin", false);
        }
        model.addAttribute("user", UserUtil.getWwwUser());
        if(UserUtil.getWwwUser() != null && UserUtil.getWwwUser().isSuperuser()) {
            model.addAttribute("admin", true);
        } else {
            model.addAttribute("admin", false);
        }
        return model;
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String post() {
        return "/blog/post";
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public String addPost(SessionStatus sessionStatus, @RequestParam("post") String newPost, Model model) {
        Blog post = new Blog();
        post.setPost(newPost);

        // getUser
        WwwUser u = UserUtil.getWwwUser();
        try {
            if (u != null) {
                post.setUser(personRepository.findById(u.getId()));
            }
        } catch (Exception e) {
            // should not be able to later on
        }

        blogService.createPost(post);
        sessionStatus.setComplete();
        model = basic(model);
        return "/blog/index";
    }

    @RequestMapping(value= "/manage")
    public String manage(Model model) {
        model.addAttribute("users", personRepository.findUsers());
        return "/blog/manage";
    }

    @RequestMapping(value = "/deletePost/{pid}")
    public String deletePost(@PathVariable("pid") Long pid, Model model) {
            WwwUser u = UserUtil.getWwwUser();

            String uname = blogService.getUser(pid).getUserName();
            
            if(u.isSuperuser() || u.getUsername().equals(uname)) {
                blogService.deletePost(pid);
                model = basic(model);
                return "/blog/index";
            } else {
                model.addAttribute("what", "delete");
                return "/blog/notRights";
            }
    }

    @RequestMapping(value = "/editPost/{pid}", method = RequestMethod.GET)
    public String editPost(@PathVariable("pid") Long pid, Model model) {
            WwwUser u = UserUtil.getWwwUser();
            
            String uname = blogService.getUser(pid).getUserName();
            
            if(u.isSuperuser() || u.getUsername().equals(uname)) {
                Blog post = blogService.getPost(pid);
                model.addAttribute("post", post);
                return "/blog/edit";
            } else {
                model.addAttribute("what", "edit");
                return "/blog/notRights";
            }
    }

    @RequestMapping(value = "/postEdit/{pid}", method = RequestMethod.POST)
    public String postEdit(SessionStatus sessionStatus, @RequestParam("post") String post, @PathVariable("pid") Long pid, Model model) {
        blogService.editPost(pid, post);
        model = basic(model);
        return "/blog/index";
    }
}