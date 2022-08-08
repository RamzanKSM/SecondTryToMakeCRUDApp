package crud.controllers;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String startPage (Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "/start";
    }

    @GetMapping("/{id}")
    public String getUserById (@PathVariable("id") long id, Model model) {
        model.addAttribute("someUser", userService.getOneUser(id));
        return "/someUser";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping
    public String createNewUser (@ModelAttribute ("user") User user) {
        userService.add(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String editUser (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getOneUser(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") long id) {
        userService.remove(id);
        return "redirect:/user";
    }
}
