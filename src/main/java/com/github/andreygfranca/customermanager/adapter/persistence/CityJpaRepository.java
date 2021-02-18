package com.github.andreygfranca.customermanager.adapter.persistence;

import com.github.andreygfranca.customermanager.core.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CityJpaRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {
}
