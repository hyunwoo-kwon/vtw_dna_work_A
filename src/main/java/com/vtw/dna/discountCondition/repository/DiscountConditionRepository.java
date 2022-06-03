package com.vtw.dna.discountCondition.repository;

import com.vtw.dna.discountCondition.DiscountCondition;
import com.vtw.dna.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountConditionRepository extends JpaRepository<DiscountCondition, Long> {

}
