package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserServiceImpl;

@Controller
public class HelloController {

    static UserServiceImpl userService = new UserServiceImpl();

    static {

        userService.addUser(new User("Eugenio", "Strigo123", 32));
        userService.addUser(new User("Ivan", "Ivanov", 34));
    }

    @RequestMapping("/")
    public String getHello(Model model){
        System.out.println("UserController starts its job");
        model.addAttribute("usersList", userService.getUserList());

        System.out.println("UserController finishes its job");
        return "index";
    }
}
