package com.seabattle.seabattle.repository;

import com.seabattle.seabattle.entity.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.seabattle.seabattle.repository.ShipRepo.SHIP_MAPPER;

@Repository
public class ShipRepoImpl implements ShipRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Ship> getShips() {
        String sql = "SELECT * FROM testdb.ship limit 1";
        return jdbcTemplate.query(sql, SHIP_MAPPER);
    }



}

