package com.pawan.scrapbook;

public class A {
	B b;
	A(B b){
		this.b=b;
	}
	public int usesVoidMethod() {
		try {
			b.voidMethod();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
}
