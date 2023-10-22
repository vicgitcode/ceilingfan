package service;

import static states.Direction.*;

/**
 * Direction Control implementation for Ceiling Fan.
 * Direction changes are apply to the motor provided in the constructor in the following manner:
 *     Clockwise -> Counterclockwise -> Clockwise
 */
public class CeilingFanDirectionControl implements DirectionControl {

    private Motor motor;

    /**
     * Initialize the CeilingFanDirectionControl with a provided Motor
     * @param motor the motor to be controlled by the CeilingFanDirectionControl
     */
    public CeilingFanDirectionControl(Motor motor) {
        this.motor = motor;
    }

    /**
     * Changes Direction of Motor in the following manner:
     *     Clockwise -> Counterclockwise -> Clockwise
     */
    public void changeDirection() {
        this.motor.changeDirection(this.motor.getCurrentDirection() == CLOCKWISE ? COUNTERCLOCKWISE : CLOCKWISE);
    }
}
