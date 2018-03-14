package ru.kuzmin.secret.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzmin.secret.core.bean.interfaces.UserService;
import ru.kuzmin.secret.core.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public User getUserById(Long userId) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser() {

    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser() {

    }

    public void deleteUser() {

    }


}
