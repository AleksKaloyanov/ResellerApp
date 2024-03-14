package com.resellerapp.model.view;

import java.math.BigDecimal;

public class BoughtOfferViewModel {
    private Long id;
    private String description;
    private BigDecimal price;

    public BoughtOfferViewModel() {
    }

    public Long getId() {
        return id;
    }

    public BoughtOfferViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BoughtOfferViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BoughtOfferViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
