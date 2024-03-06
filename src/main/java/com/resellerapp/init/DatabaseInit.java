package com.resellerapp.init;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.entity.enums.ConditionNameEnum;
import com.resellerapp.repository.ConditionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {
    private final ConditionRepository conditionRepository;

    public DatabaseInit(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (conditionRepository.count() == 0) {
            for (ConditionNameEnum value : ConditionNameEnum.values()) {
                ConditionEntity condition = new ConditionEntity();
                condition.setName(value);

                conditionRepository.save(condition);
            }
        }
    }
}
