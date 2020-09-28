package com.seabattle.seabattle.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ship {
    private int id;
    private int state;
    private int x;
    private int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (id != ship.id) return false;
        if (x != ship.x) return false;
        return y == ship.y;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}
