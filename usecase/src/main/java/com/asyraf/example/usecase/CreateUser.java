package com.asyraf.example.usecase;

import com.asyraf.example.domain.entity.User;
import com.asyraf.example.usecase.exception.UserAlreadyExistsException;
import com.asyraf.example.usecase.port.IdGenerator;
import com.asyraf.example.usecase.port.PasswordEncoder;
import com.asyraf.example.usecase.port.UserRepository;
import com.asyraf.example.usecase.validator.UserValidator;

public final class CreateUser {

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final IdGenerator idGenerator;

	public CreateUser(final UserRepository repository, final PasswordEncoder passwordEncoder, final IdGenerator idGenerator) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.idGenerator = idGenerator;
	}

	public User create(final User user) {
		UserValidator.validateCreateUser(user);
		if (repository.findByEmail(user.getEmail()).isPresent()) {
			throw new UserAlreadyExistsException(user.getEmail());
		}
		var userToSave = User.builder()
			.id(idGenerator.generate())
			.email(user.getEmail())
			.password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
			.lastName(user.getLastName())
			.firstName(user.getFirstName())
			.build();
		return repository.create(userToSave);
	}
}
