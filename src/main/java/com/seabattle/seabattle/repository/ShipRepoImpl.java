package com.seabattle.seabattle.repository;

import com.seabattle.seabattle.entity.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Repository
public class ShipRepoImpl implements ShipRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Ship> getShips() {
        String sql = "SELECT * FROM ship";
        return jdbcTemplate.query(sql, SHIP_MAPPER);
    }

    @Override
    public Optional<Ship> getShipByXY(String x, Integer y) {
        try {
            return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM ship where x = ? and y = ?", SHIP_MAPPER, x.toUpperCase(), y));
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void setUpShips() {

        jdbcTemplate.execute("delete from ship");
        Random random = new Random();
        String alphabet = "ABCDE";

        for (int i = 1; i < 5; i++) {
            Ship ship = new Ship();
            ship.setId(i);
            ship.setX(String.valueOf(alphabet.charAt(random.nextInt(alphabet.length()))));
            ship.setY(random.nextInt(5));
            ship.setState(0);
            putShip(ship);
        }


    }

    @Override
    public void putShip(Ship ship) {
        jdbcTemplate.execute("insert into ship (id, x, y, state) values(" + ship.getId() + ",'" + ship.getX() + "'," + ship.getY() + "," + ship.getState() + ")");
    }

    @Override
    public void update(Ship ship) {
        jdbcTemplate.update("UPDATE ship SET x = ?, y = ?, state = ? WHERE id = ?", ship.getX(), ship.getY(), ship.getState(), ship.getId());
    }
}

