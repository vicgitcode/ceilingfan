package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static states.Speed.*;

class CeilingFanSpeedControlTest {

    private final Motor motor = new CeilingFanMotor();
    private final CeilingFanSpeedControl ceilingFanSpeedControl = new CeilingFanSpeedControl(motor);

    @Test
    public void change_speed_to_speed1() {
        assertEquals(SPEED_0, this.motor.getCurrentSpeed());
        ceilingFanSpeedControl.changeSpeed();
        assertEquals(SPEED_1, this.motor.getCurrentSpeed());
    }

    @Test
    public void change_speed_to_speed2() {
        assertEquals(SPEED_0, this.motor.getCurrentSpeed());
        ceilingFanSpeedControl.changeSpeed();
        ceilingFanSpeedControl.changeSpeed();
        assertEquals(SPEED_2, this.motor.getCurrentSpeed());
    }

    @Test
    public void change_speed_to_speed3() {
        assertEquals(SPEED_0, this.motor.getCurrentSpeed());
        ceilingFanSpeedControl.changeSpeed();
        ceilingFanSpeedControl.changeSpeed();
        ceilingFanSpeedControl.changeSpeed();
        assertEquals(SPEED_3, this.motor.getCurrentSpeed());
    }

    @Test
    public void change_speed_back_to_speed0() {
        assertEquals(SPEED_0, this.motor.getCurrentSpeed());
        ceilingFanSpeedControl.changeSpeed();
        ceilingFanSpeedControl.changeSpeed();
        ceilingFanSpeedControl.changeSpeed();
        ceilingFanSpeedControl.changeSpeed();
        assertEquals(SPEED_0, this.motor.getCurrentSpeed());
    }
}