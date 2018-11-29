package tests;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNG testng = new TestNG();
	    List<String> suites = Lists.newArrayList();
	    suites.add("./testng.xml");
	    testng.setTestSuites(suites);
	    testng.run();
	}

}
