package com.seabattle.seabattle;


import com.seabattle.seabattle.repository.FieldRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PreSet {

    @Autowired
    private FieldRepo fieldRepo;

    @PostConstruct
    void loadPreSetDB() {
        fieldRepo.resetShips();
    }
}
