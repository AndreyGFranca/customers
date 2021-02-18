package com.github.andreygfranca.customermanager.core.usecase.city;

import com.github.andreygfranca.customermanager.core.domain.City;
import com.github.andreygfranca.customermanager.core.port.input.CityPersistencePort;
import com.github.andreygfranca.customermanager.core.port.output.city.CreateCityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCityUseCase implements CreateCityPort {
  
  private final CityPersistencePort cityPersistencePort;
  
  @Override
  public City create(City city) {
    return cityPersistencePort.save(city);
  }
}
