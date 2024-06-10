package com.qa.tests;

import org.testng.TestNG;


import com.qa.utils.ExtentReportListener;

public class TestRunner {
	
	static TestNG testNg;
    
    public static void main(String[] args) {
    	
        ExtentReportListener ext = new ExtentReportListener();
        
            testNg = new TestNG();
            testNg.setTestClasses(new Class[] {LoginPageTest.class});
            testNg.addListener(ext);
            testNg.run();
    }
}
