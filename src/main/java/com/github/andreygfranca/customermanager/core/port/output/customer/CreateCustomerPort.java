package com.github.andreygfranca.customermanager.core.port.output.customer;

import com.github.andreygfranca.customermanager.core.domain.Customer;

public interface CreateCustomerPort {
  Customer create(Customer customer);
}
