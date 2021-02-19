package com.github.andreygfranca.customermanager.core.usecase.customer;

import static org.mockito.ArgumentMatchers.any;

import com.github.andreygfranca.customermanager.core.domain.Customer;
import com.github.andreygfranca.customermanager.core.port.input.CustomerPersistencePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateCustomerUseCaseTest {
  
  @InjectMocks
  private CreateCustomerUseCase createCustomerUseCase;
  
  @Mock
  private CustomerPersistencePort customerPersistencePort;
  
  @Test
  @DisplayName("When create then verify")
  public void testCreateCustomer() {
    // Given
    Customer customer = Customer.builder().id(1L).name("Andrey").build();
    
    BDDMockito.given(customerPersistencePort.save(any())).willReturn(customer);
    
    // When
    createCustomerUseCase.create(customer);
    
    // Then
    BDDMockito.verify(customerPersistencePort).save(any());
    
  }
  
}
