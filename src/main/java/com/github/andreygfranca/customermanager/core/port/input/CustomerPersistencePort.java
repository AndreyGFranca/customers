package com.github.andreygfranca.customermanager.core.port.input;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerCriteriaDTO;
import com.github.andreygfranca.customermanager.core.domain.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerPersistencePort {
  
  Optional<Customer> findById(Long id);
  
  List<Customer> findAll();
  
  Customer save(Customer customer);
  
  Customer update(Customer customer);
  
  void delete(Customer customer);
  
  List<Customer> findByCriteria(CustomerCriteriaDTO customerCriteria);
  
}
