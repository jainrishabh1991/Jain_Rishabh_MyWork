package com.csye6225.demo;

import io.restassured.RestAssured;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class RestAssuredDemoApiTest {

  @Test
  public void testGetHomePage() throws URISyntaxException {
    RestAssured.when().get(new URI("http://localhost:8080/")).then().statusCode(200);
  }

  @Test
  public void Welcome(){
    assertEquals(5,7);

    System.out.println("The default configuration");
  }


}
