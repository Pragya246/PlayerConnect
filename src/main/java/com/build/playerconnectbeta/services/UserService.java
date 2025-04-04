package com.build.playerconnectbeta.services;

import com.build.playerconnectbeta.payload.UserDto;
import com.build.playerconnectbeta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Integer userId);
    void deleteUser(Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
}
