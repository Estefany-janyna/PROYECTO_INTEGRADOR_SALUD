package com.tecsup.RegisterReserva.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
/////////////////////////////////77
import org.springframework.stereotype.Service;

import com.tecsup.RegisterReserva.Dto.LoginDTO;
///////////////////
import com.tecsup.RegisterReserva.Dto.UserDTO;
import com.tecsup.RegisterReserva.Service.UserService;
import com.tecsup.RegisterReserva.Entity.User;
import com.tecsup.RegisterReserva.Repo.UserRepo;
import com.tecsup.RegisterReserva.Response.LoginResponse;

@Service
public class UserIMPL implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addUser(UserDTO userDTO) {

		User user = new User(

				userDTO.getUserid(), userDTO.getUser_name(), userDTO.getEmail(),

				this.passwordEncoder.encode(userDTO.getPassword()));

		userRepo.save(user);
		return user.getUser_name();

	}

	@Override
	public LoginResponse loginUser(LoginDTO loginDTO) {
		String msg = "";
		User user1 = userRepo.findByEmail(loginDTO.getEmail());
		if (user1 != null) {
			String password = loginDTO.getPassword();
			String encodedPassword = user1.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if (isPwdRight) {
				Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
				if (user.isPresent()) {
					return new LoginResponse("Login exitoso", true);
				} else {
					return new LoginResponse("Login fallida", false);
				}
			} else {
				return new LoginResponse("Contraseña no existe", false);
			}

		} else {
			return new LoginResponse("Email no existe", false);
		}
	}
}