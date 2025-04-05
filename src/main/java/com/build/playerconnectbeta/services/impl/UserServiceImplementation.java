package com.build.playerconnectbeta.services.impl;

import com.build.playerconnectbeta.entity.User;
import com.build.playerconnectbeta.exceptions.ResourceNotFoundException;
import com.build.playerconnectbeta.payload.UserDto;
import com.build.playerconnectbeta.repository.UserRepository;
import com.build.playerconnectbeta.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User newUser = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(newUser);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhoneNo());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());
        user.setGames(userDto.getGames());
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", userId));
        userRepository.delete(user);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", userId));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }
}
