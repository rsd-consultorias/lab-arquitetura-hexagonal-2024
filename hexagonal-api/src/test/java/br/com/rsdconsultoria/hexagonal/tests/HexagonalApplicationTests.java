package br.com.rsdconsultoria.hexagonal.tests;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
public class HexagonalApplicationTests {

	@Test
	public void contextLoads() {
	}

}
