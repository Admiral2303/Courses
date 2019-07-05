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


@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3030")
@RequestMapping(value = "/")
public class LoginFormController {

    private final UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public LoginFormController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signin")
    @ApiOperation(value = "${LoginFormController.signin}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid username/password supplied")})
    public String login(//
                        @ApiParam("Login user") @RequestBody UserDTO user) {
        return userService.signin(modelMapper.map(user, User.class));
    }

    @PostMapping("signup")
    @ApiOperation(value = "${LoginFormController.signup}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String signup(@ApiParam("Signup User") @RequestBody UserDTO user) {
            System.out.println(user);
            User newUser = modelMapper.map(user, User.class);

            newUser.setRoles(Arrays.asList(Role.ROLE_USER));
            return userService.signup(newUser);
    }


    @RequestMapping(value = "users", method = RequestMethod.GET)
    public UsersDTO getAllUser(){
        log.info("{}",userService.getAllUsers());
        return userService.getAllUsers();
    }
}
