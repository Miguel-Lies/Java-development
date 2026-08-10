package com.studies.hexagonal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studies.hexagonal.Adapters.output.entity.SellerEntity;
import com.studies.hexagonal.Adapters.output.repository.SellerEntityRepository;
import com.studies.hexagonal.Application.dto.request.ItemRequest;
import com.studies.hexagonal.Application.dto.request.UserRequest;
import com.studies.hexagonal.Application.dto.response.ItemResponse;
import com.studies.hexagonal.Application.dto.response.UserResponse;
import com.studies.hexagonal.Application.port.input.usecases.item.AddItemUseCase;
import com.studies.hexagonal.Application.port.input.usecases.item.FindItemUseCase;
import com.studies.hexagonal.Application.port.input.usecases.item.RemoveItemUseCase;
import com.studies.hexagonal.Application.port.input.usecases.user.CreateUserUseCase;
import com.studies.hexagonal.Application.port.input.usecases.user.DeleteUserUseCase;
import com.studies.hexagonal.Application.port.output.persistence.interfaces.PasswordEncoderPort;
import com.studies.hexagonal.Application.port.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.Application.port.output.persistence.repository.UserRepository;
import com.studies.hexagonal.Domain.model.Item;
import com.studies.hexagonal.Domain.model.User;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class HexagonalApplicationTests {

	//user test

	@Autowired
	UserRepository userRepository;

	@Autowired
	CreateUserUseCase createUser;

	@Autowired
	DeleteUserUseCase deleteUser;

	@Autowired
	PasswordEncoderPort encoder;

	//item test

	@Autowired
	AddItemUseCase  addItem;

	@Autowired
	RemoveItemUseCase removeItem;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	SellerEntityRepository sellerEntityRepository;

	@Autowired
	FindItemUseCase findItemUseCase;

	//user tests

	@Test
	void succesUserCreate() {
		UserRequest request = new UserRequest();
        request.setName("seyi");
        request.setEmail("testeunit@gmail.com");
        request.setPassword("123456");

        UserResponse response = createUser.execute(request);

        assertThat(response.getId()).isNotNull();
        assertThat(response.getName()).isEqualTo("seyi");
        assertThat(response.getEmail()).isEqualTo("testeunit@gmail.com");

        User persisted = userRepository.findById(response.getId()).orElseThrow();
        assertThat(encoder.matches("123456", persisted.getPassword())).isTrue();
    }

	@Test
	void succesUserDelete() {
		User user = new User();
		user.setName("seyi");
		user.setEmail("delete-test@gmail.com");
		user.setPassword(encoder.encode("123456"));
		User saved = userRepository.save(user);

		deleteUser.execute(saved.getId());

		assertThat(userRepository.findById(saved.getId())).isEmpty();
	}

	//item tests

	@Test
    void addItemSucces(){
		SellerEntity seller = sellerEntityRepository.save(
			SellerEntity.builder()
                .name("lies")
                .nameEnterprise("liesCompany")
                .cnpjOfEnterprise("845638459-12")
                .email("liestest@gmail.com")
                .build()
			);

			ItemRequest request = new ItemRequest();
			request.setSelleri(seller.getId());
			request.setName("teclado ajazz nk68 v2");
			request.setPrice(BigDecimal.valueOf(220));
			request.setQuantity(13);

			ItemResponse response = addItem.execute(request);

			assertThat(response.getId()).isNotNull();
			assertThat(response.getName()).isNotBlank();
			assertThat(response.getPrice()).isNotNull();
			assertThat(response.getQuantity()).isNotNull();
		}

		@Test
		void findByNameSucces(){
			SellerEntity seller = sellerEntityRepository.save(
				SellerEntity.builder()
				.name("lies")
				.nameEnterprise("liesCompany")
                .cnpjOfEnterprise("845638459-12")
                .email("liestest@gmail.com")
				.build()
			);

			ItemRequest request = new ItemRequest();
			request.setSelleri(seller.getId());
			request.setName("teclado ajazz nk68 v2");
			request.setPrice(BigDecimal.valueOf(220));
			request.setQuantity(13);
			
			addItem.execute(request);

			List<Item> response = findItemUseCase.execute(request.getName());

			assertThat(response).isNotEmpty();
            assertThat(response).hasSize(1);
            assertThat(response.get(0).getName()).isEqualTo(request.getName());
		}

		@Test
		void removeItemSucces(){
			SellerEntity seller = sellerEntityRepository.save(
				SellerEntity.builder()
				.name("lies")
				.nameEnterprise("liesCompany")
                .cnpjOfEnterprise("845638459-12")
                .email("liestest@gmail.com")
				.build()
			);

			ItemRequest request = new ItemRequest();
			request.setSelleri(seller.getId());
			request.setName("teclado ajazz nk68 v2");
			request.setPrice(BigDecimal.valueOf(220));
			request.setQuantity(13);
			
			ItemResponse created = addItem.execute(request);
			
			Item response = removeItem.execute(created.getId());

			assertThat(response.getId()).isNotNull();
			assertThat(response.getName()).isNotBlank();
			assertThat(response.getPrice()).isNotNull();
			assertThat(response.getQuantity()).isNotNull();
		}
}
