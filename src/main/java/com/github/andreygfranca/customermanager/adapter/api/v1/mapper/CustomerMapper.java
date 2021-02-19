package com.github.andreygfranca.customermanager.adapter.api.v1.mapper;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerCreateDTO;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerResponseDTO;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerUpdateDTO;
import com.github.andreygfranca.customermanager.core.domain.Customer;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  
  CustomerResponseDTO toDTO(Customer customer);
  
  Customer toEntityUpdate(CustomerUpdateDTO customer);
  
  Customer toEntity(CustomerResponseDTO customerDTO);
  
  Customer toEntityCreate(CustomerCreateDTO customerResponseDTO);
  
  List<CustomerResponseDTO> toListDTO(List<Customer> customers);
  
}
