package com.test.login.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TtTest {
  @Test(dataProvider="f")
  public void f(String[] f) {
	  System.out.println(f[0]);
	  System.out.println(f[1]);
  }
  
  @DataProvider(name="f") 
  public Object[][] testdata(){
  return new Object[][]{
  {"test1-1","test1-2"},
  {"test2-1","test2-2"},
   };
  }
}
