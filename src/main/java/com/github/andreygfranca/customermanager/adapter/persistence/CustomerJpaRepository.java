package com.github.andreygfranca.customermanager.adapter.persistence;

import com.github.andreygfranca.customermanager.core.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
}
