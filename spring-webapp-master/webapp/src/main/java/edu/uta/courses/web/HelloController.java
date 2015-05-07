package edu.uta.courses.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by me on 3.1.2015.
 */

@Controller
public class HelloController {

    Logger logger = Logger.getLogger(HelloController.class.getName());

    @RequestMapping(value = {"/"})
    public String redirect(Model model) {
        return "redirect:/blog/index";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("greeting", "hello World (from home)!");
        System.out.println("home");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("about", "This is ...");
        System.out.println("about");
        return "about";
    }







        @RequestMapping("/login")
        public String login() {
            if (logger.isTraceEnabled()) { logger.trace("login()"); }
            return "/login";
        }

        @RequestMapping("/logout")
        public String logout() {
            if (logger.isTraceEnabled()) { logger.trace("logout()"); }
            return "/logout";
        }




}
