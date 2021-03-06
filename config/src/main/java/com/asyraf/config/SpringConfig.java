package com.asyraf.config;

import com.asyraf.example.db.hazelcast.HazelcastUserRepository;
import com.asyraf.example.usecase.port.PasswordEncoder;
import com.asyraf.example.usecase.port.UserRepository;
import com.asyraf.example.encoder.Sha256PasswordEncoder;
import com.asyraf.example.usecase.CreateUser;
import com.asyraf.example.usecase.FindUser;
import com.asyraf.example.usecase.LoginUser;
import com.asyraf.example.uuid.UuidGenerator;

public class SpringConfig {

	private final UserRepository userRepository = new HazelcastUserRepository();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

	public CreateUser createUser() {
		return new CreateUser(userRepository, passwordEncoder, new UuidGenerator());
	}

	public FindUser findUser() {
		return new FindUser(userRepository);
	}

	public LoginUser loginUser() {
		return new LoginUser(userRepository, passwordEncoder);
	}

	public static String getData(){
		return "Holla";
	}
}
