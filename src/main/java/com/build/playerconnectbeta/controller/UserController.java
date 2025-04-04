package com.build.playerconnectbeta.controller;

import com.build.playerconnectbeta.payload.UserDto;
import com.build.playerconnectbeta.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add/user")
    ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {
        UserDto userDto1 = userService.createUser(userDto);
        return ResponseEntity.ok(userDto1);
    }

    @PutMapping("/updatuser/{userId}")
    ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable int userId) {
        UserDto userDto1 = userService.updateUser(userDto, userId);
        return new ResponseEntity<>(userDto1, HttpStatus.OK);
    }

    @GetMapping("/getuser/{userId}")
    ResponseEntity<UserDto> getUser(@PathVariable int userId) {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/getalluser")
    ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> userDtoList = userService.getAllUsers();
        return ResponseEntity.ok(userDtoList);
    }
    @DeleteMapping("/deleteuser/{userId}")
    ResponseEntity<String> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok(String.format("User with id %d deleted successfully", userId));
    }
}
