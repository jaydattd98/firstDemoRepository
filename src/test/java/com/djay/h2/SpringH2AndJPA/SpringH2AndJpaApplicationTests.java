package com.djay.h2.SpringH2AndJPA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SpringH2AndJpaApplicationTests {

	@Autowired
	SpringH2AndJpaApplication springH2AndJpaApplication;
	@Test
	public void contextLoads() {
		assertNotNull(springH2AndJpaApplication);
	}

}
