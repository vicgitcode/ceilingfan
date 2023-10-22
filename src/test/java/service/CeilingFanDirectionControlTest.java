package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static states.Direction.*;

class CeilingFanDirectionControlTest {

    private final Motor motor = new CeilingFanMotor();
    private final CeilingFanDirectionControl ceilingFanDirectionControl = new CeilingFanDirectionControl(motor);

    @Test
    public void change_direction_to_counterclockwise() {
        assertEquals(CLOCKWISE, this.motor.getCurrentDirection());
        ceilingFanDirectionControl.changeDirection();
        assertEquals(COUNTERCLOCKWISE, this.motor.getCurrentDirection());
    }

    @Test
    public void change_direction_back_to_clockwise() {
        assertEquals(CLOCKWISE, this.motor.getCurrentDirection());
        ceilingFanDirectionControl.changeDirection();
        ceilingFanDirectionControl.changeDirection();
        assertEquals(CLOCKWISE, this.motor.getCurrentDirection());
    }
}