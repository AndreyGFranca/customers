package com.github.andreygfranca.customermanager.core.port.output.customer;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.CustomerCriteriaDTO;
import com.github.andreygfranca.customermanager.core.domain.Customer;
import java.util.List;

public interface ReadCustomerPort {
  
  Customer findById(Long id);
  
  List<Customer> search(CustomerCriteriaDTO customerCriteria);
}
