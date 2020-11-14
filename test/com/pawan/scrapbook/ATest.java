package com.pawan.scrapbook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ATest {
	
	@Mock
	B b;
	A a;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}

	@Test
	public void usesVoidMethodShouldCallVoidMethod() throws Exception {
		doNothing().when(b).voidMethod();
		assertEquals(0,	a.usesVoidMethod());
		verify(b).voidMethod();
	}
	
	@Test(expected=RuntimeException.class)
	public void usesVoidMethodShouldThrowRuntimeException() throws Exception {
		doThrow(Exception.class).when(b).voidMethod();
		a.usesVoidMethod();
	}
	
	@Test(expected=RuntimeException.class)
	public void consecutiveCallsToUsesVoidMethod() throws Exception {
		doNothing().doThrow(Exception.class).when(b).voidMethod(); // do throw in this line will be executed when void method of b will get called second time
		a.usesVoidMethod();
		verify(b).voidMethod();
		a.usesVoidMethod();
	}

}
