package org.parallelExecution;

import org.testng.annotations.Test;

public class Company {

	@Test
	private void tc11() {
		System.out.println(Thread.currentThread().getName());
	}

	@Test
	private void tc12() {
		System.out.println(Thread.currentThread().getName());
	}
	
	@Test
	private void tc13() {
		System.out.println(Thread.currentThread().getName());
	}
}
