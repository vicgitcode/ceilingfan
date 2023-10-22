package service;

import states.Direction;
import states.Speed;

import static states.Direction.*;
import static states.Speed.*;

/**
 * Motor implementation for Ceiling Fan.
 * Doesn't really do much other than simulating the fan motor.
 */
public class CeilingFanMotor implements Motor {

    private Speed speed = SPEED_0;
    private Direction direction = CLOCKWISE;

    public CeilingFanMotor() {
    }

    /**
     * Change the motor speed with the provided speed
     * @param speed the given speed
     */
    public void changeSpeed(Speed speed) {
        this.speed = speed;
    }

    /**
     * Change the motor direction with the provided direction
     * @param direction the give direction
     */
    public void changeDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Return the current motor speed
     * @return the current motor speed
     */
    public Speed getCurrentSpeed() {
        return this.speed;
    }

    /**
     * Return the current motor direction
     * @return the current motor direction
     */
    public Direction getCurrentDirection() {
        return this.direction;
    }
}
