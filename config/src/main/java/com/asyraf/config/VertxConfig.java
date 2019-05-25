package com.asyraf.config;

import com.asyraf.example.db.InMemoryUserRepository;
import com.asyraf.example.encoder.Sha256PasswordEncoder;
import com.asyraf.example.jug.JugIdGenerator;
import com.asyraf.example.usecase.CreateUser;
import com.asyraf.example.usecase.FindUser;
import com.asyraf.example.usecase.LoginUser;
import com.asyraf.example.usecase.port.IdGenerator;
import com.asyraf.example.usecase.port.PasswordEncoder;
import com.asyraf.example.usecase.port.UserRepository;

public class VertxConfig {

	private final UserRepository userRepository = new InMemoryUserRepository();
	private final IdGenerator idGenerator = new JugIdGenerator();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();
	private final CreateUser createUser = new CreateUser(userRepository, passwordEncoder, idGenerator);
	private final FindUser findUser = new FindUser(userRepository);
	private final LoginUser loginUser = new LoginUser(userRepository, passwordEncoder);

	public CreateUser createUser() {
		return createUser;
	}

	public FindUser findUser() {
		return findUser;
	}

	public LoginUser loginUser() {
		return loginUser;
	}
}
