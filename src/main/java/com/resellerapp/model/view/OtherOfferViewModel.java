package com.resellerapp.model.view;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.entity.UserEntity;

import java.math.BigDecimal;

public class OtherOfferViewModel {
    private Long id;
    private ConditionEntity condition;
    private BigDecimal price;
    private String description;
    private UserEntity createdBy;

    public OtherOfferViewModel() {
    }

    public Long getId() {
        return id;
    }

    public OtherOfferViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public ConditionEntity getCondition() {
        return condition;
    }

    public OtherOfferViewModel setCondition(ConditionEntity condition) {
        this.condition = condition;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OtherOfferViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OtherOfferViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public OtherOfferViewModel setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
