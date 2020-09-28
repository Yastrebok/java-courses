package com.seabattle.seabattle.repository;

import com.seabattle.seabattle.entity.Ship;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;


public interface ShipRepo {

    List<Ship> getShips();

    RowMapper<Ship> SHIP_MAPPER = (ResultSet resultSet, int row) -> {
        Ship ship = new Ship();
        ship.setId(resultSet.getInt("id"));
        ship.setX(resultSet.getInt("x"));
        ship.setY(resultSet.getInt("y"));
        ship.setState(resultSet.getInt("State"));
        return ship;
    };


}
