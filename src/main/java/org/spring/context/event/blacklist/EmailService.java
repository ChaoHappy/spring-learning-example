package org.spring.context.event.blacklist;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class EmailService implements ApplicationEventPublisherAware {
	
	private List<String> blackList;
	
	public void setBlackList(List<String> blackList) {
		this.blackList = blackList;
	}

	private ApplicationEventPublisher  publisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		publisher = applicationEventPublisher;
	}
	
	public void sendEmail(String address,String content) {
		if(blackList.contains(address)) {
			publisher.publishEvent(new BlackListEvent(this, address, content));
			return;
		}
		System.out.println("给地址"+address+"发送email内容："+content);
	}
	
	public void sendEmail(Person person) {
		if(blackList.contains(person.getAddress())) {
			publisher.publishEvent(new EntityCreatedEvent<Person>(person));
			return;
		}
		System.out.println("给地址"+person.getAddress()+"发送email内容："+person.getContent());
	}

}
