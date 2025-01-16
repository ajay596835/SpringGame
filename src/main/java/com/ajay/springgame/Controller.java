package com.ajay.springgame;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @Operation(summary = "Get all users", description = "Returns a list of users")
    @GetMapping("/users")
    public List<String> getUsers() {
        return Arrays.asList("Alice", "Bob", "Charlie");
    }
}