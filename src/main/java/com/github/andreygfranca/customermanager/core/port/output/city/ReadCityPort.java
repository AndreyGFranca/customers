package com.github.andreygfranca.customermanager.core.port.output.city;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.CityCriteriaDTO;
import com.github.andreygfranca.customermanager.core.domain.City;
import java.util.List;

public interface ReadCityPort {
  
  City findById(Long id);
  
  List<City> search(CityCriteriaDTO cityCriteria);
}
