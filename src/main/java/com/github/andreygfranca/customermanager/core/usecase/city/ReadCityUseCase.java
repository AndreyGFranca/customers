package com.github.andreygfranca.customermanager.core.usecase.city;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.city.CityCriteriaDTO;
import com.github.andreygfranca.customermanager.core.domain.City;
import com.github.andreygfranca.customermanager.core.port.input.CityPersistencePort;
import com.github.andreygfranca.customermanager.core.port.output.city.ReadCityPort;
import com.github.andreygfranca.customermanager.core.usecase.exception.NotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadCityUseCase implements ReadCityPort {
  
  private final CityPersistencePort cityPersistencePort;
  
  @Override
  public City findById(Long id) {
    return cityPersistencePort.findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("City with id %s does not exists.", id.toString())));
  }
  
  @Override
  public List<City> search(CityCriteriaDTO customerCriteria) {
    return cityPersistencePort.findByCriteria(customerCriteria);
  }
}
