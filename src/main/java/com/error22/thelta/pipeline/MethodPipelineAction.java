package com.error22.thelta.pipeline;

import java.lang.reflect.Method;

public class MethodPipelineAction implements IPipelineAction {
	private Object instance;
	private Method method;

	public MethodPipelineAction(Object instance, Method method) {
		this.instance = instance;
		this.method = method;
		method.setAccessible(true);
	}

	@Override
	public void perform() {
		try {
			method.invoke(instance);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
