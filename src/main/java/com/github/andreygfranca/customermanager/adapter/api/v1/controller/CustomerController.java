package com.github.andreygfranca.customermanager.adapter.api.v1.controller;

import com.github.andreygfranca.customermanager.adapter.api.v1.BasePath;
import com.github.andreygfranca.customermanager.adapter.api.v1.ResponseMessages;
import com.github.andreygfranca.customermanager.adapter.api.v1.mapper.CustomerMapper;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerCreateDTO;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerCriteriaDTO;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerResponseDTO;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerUpdateDTO;
import com.github.andreygfranca.customermanager.core.domain.Customer;
import com.github.andreygfranca.customermanager.core.port.output.customer.CreateCustomerPort;
import com.github.andreygfranca.customermanager.core.port.output.customer.DeleteCustomerPort;
import com.github.andreygfranca.customermanager.core.port.output.customer.ReadCustomerPort;
import com.github.andreygfranca.customermanager.core.port.output.customer.UpdateCustomerPort;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Customer")
@RestController
@RequiredArgsConstructor
@RequestMapping(BasePath.BASE_PATH + "customer")
public class CustomerController {
  
  private final CustomerMapper customerMapper;
  private final CreateCustomerPort createCustomerPort;
  private final ReadCustomerPort readCustomerPort;
  private final DeleteCustomerPort deleteCustomerPort;
  private final UpdateCustomerPort updateCustomerPort;
  
  @GetMapping("/{id}")
  @ApiOperation(value = "${api.v1.customer.operation.find.by.id}")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = ResponseMessages.MESSAGE_200),
      @ApiResponse(code = 404, message = ResponseMessages.MESSAGE_404),
  })
  ResponseEntity<CustomerResponseDTO> findById(@PathVariable Long id) {
    CustomerResponseDTO customerResponseDTO = customerMapper.toDTO(readCustomerPort.findById(id));
    
    return ResponseEntity.ok(customerResponseDTO);
  }
  
  @PostMapping
  @ApiOperation(value = "${api.v1.customer.operation.create}")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = ResponseMessages.MESSAGE_201),
  })
  ResponseEntity<CustomerResponseDTO> create(@Valid @RequestBody CustomerCreateDTO customerResponseDTO) {
    Customer customer = customerMapper.toEntityCreate(customerResponseDTO);
    
    Customer customerCreated = createCustomerPort.create(customer);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(customerMapper.toDTO(customerCreated));
  }
  
  @DeleteMapping("/{id}")
  @ApiOperation(value = "${api.v1.customer.operation.delete}")
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = ResponseMessages.MESSAGE_204),
      @ApiResponse(code = 404, message = ResponseMessages.MESSAGE_404),
  })
  ResponseEntity<Void> delete(@PathVariable Long id) {
    deleteCustomerPort.delete(id);
    
    return ResponseEntity.noContent().build();
  }
  
  @PutMapping("/{id}")
  @ApiOperation(value = "${api.v1.customer.operation.update}")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = ResponseMessages.MESSAGE_200),
      @ApiResponse(code = 404, message = ResponseMessages.MESSAGE_404),
  })
  ResponseEntity<CustomerResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CustomerUpdateDTO customerDTO) {
    Customer customer = customerMapper.toEntityUpdate(customerDTO);
    
    Customer customerUpdated = updateCustomerPort.update(customer, id);
    
    return ResponseEntity.status(HttpStatus.OK).body(customerMapper.toDTO(customerUpdated));
  }
  
  @GetMapping
  @ApiOperation(value = "${api.v1.customer.operation.search}")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = ResponseMessages.MESSAGE_200),
      @ApiResponse(code = 404, message = ResponseMessages.MESSAGE_404),
  })
  ResponseEntity<List<CustomerResponseDTO>> search(@Valid CustomerCriteriaDTO customerCriteria) {
    List<Customer> customers = readCustomerPort.search(customerCriteria);
    
    return ResponseEntity.ok(customerMapper.toListDTO(customers));
  }
  
}
