package com.riki.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class PasswordGeneratorTest {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void generatePassword() {
		log.info("{}", passwordEncoder.encode("test123"));
	}
}
