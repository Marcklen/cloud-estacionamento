package br.com.dio.estacionamento.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import br.com.dio.estacionamento.model.dto.EstacionamentoFormDTO;
import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EstacionamentoControllerTest {

	@LocalServerPort
	private int randomPort;
	
	@BeforeEach
	void setUp() throws Exception {
		//testando a porta para saber se deu certo
		//System.out.println(randomPort);
		RestAssured.port = randomPort;
	}

//	@Test
//	void testEstacionamentoController() {
//		fail("Not yet implemented");
//	}

	@Test
	void testFindAllwithSucess() {
		RestAssured.given()
			.when()
			.get("/estacionamento")
			.then()
			.statusCode(200)
			.body("placa[0]", Matchers.equalTo("HGX-5678"));
		
	}

//	@Test
//	void testFindById() {
//		fail("Not yet implemented");
//	}

	@Test
	void testCreatewithSucess() {
		EstacionamentoFormDTO dtoForm = new EstacionamentoFormDTO();
		dtoForm.setCor("PRETO");
		dtoForm.setEstado("CE");
		dtoForm.setMarca("HYUNDAI");
		dtoForm.setModelo("CRETA");
		dtoForm.setPlaca("PMD-1234");
		
		RestAssured.given()
					.when()
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.body(dtoForm)
					.post("/estacionamento")
					.then()
					.statusCode(HttpStatus.CREATED.value())
					.body("placa", Matchers.equalTo("PMD-1234"));
		
	}
//
//	@Test
//	void testDelete() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdate() {
//		fail("Not yet implemented");
//	}

}
