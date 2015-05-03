package edu.uta.courses.web;

import edu.uta.courses.repository.PersonRepository;
import edu.uta.courses.repository.domain.Constants;
import edu.uta.courses.repository.domain.User;
import edu.uta.courses.repository.domain.WwwUser;
import edu.uta.courses.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by me on 10.2.2015.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editPersonOpen(@ModelAttribute("form") UserCreateForm form, Model model) {

        return "/user/create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String editPersonCommit(@ModelAttribute("form") UserCreateForm form, Model model) {
        User user = new User();

        user.setPassword(UserUtil.getSHA256Password(form.getPassword1(), form.getUserName()));
        user.setSecurityRoles(Constants.ROLE_USER);
        user.setHashKey("nokey");
        user.setAnonymous(Boolean.FALSE);
        // setting company user is bind to.
        user.setUserName(form.getUserName());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setCountry(form.getCountry());
        // ... and so on...

        personRepository.create(user);
        model.addAttribute("currentUser", user);
        return "/user/show";
    }

    @RequestMapping(value="/updateFirstName/{uid}/{newName}")
    public String updateFirstName(@PathVariable("uid") Long uid, @PathVariable("newName") String newName){
        User user = personRepository.findById(uid);
        WwwUser u = UserUtil.getWwwUser();

        String uname = user.getUserName();
        if(u.isSuperuser() || u.getUsername().equals(uname)) {
            user.setFirstName(newName);
            personRepository.update(user);
            return "redirect:/blog/editAccount/" + uid;
        } else {
            return "redirect:/blog/editAccount/" + uid;
        }
    }

    @RequestMapping(value="/updateLastName/{uid}/{newName}")
    public String updateLastName(@PathVariable("uid") Long uid, @PathVariable("newName") String newName){
        User user = personRepository.findById(uid);
        WwwUser u = UserUtil.getWwwUser();

        String uname = user.getUserName();
        if(u.isSuperuser() || u.getUsername().equals(uname)) {
            user.setLastName(newName);
            personRepository.update(user);
            return "redirect:/blog/editAccount/" + uid;
        } else {
            return "redirect:/blog/editAccount/" + uid;
        }
    }

    @RequestMapping(value="/updateEmail/{uid}/{newEmail}")
    public String updateEmail(@PathVariable("uid") Long uid, @PathVariable("newEmail") String newEmail){
        User user = personRepository.findById(uid);
        WwwUser u = UserUtil.getWwwUser();

        String uname = user.getUserName();
        if(u.isSuperuser() || u.getUsername().equals(uname)) {
            user.setEmail(newEmail);
            personRepository.update(user);
            return "redirect:/blog/editAccount/" + uid;
        } else {
            return "redirect:/blog/editAccount/" + uid;
        }
    }

    @RequestMapping(value="/updateMobile/{uid}/{newMobile}")
    public String updateMobile(@PathVariable("uid") Long uid, @PathVariable("newMobile") String newMobile){
        User user = personRepository.findById(uid);
        WwwUser u = UserUtil.getWwwUser();

        String uname = user.getUserName();
        if(u.isSuperuser() || u.getUsername().equals(uname)) {
            user.setMobile(newMobile);
            personRepository.update(user);
            return "redirect:/blog/editAccount/" + uid;
        } else {
            return "redirect:/blog/editAccount/" + uid;
        }
    }
}
