package org.spring.context.event.blacklist;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;


public class BlackListNotifier implements ApplicationListener<BlackListEvent> {
	
	private String notificationAddress;

	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}

	public void onApplicationEvent(BlackListEvent event) {
		System.out.println("向"+notificationAddress+"通知发送的邮件由于被拉入黑名单发送失败");
		System.out.println("发送失败email内容："+event.toString());
	}

	@EventListener
	@Order(1)
	public void processBlackListEvent(BlackListEvent event) {
		System.out.println("向"+notificationAddress+"通知发送的邮件由于被拉入黑名单发送失败");
		System.out.println("发送失败email内容："+event.toString());
	}
	
	@EventListener({BlackListEvent.class})
	@Order(2)
	public void processBlackListEvent() {
		System.out.println("向"+notificationAddress+"通知发送的邮件由于被拉入黑名单发送失败");
	}
	
	@EventListener(condition = "#event.getContent() == '你好'")
	@Order(3)
	public void processBlackListEventByCondition(BlackListEvent event) {
		System.out.println("向"+notificationAddress+"通知发送的邮件由于被拉入黑名单发送失败");
		System.out.println("发送失败email内容："+event.toString());
	}
	
	@EventListener
	@Order(4)
	public ListUpdateEvent processBlackListEvent2UpdateEvent(BlackListEvent event) {
		System.out.println("向"+notificationAddress+"通知发送的邮件由于被拉入黑名单发送失败");
		System.out.println("发送失败email内容："+event.toString());
		return new ListUpdateEvent(this);
	}
	
	@EventListener
	@Order(5)
	public void processListUpdateEvent(ListUpdateEvent event) {
		System.out.println("ListUpdateEvent");
	}
	
	@EventListener
	@Order(5)
	public void processEntityCreatedEvent(EntityCreatedEvent<Person> event) {
		System.out.println("EntityCreatedEvent");
	}
	
}
