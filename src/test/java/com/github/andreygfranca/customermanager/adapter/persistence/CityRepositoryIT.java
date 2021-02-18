package com.github.andreygfranca.customermanager.adapter.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.andreygfranca.customermanager.IntegrationTestBase;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.CityCriteriaDTO;
import com.github.andreygfranca.customermanager.core.domain.City;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("City Persistence Test")
class CityRepositoryIT extends IntegrationTestBase {
  
  @Autowired
  private CityRepository cityRepository;
  
  @Test
  @DisplayName("When find by criteria name should return city")
  public void testFindByCriteriaName() {
    // Given
    CityCriteriaDTO cityCriteria = CityCriteriaDTO.builder()
        .name("Goiania")
        .build();
    City cityPersisted = City.builder()
        .name("Goiania")
        .state("Goias")
        .build();
    cityRepository.save(cityPersisted);
    
    // When
    List<City> cities = cityRepository.findByCriteria(cityCriteria);
    
    // Then
    assertThat(cities)
        .isNotEmpty()
        .hasSize(1)
        .satisfies(it -> assertThat(it.get(0)).isEqualToComparingFieldByField(cityPersisted));
  }
  
  @Test
  @DisplayName("When find by criteria state should return city")
  public void testFindByCriteriaState() {
    // Given
    CityCriteriaDTO cityCriteria = CityCriteriaDTO.builder()
        .state("Goias")
        .build();
    City cityPersisted = City.builder()
        .name("Jatai")
        .state("Goias")
        .build();
    cityRepository.save(cityPersisted);
    
    // When
    List<City> cities = cityRepository.findByCriteria(cityCriteria);
    
    // Then
    assertThat(cities)
        .isNotEmpty()
        .hasSize(1)
        .satisfies(it -> assertThat(it.get(0)).isEqualToComparingFieldByField(cityPersisted));
  }
}
