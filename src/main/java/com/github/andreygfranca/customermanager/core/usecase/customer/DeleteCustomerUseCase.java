package com.github.andreygfranca.customermanager.core.usecase.customer;

import com.github.andreygfranca.customermanager.core.domain.Customer;
import com.github.andreygfranca.customermanager.core.port.input.CustomerPersistencePort;
import com.github.andreygfranca.customermanager.core.port.output.customer.DeleteCustomerPort;
import com.github.andreygfranca.customermanager.core.usecase.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCustomerUseCase implements DeleteCustomerPort {
  
  private final CustomerPersistencePort customerPersistencePort;
  
  @Override
  public void delete(Long id) {
    Customer customer = customerPersistencePort.findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Customer with id %s does not exists.", id.toString())));
    
    customerPersistencePort.delete(customer);
  }
}
