package com.vtw.dna.discountPolicy.service;

import com.vtw.dna.discountPolicy.DiscountPolicy;
import com.vtw.dna.discountPolicy.repository.DiscountPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountPolicyService {

    @Autowired
    private DiscountPolicyRepository discountPolicyRepository = null;

    public DiscountPolicy insertDiscountPolicy (DiscountPolicy discountPolicy){

        discountPolicyRepository.save(discountPolicy);

        return discountPolicy;

    }
}
