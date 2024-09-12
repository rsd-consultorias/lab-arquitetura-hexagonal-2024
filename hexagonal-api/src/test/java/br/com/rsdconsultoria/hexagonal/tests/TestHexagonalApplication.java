package br.com.rsdconsultoria.hexagonal.tests;

import org.springframework.boot.SpringApplication;

import br.com.rsdconsultoria.hexagonal.HexagonalApplication;

public class TestHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.from(HexagonalApplication::main).with(TestcontainersConfiguration.class).run(args);
	}
}
