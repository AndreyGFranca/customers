package com.github.andreygfranca.customermanager.adapter.api.v1.mapper;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.city.CityCreateDTO;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.city.CityResponseDTO;
import com.github.andreygfranca.customermanager.core.domain.City;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {
  
  CityResponseDTO toDTO(City city);
  
  City toEntity(CityResponseDTO cityDTO);
  
  City toEntityCreate(CityCreateDTO cityDTO);
  
  List<CityResponseDTO> toListDTO(List<City> cities);
}
