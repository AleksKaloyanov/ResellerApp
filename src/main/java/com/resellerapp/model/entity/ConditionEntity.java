package com.resellerapp.model.entity;

import com.resellerapp.model.entity.enums.ConditionNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
public class ConditionEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ConditionNameEnum name;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    public ConditionEntity() {
    }

    public ConditionNameEnum getName() {
        return name;
    }

    public ConditionEntity setName(ConditionNameEnum name) {
        this.name = name;
        this.setDescription(name);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ConditionEntity setDescription(String description) {
        this.description = description;
        return this;
    }


    public ConditionEntity setDescription(ConditionNameEnum name) {
        String description = "";

        switch (name) {
            case EXCELLENT -> description = "In perfect condition";
            case GOOD -> description = "Some signs of wear and tear or minor defects";
            case ACCEPTABLE -> description = "The item is fairly worn but continues to function properly";
        }

        this.description = description;

        return this;
    }
}
