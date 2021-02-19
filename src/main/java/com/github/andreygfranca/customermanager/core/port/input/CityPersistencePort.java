package com.github.andreygfranca.customermanager.core.port.input;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.city.CityCriteriaDTO;
import com.github.andreygfranca.customermanager.core.domain.City;
import java.util.List;
import java.util.Optional;

public interface CityPersistencePort {
  
  Optional<City> findById(Long id);
  
  List<City> findAll();
  
  City save(City city);
  
  City update(City city, Long id);
  
  void delete(City city);
  
  List<City> findByCriteria(CityCriteriaDTO cityCriteria);
}
