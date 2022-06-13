package com.vtw.dna.discountCondition.service;

import com.vtw.dna.discountCondition.DiscountCondition;
import com.vtw.dna.discountCondition.repository.DiscountConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountConditionService {

    @Autowired
    private DiscountConditionRepository discountConditionRepository = null;

    public DiscountCondition insertDiscountCondition(DiscountCondition discountCondition){

        discountConditionRepository.save(discountCondition);

        return discountCondition;

    }
}
