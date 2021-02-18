package com.github.andreygfranca.customermanager.adapter.api.v1.mapper;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.CityDTO;
import com.github.andreygfranca.customermanager.core.domain.City;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {
  
  CityDTO toDTO(City city);
  
  City toEntity(CityDTO cityDTO);
  
  List<CityDTO> toListDTO(List<City> cities);
}
