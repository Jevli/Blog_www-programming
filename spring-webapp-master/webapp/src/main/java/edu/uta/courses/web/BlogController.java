package edu.uta.courses.web;

import java.util.Date;

import edu.uta.courses.repository.PersonRepository;
import edu.uta.courses.repository.domain.Blog;
import edu.uta.courses.repository.domain.WwwUser;

import org.apache.log4j.Logger;

import edu.uta.courses.service.BlogService;
import edu.uta.courses.util.UserUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    Logger log = Logger.getLogger(BlogController.class.getName());

    @RequestMapping(value = {"/", "", "index"})
    public String index(Model model) {
        model = basic(model);
        return "/blog/index";
    }

    private Model basic(Model model) {
         model.addAttribute("posts", blogService.getAllPosts());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            model.addAttribute("logedin", true);
            WwwUser u = UserUtil.getWwwUser();
            model.addAttribute("user", personRepository.findById(u.getId()));
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
    public String addPost(SessionStatus sessionStatus,
    		@RequestParam("title") Date title,
    		@RequestParam("post") String newPost,
    		@RequestParam("fileName") String file,
    		Model model) {
    	
        Blog post = new Blog();
        post.setPost(newPost);
        post.setTitle(title);
        post.setFileName(file);

        WwwUser u = UserUtil.getWwwUser();
        
        if (u != null)
            post.setUser(personRepository.findById(u.getId()));
            

        blogService.createPost(post);
        sessionStatus.setComplete();
        model = basic(model);
        return "/blog/index";
    }

    @RequestMapping(value= "/manage")
    public String manage(Model model) {
        model = basic(model);
        model.addAttribute("users", personRepository.findUsers());
        return "/blog/manage";
    }

    @RequestMapping(value="/editAccount/{uid}")
    public String editAccount(@PathVariable("uid") Long uid, Model model) {
        WwwUser u = UserUtil.getWwwUser();
        String uname = personRepository.findById(uid).getUserName();

        if(u.isSuperuser() || u.getUsername().equals(uname)) {
            model = basic(model);
            model.addAttribute("editUser", personRepository.findById(uid));
            return "/blog/editAccount";
        }
        else {
            model.addAttribute("what", "edit accout");
            return "/blog/notRights";
        }
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
                model.addAttribute("what", "delete post");
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
                model.addAttribute("what", "edit post");
                return "/blog/notRights";
            }
    }

    @RequestMapping(value = "/postEdit/{pid}", method = RequestMethod.POST)
    public String postEdit(SessionStatus sessionStatus,
    		@RequestParam("title") Date title,
    		@RequestParam("post") String post,
    		@RequestParam("fileName") String file,
    		@PathVariable("pid") Long pid,
    		Model model) {
    	Blog oldPost = blogService.getPost(pid);
    	oldPost.setTitle(title);
    	oldPost.setPost(post);
    	oldPost.setFileName(file);
        blogService.editPost(oldPost);
        model = basic(model);
        return "/blog/index";
    }

}