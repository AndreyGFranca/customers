package com.github.andreygfranca.customermanager.core.usecase.customer;

import com.github.andreygfranca.customermanager.core.domain.Customer;
import com.github.andreygfranca.customermanager.core.usecase.exception.NotFoundException;
import com.github.andreygfranca.customermanager.core.port.input.CustomerPersistencePort;
import com.github.andreygfranca.customermanager.core.port.output.customer.UpdateCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCustomerUseCase implements UpdateCustomerPort {
  
  private final CustomerPersistencePort customerPersistencePort;
  
  @Override
  public Customer update(Customer customer, Long id) {
    Customer updatedCustomer = customerPersistencePort.findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Customer with id %s does not exists.", id.toString())));
    
    updatedCustomer.setName(customer.getName());
    updatedCustomer.setAge(customer.getAge());
    updatedCustomer.setBirthDate(customer.getBirthDate());
    updatedCustomer.setCity(customer.getCity());
    updatedCustomer.setGender(customer.getGender());
    
    return customerPersistencePort.update(updatedCustomer);
  }
}
