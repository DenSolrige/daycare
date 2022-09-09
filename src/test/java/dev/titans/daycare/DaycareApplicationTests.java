package dev.titans.daycare;


import dev.titans.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

@SpringBootTest
class DaycareApplicationTests {

	@Autowired
	JwtService jwtServicel;

	@Autowired
	JmsTemplate jmsTemplate;

	@Test
	void contextLoads() {

		String message = "Student: Raven was removed from the class";
		jmsTemplate.convertAndSend("titan-important-events", message);

	}



}







