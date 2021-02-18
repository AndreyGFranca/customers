package com.github.andreygfranca.customermanager.core.usecase.customer;

import com.github.andreygfranca.customermanager.core.domain.Customer;
import com.github.andreygfranca.customermanager.core.port.input.CustomerPersistencePort;
import com.github.andreygfranca.customermanager.core.port.output.customer.CreateCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCustomerUseCase implements CreateCustomerPort {
  
  private final CustomerPersistencePort customerPersistencePort;
  
  @Override
  public Customer create(Customer customer) {
    return customerPersistencePort.save(customer);
  }
}
