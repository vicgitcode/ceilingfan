package service;

import states.Speed;

import java.util.HashMap;
import java.util.Map;

import static states.Speed.*;

/**
 * Speed Control implementation for Ceiling Fan.
 * Speed changes are apply to the motor provided in the constructor in the following manner:
 *     0 -> 1 -> 2 -> 3 -> 0
 */
public class CeilingFanSpeedControl implements SpeedControl {

    private Motor motor;

    private final Map<Speed, Speed> speedStatesMap = new HashMap<Speed, Speed>() {{
        put(SPEED_0, SPEED_1);
        put(SPEED_1, SPEED_2);
        put(SPEED_2, SPEED_3);
        put(SPEED_3, SPEED_0);
    }};

    /**
     * Initialize the CeilingFanSpeedControl with a provided Motor
     * @param motor the motor to be controlled by the CeilingFanSpeedControl
     */
    public CeilingFanSpeedControl(Motor motor) {
        this.motor = motor;
    }

    /**
     * Changes Speed of Motor in the following manner:
     *     0 -> 1 -> 2 -> 3 -> 0
     */
    public void changeSpeed() {
        this.motor.changeSpeed(speedStatesMap.get(this.motor.getCurrentSpeed()));

    }
}
