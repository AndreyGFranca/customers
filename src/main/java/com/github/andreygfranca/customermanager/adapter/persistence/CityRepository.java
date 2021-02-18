package com.github.andreygfranca.customermanager.adapter.persistence;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.CityCriteriaDTO;
import com.github.andreygfranca.customermanager.adapter.persistence.specification.CitySpecificationFactory;
import com.github.andreygfranca.customermanager.core.domain.City;
import com.github.andreygfranca.customermanager.core.port.input.CityPersistencePort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CityRepository implements CityPersistencePort {
  
  private final CityJpaRepository cityJpaRepository;
  
  @Override
  public Optional<City> findById(Long id) {
    return cityJpaRepository.findById(id);
  }
  
  @Override
  public List<City> findAll() {
    return cityJpaRepository.findAll();
  }
  
  @Override
  public City save(City city) {
    return cityJpaRepository.save(city);
  }
  
  @Override
  public City update(City city, Long id) {
    return cityJpaRepository.save(city);
  }
  
  @Override
  public void delete(City city) {
    cityJpaRepository.delete(city);
  }
  
  @Override
  public List<City> findByCriteria(CityCriteriaDTO cityCriteria) {
    return cityJpaRepository.findAll(CitySpecificationFactory.findByCustomerCriteria(cityCriteria));
  }
  
}
