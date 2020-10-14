package com.seabattle.seabattle.repository;

import com.seabattle.seabattle.entity.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

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
        int totalSize = 5;
        Set<String> checkList = new HashSet<>();
        Set<String> blockList = new HashSet<>();
        int it = 0;
        int sizeBlockList = 0;
        int x = random.nextInt(5) + 1;
        int y = random.nextInt(5) + 1;
        blockList.add("" + x + y);
        checkList.add("" + x + y);
        blockList.addAll(getBlockedPoint(x, y, totalSize));

        while (it < 3) {
            x = random.nextInt(5) + 1;
            y = random.nextInt(5) + 1;
            for (String s : blockList) {
                if (s.equals("" + x + y)) {
                    break;
                } else {
                    sizeBlockList++;
                }
            }
            if (sizeBlockList == blockList.size()) {
                blockList.add("" + x + y);
                blockList.addAll(getBlockedPoint(x, y, totalSize));
                checkList.add("" + x + y);
                it++;
            }
            sizeBlockList = 0;
        }
        it = 0;
        String sX;
        Iterator value = checkList.iterator();
        while (value.hasNext()) {
            sX = value.next().toString();
            x = Integer.valueOf(sX.substring(0,1));
            y = Integer.valueOf(sX.substring(1,2));
            Ship ship = new Ship();
            ship.setId(it);
            ship.setX(alphabet.substring(x - 1, x));
            ship.setY(y);
            ship.setState(0);
            putShip(ship);
            it++;
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

    public static Set<String> getBlockedPoint(int x, int y, int totalSize) {
        Set<String> blockList2 = new HashSet<>();
        if (x == 1) {
            if (y == 1) {
                blockList2.add("" + (x + 1) + y);
                blockList2.add("" + (x + 1) + (y + 1));
                blockList2.add("" + (x) + (y + 1));
            } else {
                if (y > 1 && y < totalSize) {
                    blockList2.add("" + (x + 1) + y);
                    blockList2.add("" + (x + 1) + (y + 1));
                    blockList2.add("" + (x) + (y + 1));
                    blockList2.add("" + (x) + (y - 1));
                    blockList2.add("" + (x + 1) + (y - 1));
                } else {
                    blockList2.add("" + (x + 1) + y);
                    blockList2.add("" + (x) + (y - 1));
                    blockList2.add("" + (x + 1) + (y - 1));
                }
            }
        } else {
            if (x > 1 && x < totalSize) {
                if (y == 1) {
                    blockList2.add("" + (x + 1) + y);
                    blockList2.add("" + (x + 1) + (y + 1));
                    blockList2.add("" + (x) + (y + 1));
                    blockList2.add("" + (x - 1) + (y + 1));
                    blockList2.add("" + (x - 1) + (y));
                } else {
                    if (y > 1 && y < totalSize) {
                        blockList2.add("" + (x + 1) + y);
                        blockList2.add("" + (x + 1) + (y + 1));
                        blockList2.add("" + (x) + (y + 1));
                        blockList2.add("" + (x - 1) + (y + 1));
                        blockList2.add("" + (x - 1) + (y));
                        blockList2.add("" + (x - 1) + (y - 1));
                        blockList2.add("" + (x) + (y - 1));
                        blockList2.add("" + (x + 1) + (y - 1));
                    } else {
                        blockList2.add("" + (x + 1) + y);
                        blockList2.add("" + (x - 1) + (y));
                        blockList2.add("" + (x - 1) + (y - 1));
                        blockList2.add("" + (x) + (y - 1));
                        blockList2.add("" + (x + 1) + (y - 1));
                    }
                }
            } else {
                if (y == 1) {
                    blockList2.add("" + (x) + (y + 1));
                    blockList2.add("" + (x - 1) + (y + 1));
                    blockList2.add("" + (x - 1) + (y));
                } else {
                    if (y > 1 && y < totalSize) {
                        blockList2.add("" + (x) + (y + 1));
                        blockList2.add("" + (x - 1) + (y + 1));
                        blockList2.add("" + (x - 1) + (y));
                        blockList2.add("" + (x - 1) + (y - 1));
                        blockList2.add("" + (x) + (y - 1));
                    } else {
                        blockList2.add("" + (x - 1) + (y));
                        blockList2.add("" + (x - 1) + (y - 1));
                        blockList2.add("" + (x) + (y - 1));
                    }
                }
            }
        }
        return blockList2;
    }
}

