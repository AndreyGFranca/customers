package com.github.andreygfranca.customermanager.core.port.output.city;

import com.github.andreygfranca.customermanager.core.domain.City;

public interface CreateCityPort {
  
  City create(City city);
  
}
