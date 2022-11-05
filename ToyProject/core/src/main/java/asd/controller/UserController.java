package asd.controller;

import asd.model.Users;
import asd.repositoy.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    @Transactional
    public Users create(@RequestBody Users user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    @Transactional
    public String read(@PathVariable Long id) {

        Optional<Users> userOptional = userRepository.findById(id);
        userOptional.ifPresent(System.out::println);

        return userOptional.get().getUsername();
    }
}
