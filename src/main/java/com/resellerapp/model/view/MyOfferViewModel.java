package com.resellerapp.model.view;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.entity.enums.ConditionNameEnum;

import java.math.BigDecimal;

public class MyOfferViewModel {
    private Long id;
    private ConditionEntity condition;
    private BigDecimal price;
    private String description;

    public MyOfferViewModel() {
    }

    public ConditionEntity getCondition() {
        return condition;
    }

    public MyOfferViewModel setCondition(ConditionEntity condition) {
        this.condition = condition;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MyOfferViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MyOfferViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getId() {
        return id;
    }

    public MyOfferViewModel setId(Long id) {
        this.id = id;
        return this;
    }
}
