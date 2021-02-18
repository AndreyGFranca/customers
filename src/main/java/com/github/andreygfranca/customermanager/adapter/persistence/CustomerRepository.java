package com.github.andreygfranca.customermanager.adapter.persistence;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.CustomerCriteriaDTO;
import com.github.andreygfranca.customermanager.adapter.persistence.specification.CustomerSpecificationFactory;
import com.github.andreygfranca.customermanager.core.domain.Customer;
import com.github.andreygfranca.customermanager.core.port.input.CustomerPersistencePort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerRepository implements CustomerPersistencePort {
  
  private final CustomerJpaRepository customerJpaRepository;
  
  @Override
  public Optional<Customer> findById(Long id) {
    return customerJpaRepository.findById(id);
  }
  
  @Override
  public List<Customer> findAll() {
    return customerJpaRepository.findAll();
  }
  
  @Override
  public Customer save(Customer customer) {
    return customerJpaRepository.save(customer);
  }
  
  @Override
  public Customer update(Customer customer) {
    return customerJpaRepository.save(customer);
  }
  
  @Override
  public void delete(Customer customer) {
    customerJpaRepository.delete(customer);
  }
  
  @Override
  public List<Customer> findByCriteria(CustomerCriteriaDTO customerCriteria) {
    return customerJpaRepository.findAll(CustomerSpecificationFactory.findByCustomerCriteria(customerCriteria));
  }
}
