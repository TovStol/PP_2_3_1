package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {

        return "redirect:users";
    }

    @GetMapping(value = "/users")
    public String getAllUser(Model model) {
        model.addAttribute("listUser", userService.getAllUsers());

        return "users";
    }

    @GetMapping(value = "/users/new")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add_user";
    }

    @PostMapping(value = "/users")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "users/edit/{id}")
    public String editUserForm(@PathVariable long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping(value = "/users/{id}")
    public String updateUser(@PathVariable long id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "users/delete/{id}")
    public String deleteUser(@PathVariable long id) {
       userService.removeUserById(id);
        return "redirect:/users";
    }

}
