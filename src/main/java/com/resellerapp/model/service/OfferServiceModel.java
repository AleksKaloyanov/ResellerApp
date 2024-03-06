package com.resellerapp.model.service;

import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.model.entity.enums.ConditionNameEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OfferServiceModel {
    @Size(min = 2,max = 50,message = "Description length must be between 2 and 50 characters!")
    private String description;
    @Positive
    @NotNull
    private BigDecimal price;
    @NotNull
    private ConditionNameEnum condition;
    private UserEntity createdBy;

    public OfferServiceModel() {
    }

    public String getDescription() {
        return description;
    }

    public OfferServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public OfferServiceModel setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public OfferServiceModel setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
