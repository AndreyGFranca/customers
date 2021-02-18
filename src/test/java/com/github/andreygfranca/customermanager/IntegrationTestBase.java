package com.github.andreygfranca.customermanager;

import com.github.andreygfranca.customermanager.bootloader.CustomerManagerApplication;
import com.jayway.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CustomerManagerApplication.class)
public class IntegrationTestBase {
  
  @LocalServerPort
  int port;
  
  @BeforeEach
  public void setUp() {
    RestAssured.port = port;
  }
  
}
