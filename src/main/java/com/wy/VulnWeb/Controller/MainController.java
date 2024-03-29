package com.wy.VulnWeb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;
import java.util.List;

import com.wy.VulnWeb.Model.User;
import com.wy.VulnWeb.Repository.*;
import com.wy.VulnWeb.Service.UserService;

@Controller
public class MainController {
    
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @Resource
    UserService userService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/rxss")
    public String rxss() {
        return "rxss";
    }


    @PostMapping("/rxss")
    public String rxss(@RequestParam Map<String, Object> params, Model model) {
        model.addAttribute("name", params.get("name"));
        return "rxss";
    }
    
    @RequestMapping("/search")
    public String search() {
        return "search";
    }
    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<User> user = userService.findByName(name);
        model.addAttribute("user", user);
        return "search";
    }

    //
    @RequestMapping("/list")
    public String list(Model model) {
        //User user = userRepository.findByName(name);
        List<User> users=userService.getUserList();
        model.addAttribute("users", users);
        return "list";
    }

    @RequestMapping("/csrf")
    public String csrf() {
        return "login";
    }

    @PostMapping("/login")
    //@RequestParam Map<String, Object> params
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
        // loginCheck(name, password)
        boolean flag;
        if(userRepository.findNameAndPassword(name,password) > 0) {
            flag = true;
        }
        else {
            flag = false;
        }

        model.addAttribute("flag", flag);
        return "login";
    }
/*
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
*/
}