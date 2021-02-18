package com.github.andreygfranca.customermanager.core.usecase.city;

import com.github.andreygfranca.customermanager.core.port.input.CityPersistencePort;
import com.github.andreygfranca.customermanager.core.port.output.city.DeleteCityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCityUseCase implements DeleteCityPort {
  
  private final CityPersistencePort cityPersistencePort;
  
  @Override
  public void delete(Long id) {
    cityPersistencePort.findById(id).ifPresent(cityPersistencePort::delete);
  }
}
