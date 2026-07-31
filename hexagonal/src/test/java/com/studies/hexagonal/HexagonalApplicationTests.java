package com.studies.hexagonal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studies.hexagonal.application.dto.request.UserRequest;
import com.studies.hexagonal.application.dto.response.UserResponse;
import com.studies.hexagonal.application.port.input.usecases.user.CreateUserUseCase;
import com.studies.hexagonal.application.port.input.usecases.user.DeleteUserUseCase;
import com.studies.hexagonal.application.port.output.persistence.interfaces.PasswordEncoderPort;
import com.studies.hexagonal.application.port.output.persistence.repository.UserRepository;
import com.studies.hexagonal.domain.model.User;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HexagonalApplicationTests {

	@Autowired
	UserRepository repository;

	@Autowired
	CreateUserUseCase create;

	@Autowired
	DeleteUserUseCase delete;

	@Autowired
	PasswordEncoderPort encoder;

	@Test
	void succesCreate() {
		UserRequest request = new UserRequest();
        request.setName("seyi");
        request.setEmail("testeunit@gmail.com");
        request.setPassword("123456");

        UserResponse response = create.execute(request);

        assertThat(response.getId()).isNotNull();
        assertThat(response.getName()).isEqualTo("seyi");
        assertThat(response.getEmail()).isEqualTo("testeunit@gmail.com");

        User persisted = repository.findById(response.getId()).orElseThrow();
        assertThat(encoder.matches("123456", persisted.getPassword())).isTrue();
    }

	@Test
	void succesDelete() {
		User user = new User();
		user.setName("seyi");
		user.setEmail("delete-test@gmail.com");
		user.setPassword(encoder.encode("123456"));
		User saved = repository.save(user);

		delete.execute(saved.getId());

		assertThat(repository.findById(saved.getId())).isEmpty();
	}

}
