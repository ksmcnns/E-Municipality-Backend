package com.belediye.bproject.controller;

import com.belediye.bproject.dto.ApiResponse;
import com.belediye.bproject.dto.UserAuthenticationDTO;
import com.belediye.bproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserAuthenticationDTO>> loginUser(@RequestBody UserAuthenticationDTO authenticationDTO){
        boolean isAuthenticated = userService.authenticateUser(authenticationDTO.getNationalIdNo(),authenticationDTO.getPassword());
        if (isAuthenticated) {
           UserAuthenticationDTO userAuthenticationDTO = userService.getUserDetails(authenticationDTO.getNationalIdNo());
           ApiResponse<UserAuthenticationDTO> response = new ApiResponse<>(userAuthenticationDTO);
        return ResponseEntity.ok(response);
        }
        else{
            // Boş bir UserAuthenticationDTO oluşturun
            UserAuthenticationDTO nullAuthenticationDTO = new UserAuthenticationDTO();
            ApiResponse<UserAuthenticationDTO> response = new ApiResponse<>(nullAuthenticationDTO);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
