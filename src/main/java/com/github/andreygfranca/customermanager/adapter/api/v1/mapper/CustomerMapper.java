package com.github.andreygfranca.customermanager.adapter.api.v1.mapper;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.CustomerDTO;
import com.github.andreygfranca.customermanager.core.domain.Customer;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  
  CustomerDTO toDTO(Customer customer);
  
  Customer toEntity(CustomerDTO customerDTO);
  
  List<CustomerDTO> toListDTO(List<Customer> customers);
  
}
