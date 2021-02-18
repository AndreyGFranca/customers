package com.github.andreygfranca.customermanager.core.port.output.customer;

import com.github.andreygfranca.customermanager.core.domain.Customer;

public interface UpdateCustomerPort {
  Customer update(Customer customer, Long id);
}
