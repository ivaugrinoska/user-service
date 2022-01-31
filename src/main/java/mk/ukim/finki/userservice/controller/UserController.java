package mk.ukim.finki.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.userservice.VO.ResponseTemplateVO;
import mk.ukim.finki.userservice.entity.User;
import mk.ukim.finki.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("{id}")
    public ResponseTemplateVO getUserWithFuel(@PathVariable("id") String username){
        log.info("Inside getUserWithFuel of UserController");
        return userService.getUserWithFuel(username);
    }

}
