package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;


@Controller
public class UsersController {


    private UserService userService;


    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }


    @PostMapping("/")
    public String createUser(@ModelAttribute("newUser") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }


    @GetMapping("/new")
    public String addNewUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "user-info-new";
    }


    @GetMapping("/{id}/edit")
    public String updateUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("editedUser", userService.getUserById(id));
        return "user-info-edit";
    }


    @PatchMapping("/{id}")
    public String updateUserAndShowUsersList(@PathVariable("id") int id, @ModelAttribute("editedUser") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }


    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


}
