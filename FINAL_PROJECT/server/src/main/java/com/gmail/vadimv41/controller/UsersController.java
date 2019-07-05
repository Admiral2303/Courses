package com.gmail.vadimv41.controller;

import com.gmail.vadimv41.dto.UserDTO;
import com.gmail.vadimv41.entity.Role;
import com.gmail.vadimv41.exception.CustomException;
import com.gmail.vadimv41.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gmail.vadimv41.dto.UsersDTO;
import com.gmail.vadimv41.entity.User;
import java.util.Arrays;
import java.util.List;


@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3030")
@RequestMapping(value = "/")
public class UsersController {

    private final UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public UsersDTO getAllUser(){
        log.info("{}",userService.getAllUsers());
        return userService.getAllUsers();
    }
}

