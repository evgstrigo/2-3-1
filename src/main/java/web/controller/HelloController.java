package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserServiceImpl;

@Controller
public class HelloController {

    static UserServiceImpl userService = new UserServiceImpl();


    @RequestMapping("/")
    public String getHello(Model model){
        System.out.println("UserController starts its job");
        model.addAttribute("usersList", userService.getUserList());
        System.out.println("UserController finishes its job");
        return "index";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("addedUser", new User());
        return "addUser";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute ("addedUser") User user) {
        userService.addUser(user);
        return "redirect: /";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect: /";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id, Model model) {
        model.addAttribute("addedUser", userService.getUserById(id));
        return "addUser";
    }




}
