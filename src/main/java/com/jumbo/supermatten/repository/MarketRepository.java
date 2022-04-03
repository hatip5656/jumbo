package com.jumbo.supermatten.repository;

import com.jumbo.supermatten.model.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market,Long> {

}
