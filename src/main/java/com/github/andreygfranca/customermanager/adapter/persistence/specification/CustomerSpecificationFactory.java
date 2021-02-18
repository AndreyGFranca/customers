package com.github.andreygfranca.customermanager.adapter.persistence.specification;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.CustomerCriteriaDTO;
import com.github.andreygfranca.customermanager.core.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecificationFactory {
  
  public static Specification<Customer> findByCustomerCriteria(CustomerCriteriaDTO customerCriteria) {
    return (root, criteriaQuery, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();
      
      if (customerCriteria.getName() != null) {
        predicates.add(criteriaBuilder.like(
            root.get("name"), String.format("%%%s%%", customerCriteria.getName())));
      }
      
      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
  }
}
