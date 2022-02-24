package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserServiceImpl userService;


    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }


    // Получаем список всех User из dao и передаём во view
    @GetMapping()
    public String showAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users/showAllUsers";
    }


    @PostMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("addedUser", new User());
        return "addUser";
    }

    // Получаем User'а из dao по его Id и передаём во view
    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") int id){

        return null;
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute ("addedUser") User user) {
        userService.addUser(user);
        return "redirect: users/showAllUsers";
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
