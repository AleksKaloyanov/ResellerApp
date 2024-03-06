package com.resellerapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "TEXT")
    @Length(min = 2, max = 50)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne
    private ConditionEntity condition;
    @ManyToOne
    private UserEntity createdBy;
    @ManyToOne
    private UserEntity boughtBy;

    public OfferEntity() {
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionEntity getCondition() {
        return condition;
    }

    public OfferEntity setCondition(ConditionEntity condition) {
        this.condition = condition;
        return this;
    }

    public UserEntity getBoughtBy() {
        return boughtBy;
    }

    public OfferEntity setBoughtBy(UserEntity boughtBy) {
        this.boughtBy = boughtBy;
        return this;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public OfferEntity setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
