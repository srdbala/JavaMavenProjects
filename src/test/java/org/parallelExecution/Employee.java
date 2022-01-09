package org.parallelExecution;

import org.testng.annotations.Test;

public class Employee {

	@Test
	private void tc1() {
		System.out.println(Thread.currentThread().getName());
	}
	
	@Test
	private void tc2() {
		System.out.println(Thread.currentThread().getName());
	}
	
	@Test
	private void tc3() {
		System.out.println(Thread.currentThread().getName());
	}
	
	@Test
	private void tc4() {
		System.out.println(Thread.currentThread().getName());
	}

	@Test
	private void tc5() {
		System.out.println(Thread.currentThread().getName());
	}
	
	@Test
	private void tc6() {
		System.out.println(Thread.currentThread().getName());
	}
}
