package com.github.andreygfranca.customermanager.adapter.api.v1.controller;

import com.github.andreygfranca.customermanager.adapter.api.v1.BasePath;
import com.github.andreygfranca.customermanager.adapter.api.v1.ResponseMessages;
import com.github.andreygfranca.customermanager.adapter.api.v1.mapper.CityMapper;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.city.CityCreateDTO;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.city.CityCriteriaDTO;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.city.CityResponseDTO;
import com.github.andreygfranca.customermanager.core.domain.City;
import com.github.andreygfranca.customermanager.core.port.output.city.CreateCityPort;
import com.github.andreygfranca.customermanager.core.port.output.city.DeleteCityPort;
import com.github.andreygfranca.customermanager.core.port.output.city.ReadCityPort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "City")
@RestController
@RequiredArgsConstructor
@RequestMapping(BasePath.BASE_PATH + "city")
public class CityController {
  
  private final CreateCityPort createCityPort;
  private final DeleteCityPort deleteCityPort;
  private final ReadCityPort readCityPort;
  private final CityMapper cityMapper;
  
  @GetMapping("/{id}")
  @ApiOperation(value = "${api.v1.city.operation.find.by.id}")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = ResponseMessages.MESSAGE_200),
      @ApiResponse(code = 404, message = ResponseMessages.MESSAGE_404),
  })
  ResponseEntity<CityResponseDTO> findById(@PathVariable Long id) {
    CityResponseDTO cityDTO = cityMapper.toDTO(readCityPort.findById(id));
    
    return ResponseEntity.ok(cityDTO);
  }
  
  @PostMapping
  @ApiOperation(value = "${api.v1.city.operation.create}")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = ResponseMessages.MESSAGE_201),
  })
  ResponseEntity<CityResponseDTO> create(@Valid @RequestBody CityCreateDTO cityDTO) {
    City city = cityMapper.toEntityCreate(cityDTO);
    
    City cityPersisted = createCityPort.create(city);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(cityMapper.toDTO(cityPersisted));
  }
  
  @DeleteMapping("/{id}")
  @ApiOperation(value = "${api.v1.city.operation.delete}")
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = ResponseMessages.MESSAGE_204),
      @ApiResponse(code = 404, message = ResponseMessages.MESSAGE_404),
  })
  ResponseEntity<Void> delete(@PathVariable Long id) {
    deleteCityPort.delete(id);
    
    return ResponseEntity.noContent().build();
  }
  
  @GetMapping
  @ApiOperation(value = "${api.v1.city.operation.search}")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = ResponseMessages.MESSAGE_200),
      @ApiResponse(code = 404, message = ResponseMessages.MESSAGE_404),
  })
  ResponseEntity<List<CityResponseDTO>> search(@Valid CityCriteriaDTO cityCriteria) {
    List<City> cities = readCityPort.search(cityCriteria);
    
    return ResponseEntity.ok(cityMapper.toListDTO(cities));
  }
  
}
