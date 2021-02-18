package com.github.andreygfranca.customermanager.core.usecase.customer;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.CustomerCriteriaDTO;
import com.github.andreygfranca.customermanager.core.domain.Customer;
import com.github.andreygfranca.customermanager.core.usecase.exception.NotFoundException;
import com.github.andreygfranca.customermanager.core.port.input.CustomerPersistencePort;
import com.github.andreygfranca.customermanager.core.port.output.customer.ReadCustomerPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadCustomerUseCase implements ReadCustomerPort {
  
  private final CustomerPersistencePort customerPersistencePort;
  
  @Override
  public Customer findById(Long id) {
    return customerPersistencePort.findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Customer with id %s does not exists.", id.toString())));
  }
  
  @Override
  public List<Customer> search(CustomerCriteriaDTO customerCriteria) {
    return customerPersistencePort.findByCriteria(customerCriteria);
  }
}
