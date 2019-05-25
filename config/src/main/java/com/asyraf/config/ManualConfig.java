package com.asyraf.config;

import com.asyraf.example.db.InMemoryUserRepository;
import com.asyraf.example.usecase.port.IdGenerator;
import com.asyraf.example.usecase.port.PasswordEncoder;
import com.asyraf.example.usecase.port.UserRepository;
import com.asyraf.example.encoder.Sha256PasswordEncoder;
import com.asyraf.example.jug.JugIdGenerator;
import com.asyraf.example.usecase.CreateUser;
import com.asyraf.example.usecase.FindUser;
import com.asyraf.example.usecase.LoginUser;

public class ManualConfig {
	private final UserRepository userRepository = new InMemoryUserRepository();
	private final IdGenerator idGenerator = new JugIdGenerator();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

	public CreateUser createUser() {
		return new CreateUser(userRepository, passwordEncoder, idGenerator);
	}

	public FindUser findUser() {
		return new FindUser(userRepository);
	}

	public LoginUser loginUser() {
		return new LoginUser(userRepository, passwordEncoder);
	}
}
