package com.github.andreygfranca.customermanager.adapter.api.v1.controller;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.github.andreygfranca.customermanager.IntegrationTestBase;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.city.CityResponseDTO;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerResponseDTO;
import com.github.andreygfranca.customermanager.core.domain.Gender;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

@DisplayName("Customer Integration Test")
class CustomerControllerIT extends IntegrationTestBase {
  
  @Test
  @Tag("customer-it")
  @DisplayName("When creating a new customer then make sure it was actually created.")
  public void testCreateCustomer() {
    CustomerResponseDTO customer = com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerResponseDTO.builder()
        .name("Sam Rogers")
        .age(57)
        .birthDate(LocalDate.of(1963, 10, 1))
        .gender(Gender.MALE.toString())
        .city(CityResponseDTO.builder().name("test").state("test1").build())
        .build();
    
    given()
        .body(customer)
        .contentType("application/json")
        .when()
        .post("/api/v1/customer")
        .then()
        .assertThat()
        .statusCode(HttpStatus.CREATED.value())
        .and()
        .body("name", equalTo("Sam Rogers"))
        .body("age", equalTo(57))
        .body("birthDate", equalTo("1963-10-01"))
        .body("gender", equalTo("MALE"))
        .body("city.name", equalTo("test"))
        .body("city.state", equalTo("test1"));
  }
  
  @Test
  @Tag("customer-it")
  @DisplayName("When searching for a customer by id then make sure it was found.")
  public void testFindCustomerById() {
    CustomerResponseDTO customer = com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerResponseDTO.builder()
        .name("Sam Rogers")
        .age(57)
        .birthDate(LocalDate.of(1963, 10, 1))
        .gender(Gender.MALE.toString())
        .build();
    
    CustomerResponseDTO created = createCustomer(customer);
    
    given()
        .contentType("application/json")
        .pathParam("id", created.getId())
        .when()
        .get("/api/v1/customer/{id}")
        .then()
        .assertThat()
        .statusCode(HttpStatus.OK.value())
        .and()
        .body("id", equalTo(1))
        .body("age", equalTo(57))
        .body("gender", equalTo("MALE"))
        .body("birthDate", equalTo("1963-10-01"));
  }
  
  @Test
  @Tag("customer-it")
  @DisplayName("When deleting a customer then ensure that will not be able to find that customer again.")
  public void testDeleteCustomer() {
    CustomerResponseDTO customer = com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerResponseDTO.builder()
        .name("Sam Rogers")
        .age(57)
        .birthDate(LocalDate.of(1963, 10, 1))
        .gender(Gender.MALE.toString())
        .build();
    
    CustomerResponseDTO created = createCustomer(customer);
    
    given()
        .contentType("application/json")
        .pathParam("id", created.getId())
        .when()
        .delete("/api/v1/customer/{id}")
        .then()
        .assertThat()
        .statusCode(HttpStatus.NO_CONTENT.value());
    
    given()
        .contentType("application/json")
        .pathParam("id", created.getId())
        .when()
        .get("/api/v1/customer/{id}")
        .then()
        .assertThat()
        .statusCode(HttpStatus.NOT_FOUND.value())
        .body("status", equalTo(404))
        .body("title", equalTo("Not found"))
        .body("detail", equalTo("Customer with id " + created.getId() + " does not exists."));
  }
  
  @Test
  @Tag("customer-it")
  @DisplayName("When find a customer by name then ensure that will return.")
  public void testFindCustomerByName() {
    CustomerResponseDTO customer = com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerResponseDTO.builder()
        .name("Sam Rogers")
        .age(57)
        .birthDate(LocalDate.of(1963, 10, 1))
        .gender(Gender.MALE.toString())
        .build();
    
    createCustomer(customer);
    
    given()
        .contentType("application/json")
        .queryParam("name", "Sam")
        .when()
        .get("/api/v1/customer")
        .then()
        .assertThat()
        .statusCode(HttpStatus.OK.value())
        .and()
        .body("id[0]", equalTo(1))
        .body("age[0]", equalTo(57))
        .body("gender[0]", equalTo("MALE"))
        .body("birthDate[0]", equalTo("1963-10-01"));
  }
  
  @Test
  @Tag("customer-it")
  @DisplayName("When updating a customer then make sure it was updated.")
  public void testUpdateCustomer() {
    CustomerResponseDTO customer = com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerResponseDTO.builder()
        .name("Sam Rogers")
        .age(57)
        .birthDate(LocalDate.of(1963, 10, 1))
        .gender(Gender.MALE.toString())
        .build();
    
    CustomerResponseDTO created = createCustomer(customer);
    
    created.setName("Clesio dos Teclados");
    
    given()
        .contentType("application/json")
        .body(created)
        .pathParam("id", created.getId())
        .when()
        .put("/api/v1/customer/{id}")
        .then()
        .assertThat()
        .statusCode(HttpStatus.OK.value())
        .and()
        .body("name", equalTo("Clesio dos Teclados"))
        .body("age", equalTo(57))
        .body("gender", equalTo("MALE"))
        .body("birthDate", equalTo("1963-10-01"));
  }
  
  @Test
  @Tag("customer-it")
  @DisplayName("When searching for a customer that doesnt exists then make sure return error.")
  public void testFindCustomerByIdThatDoesNotExists() {
    given()
        .contentType("application/json")
        .pathParam("id", 999)
        .when()
        .get("/api/v1/customer/{id}")
        .then()
        .assertThat()
        .statusCode(HttpStatus.NOT_FOUND.value())
        .body("status", equalTo(404))
        .body("title", equalTo("Not found"))
        .body("detail", equalTo("Customer with id 999 does not exists."));
  }
  
  private CustomerResponseDTO createCustomer(CustomerResponseDTO customer) {
    return given()
        .body(customer)
        .contentType("application/json")
        .when()
        .post("/api/v1/customer")
        .as(CustomerResponseDTO.class);
  }
  
}
