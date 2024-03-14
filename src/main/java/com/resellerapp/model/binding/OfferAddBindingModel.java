package com.resellerapp.model.binding;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.entity.enums.ConditionNameEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OfferAddBindingModel {
    @Size(min = 2,max = 50,message = "Description length must be between 2 and 50 characters!")
    private String description;
    @Positive
    @NotNull
    private BigDecimal price;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ConditionNameEnum condition;

    public OfferAddBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public OfferAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public OfferAddBindingModel setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }
}
