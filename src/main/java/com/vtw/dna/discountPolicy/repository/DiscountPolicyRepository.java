package com.vtw.dna.discountPolicy.repository;

import com.vtw.dna.discountPolicy.DiscountPolicy;
import com.vtw.dna.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountPolicyRepository extends JpaRepository<DiscountPolicy, Long> {

}
