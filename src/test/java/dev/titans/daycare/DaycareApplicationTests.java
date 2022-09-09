package dev.titans.daycare;


import dev.titans.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DaycareApplicationTests {

	@Autowired
	JwtService jwtServicel;

	@Test
	void contextLoads() {

	}

	@Test
	void validates_jwt() {
		String jwt = "fseesad";
		jwtServicel.validateJwt(jwt);
	}




}
