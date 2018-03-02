package ru.kuzmin.secret.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzmin.secret.core.entity.jooq.mysql.tables.pojos.User;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public User getUserById(Long userId) {

    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser() {

    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser() {

    }

    @RequestMapping(method = RequestMethod.PUT)
    public void deleteUser() {

    }


}
