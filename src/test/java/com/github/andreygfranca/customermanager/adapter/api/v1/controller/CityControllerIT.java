package com.github.andreygfranca.customermanager.adapter.api.v1.controller;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.github.andreygfranca.customermanager.IntegrationTestBase;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.CityDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

@DisplayName("City Integration Test")
class CityControllerIT extends IntegrationTestBase {
  
  @Test
  @Tag("city-it")
  @DisplayName("When creating a new city then make sure it was actually created.")
  public void testCreateCity() {
    CityDTO city = CityDTO.builder()
        .name("Jatai")
        .state("Goias")
        .build();
    
    given()
        .body(city)
        .contentType("application/json")
        .when()
        .post("/api/v1/city")
        .then()
        .assertThat()
        .statusCode(HttpStatus.CREATED.value())
        .and()
        .body("name", equalTo("Jatai"))
        .body("state", equalTo("Goias"));
  }
  
  @Test
  @Tag("city-it")
  @DisplayName("When searching for a city by id then make sure it was found.")
  public void testFindCityById() {
    CityDTO city = CityDTO.builder()
        .name("Jatai")
        .state("Goias")
        .build();
    
    CityDTO created = createCity(city);
    
    given()
        .contentType("application/json")
        .pathParam("id", created.getId())
        .when()
        .get("/api/v1/city/{id}")
        .then()
        .assertThat()
        .statusCode(HttpStatus.OK.value())
        .and()
        .body("name", equalTo("Jatai"))
        .body("state", equalTo("Goias"));
  }
  
  @Test
  @Tag("city-it")
  @DisplayName("When deleting a city then ensure that will not be able to find that client again.")
  public void testDeleteCity() {
    CityDTO city = CityDTO.builder()
        .name("Jatai")
        .state("Goias")
        .build();
    
    CityDTO created = createCity(city);
    
    given()
        .contentType("application/json")
        .pathParam("id", created.getId())
        .when()
        .delete("/api/v1/city/{id}")
        .then()
        .assertThat()
        .statusCode(HttpStatus.NO_CONTENT.value());
    
    given()
        .contentType("application/json")
        .pathParam("id", created.getId())
        .when()
        .get("/api/v1/city/{id}")
        .then()
        .assertThat()
        .statusCode(HttpStatus.NOT_FOUND.value())
        .body("status", equalTo(404))
        .body("title", equalTo("Not found"))
        .body("detail", equalTo("City with id " +created.getId() + " does not exists."));
  }
  
  @Test
  @Tag("city-it")
  @DisplayName("When find a city by name then ensure that will return.")
  public void testFindCityByName() {
    CityDTO city = CityDTO.builder()
        .name("Rio Verde")
        .state("Goias")
        .build();
  
    CityDTO created = createCity(city);
  
    given()
        .contentType("application/json")
        .queryParam("name", "Rio Verde")
        .when()
        .get("/api/v1/city")
        .then()
        .assertThat()
        .statusCode(HttpStatus.OK.value())
        .and()
        .body("name[0]", equalTo("Rio Verde"))
        .body("state[0]", equalTo("Goias"));
  }
  
  @Test
  @Tag("city-it")
  @DisplayName("When find a city by state then ensure that will return.")
  public void testFindCityByState() {
    CityDTO city = CityDTO.builder()
        .name("Jatai")
        .state("Goias")
        .build();
  
    CityDTO created = createCity(city);
  
    given()
        .contentType("application/json")
        .queryParam("state", "Goias")
        .when()
        .get("/api/v1/city")
        .then()
        .assertThat()
        .statusCode(HttpStatus.OK.value())
        .and()
        .body("name[0]", equalTo("Jatai"))
        .body("state[0]", equalTo("Goias"));
  }
  
  private CityDTO createCity(CityDTO city) {
    return given()
        .body(city)
        .contentType("application/json")
        .when()
        .post("/api/v1/city")
        .as(CityDTO.class);
  }
  
}
