package com.github.andreygfranca.customermanager.adapter.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.andreygfranca.customermanager.IntegrationTestBase;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.customer.CustomerCriteriaDTO;
import com.github.andreygfranca.customermanager.core.domain.Customer;
import com.github.andreygfranca.customermanager.core.domain.Gender;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("Customer Persistence Test")
class CustomerRepositoryIT extends IntegrationTestBase {
  
  @Autowired
  private CustomerRepository customerRepository;
  
  @Test
  @DisplayName("When find customer by id then return customer")
  void testPersistCityWithCustomer() {
    // Given
    Customer customerPersisted = customerRepository.save(Customer.builder()
        .gender(Gender.MALE)
        .name("Joseph Tadd")
        .age(25)
        .build());
    
    // When
    Customer customer = customerRepository.findById(customerPersisted.getId()).get();
    
    // Then
    assertThat(customer).satisfies(it -> {
      assertThat(it).isNotNull();
      assertThat(it.getId()).isNotNull();
      assertThat(it.getAge()).isEqualTo(customerPersisted.getAge());
      assertThat(it.getBirthDate()).isEqualTo(customerPersisted.getBirthDate());
    });
  }
  
  @Test
  @DisplayName("When find by criteria name should return customer")
  void testFindByCriteriaName() {
    // Given
    Customer customerPersisted = customerRepository.save(Customer.builder()
        .gender(Gender.MALE)
        .name("Joseph Tadd")
        .age(25)
        .build());
    CustomerCriteriaDTO criteria = CustomerCriteriaDTO.builder()
        .name("Joseph")
        .build();
    
    // When
    List<Customer> customer = customerRepository.findByCriteria(criteria);
    
    // Then
    assertThat(customer)
        .isNotEmpty()
        .satisfies(it -> assertThat(it.get(0)).isEqualToComparingFieldByField(customerPersisted));
  }
  
}
