package edu.uta.courses.web;

import edu.uta.courses.repository.PersonRepository;
import edu.uta.courses.service.BlogService;
import edu.uta.courses.repository.domain.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by me on 21.2.2015.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    Logger logger = Logger.getLogger(AccountController.class.getName());

    @Autowired
    PersonRepository personRepository;

    @Autowired
    BlogService blogService;


    @RequestMapping( value = {"/", ""})
    public String account(Model model) {
        model.addAttribute("account", "");
        // can not do this anymore! User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails user = (UserDetails) auth.getPrincipal();
            name = user.getUsername();
        } else {
            // User is actually anonymous, so is not logged in.
            name = (String)auth.getPrincipal();
        }

        model.addAttribute("username", name);
        return "account";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String accountList(Model model) {
        model.addAttribute("users", personRepository.findUsers());
        return "/account/list";
    }

    @RequestMapping(value = {"/assignrole/{uid}/{role}"}, method = RequestMethod.GET)
    public String editPersonCommit(@PathVariable("uid") Long uid, @PathVariable("role") String role, Model model) {
        User u = personRepository.findById(uid);
        //WwwUser wwwUser = new WwwUser(u);
        u.setSecurityRoles(role);
        personRepository.update(u);
        model.addAttribute("updatedUser", u);
        model.addAttribute("users", personRepository.findUsers());
        return "/blog/manage";
    }

    @RequestMapping(value = "/deleteUser/{uid}")
    public String deleteUser(@PathVariable("uid") Long uid, Model model) {
            User u = personRepository.findById(uid);
            blogService.deleteUsersPosts(u);
            personRepository.delete(u);
            model.addAttribute("users", personRepository.findUsers());
            return "/blog/manage";
    }
}
