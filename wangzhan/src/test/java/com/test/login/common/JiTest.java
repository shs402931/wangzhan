package com.test.login.common;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

public class JiTest {
  @Test
  public void f() {
	  SendGet a = new SendGet();
	  
	  String ss =a.send("http://www.shihongsen.ink/awardPrize", "login_id=1");
	  System.out.println(ss);
  }

  @Test
  public void b() {
	  SendGet b= new SendGet();
	  String bb = b.send("http://www.shihongsen.ink/page", null);
	  System.out.println(bb);
  }

  @AfterClass
  public void afterClass() {
  }

}
