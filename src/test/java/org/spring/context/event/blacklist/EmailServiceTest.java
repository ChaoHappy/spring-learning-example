package org.spring.context.event.blacklist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.context.event.blacklist.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-event.xml")
public class EmailServiceTest {
	
	@Autowired
	private EmailService emailService;
	
	@Test
	public void testSendEmail() {
		emailService.sendEmail("127.0.0.2", "你好");
	}
	
	@Test
	public void testSendEmailByPerson() {
		Person p = new Person();
		p.setAddress("127.0.0.2");
		p.setContent("你好");
		emailService.sendEmail(p);
	}
	
}
