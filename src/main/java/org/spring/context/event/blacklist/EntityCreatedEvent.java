package org.spring.context.event.blacklist;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class EntityCreatedEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

	public EntityCreatedEvent(T entity) {
		super(entity);
	}

	public ResolvableType getResolvableType() {
		 return ResolvableType.forClassWithGenerics(getClass(),
	                ResolvableType.forInstance(getSource()));
	}

}
