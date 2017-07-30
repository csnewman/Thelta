package com.error22.thelta.virtualsystem.java.ir;

public class StaticField {
	private FieldSignature signature;
	private Object value;

	public StaticField(FieldSignature signature, Object value) {
		this.signature = signature;
		if (value == null)
			this.value = signature.getType().getDefault();
		else
			this.value = value;
	}

	public FieldSignature getSignature() {
		return signature;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

}
