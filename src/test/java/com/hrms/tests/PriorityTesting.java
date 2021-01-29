package com.hrms.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriorityTesting {

//	 (priority = 0, enabled = false)
	
	@BeforeMethod
	public void beforeMethod () {}
	
	@Test (priority = 2)
	public void test1 () {
		System.out.println("in Test #1");
	}
	@Test (priority = 1)
	public void test2 () {
		System.out.println("in Test #2");
	}
	@Test (priority = 0, enabled = false)
	public void test3 () {
		System.out.println("in Test #3");
	}
	
	//****************************************//
	@Test(groups = { "functest"})
	public void test4() {
		System.out.println("in Test #4");
	}
	@Test(groups = { "smokeTest" })
	public void test5() {
		System.out.println("in Test #5");
	}
	@Test(groups = { "RegressionTest" })
	public void test6() {
		System.out.println("in Test #6");
	}
	@Test(groups = { "functest", "smokeTest" })
	public void test7() {
		System.out.println("in Test #7");
	}

	
} // end class
