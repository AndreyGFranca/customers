package com.github.andreygfranca.customermanager.adapter.persistence.specification;

import com.github.andreygfranca.customermanager.adapter.api.v1.model.city.CityCriteriaDTO;
import com.github.andreygfranca.customermanager.core.domain.City;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class CitySpecificationFactory {
  
  public static Specification<City> findByCustomerCriteria(CityCriteriaDTO cityCriteriaDTO) {
    return (root, criteriaQuery, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();
      
      if (cityCriteriaDTO.getName() != null) {
        predicates.add(criteriaBuilder.like(
            root.get("name"), String.format("%%%s%%", cityCriteriaDTO.getName())));
      }
      
      if (cityCriteriaDTO.getState() != null) {
        predicates.add(criteriaBuilder.like(
            root.get("state"), String.format("%%%s%%", cityCriteriaDTO.getState())));
      }
      
      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
  }
}
