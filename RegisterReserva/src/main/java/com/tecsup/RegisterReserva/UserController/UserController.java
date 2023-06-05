package com.tecsup.RegisterReserva.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tecsup.RegisterReserva.Dto.LoginDTO;
import com.tecsup.RegisterReserva.Dto.UserDTO;
import com.tecsup.RegisterReserva.Response.LoginResponse;
import com.tecsup.RegisterReserva.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/usuario")

public class UserController {
	
	@Autowired
    private UserService userService;
    
	
    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO) 
    {
        String id = userService.addUser(userDTO);
        return id;
    }
    
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) 
    {
    	LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}

