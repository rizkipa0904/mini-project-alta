package com.alta.ecommerce.controller;

import com.alta.ecommerce.dto.ProductDto;
import com.alta.ecommerce.dto.ResponseDto;
import com.alta.ecommerce.dto.user.SignInDto;
import com.alta.ecommerce.dto.user.SignInReponseDto;
import com.alta.ecommerce.dto.user.SignupDto;
import com.alta.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    // two apis

    // signup

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
        return userService.signUp(signupDto);
    }


    // signin

    @PostMapping("/signin")
    public SignInReponseDto signIn(@RequestBody SignInDto signInDto) {
        return userService.signIn(signInDto);
    }


}
