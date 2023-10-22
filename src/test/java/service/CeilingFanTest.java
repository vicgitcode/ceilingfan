package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static states.Direction.*;
import static states.Speed.*;

class CeilingFanTest {

    CeilingFan ceilingFan = new CeilingFan();

    @Test
    public void pull_speed_cord_one_time() throws InterruptedException {
        assertEquals(SPEED_0, ceilingFan.getCurrentFanSpeed());
        ceilingFan.pullSpeedCord();
        Thread.sleep(100);
        assertEquals(SPEED_1, ceilingFan.getCurrentFanSpeed());
    }

    @Test
    public void pull_speed_cord_two_times() throws InterruptedException {
        assertEquals(SPEED_0, ceilingFan.getCurrentFanSpeed());
        ceilingFan.pullSpeedCord();
        ceilingFan.pullSpeedCord();
        Thread.sleep(100);
        assertEquals(SPEED_2, ceilingFan.getCurrentFanSpeed());
    }

    @Test
    public void pull_speed_cord_three_times() throws InterruptedException {
        assertEquals(SPEED_0, ceilingFan.getCurrentFanSpeed());
        ceilingFan.pullSpeedCord();
        ceilingFan.pullSpeedCord();
        ceilingFan.pullSpeedCord();
        Thread.sleep(100);
        assertEquals(SPEED_3, ceilingFan.getCurrentFanSpeed());
    }

    @Test
    public void pull_speed_cord_four_times() throws InterruptedException {
        assertEquals(SPEED_0, ceilingFan.getCurrentFanSpeed());
        ceilingFan.pullSpeedCord();
        ceilingFan.pullSpeedCord();
        ceilingFan.pullSpeedCord();
        ceilingFan.pullSpeedCord();
        Thread.sleep(100);
        assertEquals(SPEED_0, ceilingFan.getCurrentFanSpeed());
    }

    @Test
    public void pull_direction_cord_one_time() throws InterruptedException {
        assertEquals(CLOCKWISE, ceilingFan.getCurrentFanDirection());
        ceilingFan.pullDirectionCord();
        Thread.sleep(100);
        assertEquals(COUNTERCLOCKWISE, ceilingFan.getCurrentFanDirection());
    }

    @Test
    public void pull_direction_cord_two_times() throws InterruptedException {
        assertEquals(CLOCKWISE, ceilingFan.getCurrentFanDirection());
        ceilingFan.pullDirectionCord();
        ceilingFan.pullDirectionCord();
        Thread.sleep(100);
        assertEquals(CLOCKWISE, ceilingFan.getCurrentFanDirection());
    }
}